package view;

import controller.TabuleiroController;
import model.Player;
import model.Tabuleiro;
import util.ConsoleUIHelper;

import javax.swing.text.TabableView;

public class Print {
    public static void imprimirTabuleiro(String [][] tabuleiro) {
        System.out.println("  "+" 0 "+"1 "+"2 "+"3 "+"4 "+"5 "+"6 "+"7 "+"8 "+"9");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print((char)(i+65) + "  ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }

        // IMPRIMIR OS NOMES DAS LINHAS/COLUNAS
    }
    public static void menu() {
        ConsoleUIHelper.drawHeader("Batalha Naval", 100);
        int option = ConsoleUIHelper.askChooseOption("Quem jogará primeiro, humano ou máquina?", "Humano", "Máquina");
        Tabuleiro tabuleiro = new Tabuleiro();
        Player player = new Player();
        Player bot = new Player();
        while (true){
            imprimirTabuleiro(player.getTabuleiro().getTabuleiro());

            break;
        }
    }

}
