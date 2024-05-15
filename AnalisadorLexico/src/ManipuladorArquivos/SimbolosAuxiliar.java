package ManipuladorArquivos;

import java.util.HashMap;

public class SimbolosAuxiliar {
    private int currentID = 0;

    private TabelaSimbolos tabela = new TabelaSimbolos();
    private HashMap<Integer, Simbolo> simbolos = new HashMap<>();

    private int ProximaID() {
        return ++currentID;
    }

    private Simbolo Inserir(Simbolo simbolo) {
        simbolos.put(this.ProximaID(), simbolo);
        return simbolo;
    }

    public Simbolo InserirComentario(String lexema) {
        lexema = lexema.toLowerCase();
        Simbolo simbolo = new Simbolo(TabelaSimbolos.COMMENT, lexema, ++tabela.end);
        return this.Inserir(simbolo);
    }

    public Simbolo InserirNumero(String lexema) {
        Simbolo simbolo = new Simbolo(TabelaSimbolos.NUMBER, lexema, ++tabela.end);
        return this.Inserir(simbolo);
    }

    public Simbolo InserirIdentificador(String lexema) {
        Simbolo palavraChave = tabela.BuscarSimbolo(lexema);

        if (palavraChave != null)
            return this.Inserir(palavraChave);

        Simbolo id = new Simbolo(TabelaSimbolos.VAR, lexema, ++tabela.end);
        
        return this.Inserir(id);
    }

    public Simbolo InserirString(String lexema) {
        Simbolo str = new Simbolo(TabelaSimbolos.STRING, lexema, ++tabela.end);
        return this.Inserir(str);
    }

    public Simbolo InserirPontuacaoDeUmDigito(char c) {
        Simbolo pont = tabela.BuscarSimbolo(String.valueOf(c));
        return this.Inserir(pont);
    }

    public Simbolo InserirPontuacaoDeDoisOuMaisDigitos(String p) {
        Simbolo pont = tabela.BuscarSimbolo(p);
        return this.Inserir(pont);
    }

    public void Limpar() {
        currentID = 0;
        simbolos.clear();
    }

    public void Listar() {
        System.out.println("\n---------------------------------------");
        for (Integer chave : simbolos.keySet()) {
            Simbolo s = simbolos.get(chave);
            System.out.printf(
                    "\nTipo: %s\nClasse: %s\nEndereço: %s\nLexema: %s\nToken: %s\n",
                    s.getTipo(), s.getClasse(), s.getEndereco(),
                    s.getLexema(), s.getToken());
        }
    }
}