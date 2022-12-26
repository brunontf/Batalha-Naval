import model.Tabuleiro;
import view.Print;

public class App {
    public static void main(String[] args) {
        
        String[][] tabuleiro = new String[10][10];
        Tabuleiro.posicionarNavios(tabuleiro, 5);
        Tabuleiro.preencherTabuleiro(tabuleiro);
        Print.imprimirTabuleiro(tabuleiro);
     
    }

    
    
}
