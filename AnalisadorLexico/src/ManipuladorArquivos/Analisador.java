package ManipuladorArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// interface usada na expressão lambda "char function predicado"
interface CharFunction {
    boolean run(char c);
}

public class Analisador {
    private int nLinha = -1;
    private int nColuna = -1;

    // Auxiliar pra não precisar passar a linha como parâmetro
    // Em cada chamada de função
    private String linhaAtual;
    private char caractereAtual;

    private SimbolosAuxiliar simbolos = new SimbolosAuxiliar();

    public void AnalisarArquivo(String caminho) throws IOException {
        // Cada vez que um novo arquivo for analisado, você pode
        // limpar os simbolos da leitura anterior
        simbolos.Limpar();

        try {
            FileReader arquivo = new FileReader(caminho);
            BufferedReader arquivoBuffer = new BufferedReader(arquivo);

            String linha = arquivoBuffer.readLine();

            while (linha != null) {
                this.linhaAtual = linha;
                this.AnalisarLinha(linha);
                linha = arquivoBuffer.readLine();
            }

            arquivo.close();
            arquivoBuffer.close();
        } catch (IOException e) {
            System.err.printf("Erro durante a leitura do arquivo no caminho específicado: %s", e.getMessage());
        }

        simbolos.Listar();
        System.out.println("Leitura completa!");
    }

    private void AnalisarLinha(String linha) {
        nLinha++;
        nColuna = -1;

        // Procura por tokens
        while (nColuna < this.linhaAtual.length()) {
            nColuna++;

            this.IgnorarEspacos();
            this.caractereAtual = this.Proximo();

            // Funcoes pra ler todo tipo de token possivel (Ainda vão ser criadas)
            // ...
            if (this.caractereAtual == '\n') {
                continue;
            }

            if (this.LerComentario()) {
                continue;
            }

            if (Character.isDigit(this.caractereAtual) && this.LerNumero()) {
                continue;
            }

            if (Character.isLetter(this.caractereAtual) && this.LerIdentificador()) {
                continue;
            }

            if (this.caractereAtual == '"' && this.LerString()) {
                continue;
            }

            if (IsPontuacao(this.caractereAtual) && this.LerPontuacao()) {
                continue;
            }

            // Se passar daqui é pq não reconheceu o caractere
            this.Reclamar("Caractere não reconhecido: " + this.Espiar());
        }
    }

    // ################################### Auxiliares
    // ##############################################
    private void IgnorarEspacos() {
        this.LerEnquanto(c -> c == ' ' || c == '\t');
    }

    private String PosicaoAtual() {
        return "Linha: " + (nLinha + 1) + " Coluna: " + (nColuna + 1);
    }

    private void Reclamar(String mensagemDeErro) {
        System.err.println(mensagemDeErro + " em " + this.PosicaoAtual());
    }

    private char Espiar() {
        if (nColuna >= this.linhaAtual.length()) {
            return '\n';
        }
        return this.linhaAtual.charAt(nColuna);
    }

    // incrementa o valor de charat que começa em zero
    private char Proximo() {
        if (this.UltimoIndiceDaLinhaAtual()) {
            return '\n';
        }
        return this.linhaAtual.charAt(nColuna++);
    }

    private char OlharProximo() {
        if (this.UltimoIndiceDaLinhaAtual()) {
            return '\n';
        }
        return this.linhaAtual.charAt(nColuna + 1);
    }

    private boolean UltimoIndiceDaLinhaAtual() {
        return nColuna >= this.linhaAtual.length() - 1;
    }

    // ########################################## Leitores
    // #############################################
    private String LerEnquanto(CharFunction predicado) {
        StringBuilder valido = new StringBuilder();

        while (predicado.run(this.Espiar()) && !this.UltimoIndiceDaLinhaAtual()) {
            valido.append(this.Proximo());
        }

        return valido.toString();
    }

    private String LerAte(CharFunction predicado) {
        StringBuilder valido = new StringBuilder();

        while (!predicado.run(this.Espiar()) && !this.UltimoIndiceDaLinhaAtual()) {
            valido.append(this.Proximo());
        }

        return valido.toString();
    }

    // Retorna true ou false se conseguir ler um comentário
    private boolean LerComentario() {
        if (this.caractereAtual == '/') {
            // Após a chamada de this.Proximo na linha 14
            // indice já foi incrementado, então podemos só
            // retornar o caractere no indice atual para ver qual
            // o próximo
            char proximo = this.OlharProximo();

            // Se forem duas barras seguidas, então temos certeza
            // que isso é um comentário
            if (proximo == '/') {
                this.Proximo();

                // Fim do comentário
                String comentario = this.LerAte(c -> c == '\n');
                // Inserir token dentro da nossa tabela
                simbolos.InserirComentario(comentario);
                return true;
            }

            if (proximo == '*') {
                this.Proximo();

                // Fim do comentário multilinha
                String comentario = this.LerAte(c -> c == '*' && this.OlharProximo() == '/');

                // Inserir token dentro da nossa tabela
                simbolos.InserirComentario(comentario);
                return true;
            }
        }

        return false;
    }

    private boolean LerNumero() {
        StringBuilder numero = new StringBuilder();
        numero.append(this.caractereAtual);

        // Lê enquanto o próximo caractere for um dígito ou ponto
        while ((Character.isDigit(this.Espiar()) || this.Espiar() == '.') && !this.UltimoIndiceDaLinhaAtual()) {
            numero.append(this.Proximo());
        }

        while (Character.isDigit(this.Espiar()) && !this.UltimoIndiceDaLinhaAtual()) {
            numero.append(this.Proximo());
        }

        if (Character.isDigit(this.Espiar()) && this.UltimoIndiceDaLinhaAtual()) {
            numero.append(this.Espiar());
        }

        this.simbolos.InserirNumero(numero.toString());

        return true;
        /**
         * ... codigo em pascal
         * 1234.
         * ... codigo em pascal
         */

        // Verifica se o último caractere é um ponto decimal
        // if (this.Espiar() == '.' && Character.isDigit(this.OlharProximo())) {
        // numero.append(this.Proximo()); // Adiciona o ponto decimal
        // Lê os dígitos após o ponto decimal
        // while (Character.isDigit(this.Espiar())) {
        // numero.append(this.Proximo());
        // }
        // }

    }

    private boolean LerIdentificador() {
        StringBuilder id = new StringBuilder();
        id.append(this.caractereAtual);

        while (Character.isLetter(this.Espiar()) && !this.UltimoIndiceDaLinhaAtual()) {
            id.append(this.Proximo());
        }

        if (Character.isLetter(this.Espiar()) && this.UltimoIndiceDaLinhaAtual()) {
            id.append(this.Espiar());
        }

        simbolos.InserirIdentificador(id.toString());

        return true;
    }

    private boolean LerString() {
        String str = this.LerAte(c -> {
            if (c == '\\' && this.OlharProximo() == '"') {
                this.Proximo();
                return false;
            }

            return c == '"';
        });

        simbolos.InserirString(str);

        return true;
    }

    private boolean LerPontuacao() {
        char[] pontuacaoDeUmDigito = {
                '+', '-', '*', '/', '=', '<',
                '>', '(', ')', '[', ']', ',',
                ';', ':', '.', '^', '|', '@',
                '$', '#', '&', '%'
        };

        if (!this.IsPontuacao(this.OlharProximo())) {
            for (int i = 0; i < pontuacaoDeUmDigito.length; i++) {
                if (this.caractereAtual == pontuacaoDeUmDigito[i]) {
                    simbolos.InserirPontuacaoDeUmDigito(this.caractereAtual);
                    return true;
                }
            }
        }

        StringBuilder pb = new StringBuilder();

        String[] pontuacaoDeDoisOuMaisDigitos = {
                "<=", ">=", "<>", ":=", "..="
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < pontuacaoDeDoisOuMaisDigitos.length; j++) {
                if (pontuacaoDeDoisOuMaisDigitos[j].charAt(i) == pontuacaoDeDoisOuMaisDigitos[i].char) {

                }
            }
        }



        // Tem somente um caso onde pb seria igual a ..,
        // então adiciona ..= a lista de tokens e move o ponteiro para
        // o proximo
        if (pb.toString() == "..") {
            simbolos.InserirPontuacaoDeDoisOuMaisDigitos("..=");
            this.Proximo();
            return true;
        } else {
            simbolos.InserirPontuacaoDeDoisOuMaisDigitos(pb.toString());
            return true;
        }
    }

    // ############################### Helpers ################################
    private boolean IsPontuacao(char c) {
        char[] pontuacao = {
                '+', '-', '*',
                '/', '=', '(',
                ')', '[', ']',
                ',', ';', '{',
                '}', '^', '|',
                '@', '$', '#',
                '&', '%', '<',
                '>', ':'
        };

        // // verificando apenas a pontuação de um caractere (digito)
        for (int i = 0; i < pontuacao.length; i++) {
            if (c == pontuacao[i]) {
                return true;
            }
        }

        // String[] pontuacaoDeDoisOuMaisDigitos = {
        // "<=", ">=", "<>", ":=", "..="
        // };

        return false;
    }
}
