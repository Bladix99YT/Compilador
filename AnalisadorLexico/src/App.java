import ManipuladorArquivos.Analisador;

public class App {
  public static void main(String[] args) throws Exception {
    Analisador analisador = new Analisador();
    analisador.AnalisarArquivo("AnalisadorLexico\\src\\CodigoFontePascal\\String.pas");
  }
}
