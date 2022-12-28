package view;

import controller.TabuleiroController;
import model.Player;
import model.Tabuleiro;
import util.ConsoleUIHelper;

import javax.swing.text.TabableView;

public class Print {
    public static void imprimirTabuleiro(String [][] tabuleiro) {
        System.out.println("\n  "+" 0 "+"1 "+"2 "+"3 "+"4 "+"5 "+"6 "+"7 "+"8 "+"9");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print((char)(i+65) + "  ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void menu() {
        ConsoleUIHelper.drawHeader("Batalha Naval", 100);
    }
    public static void regras(){
        System.out.println("regras");
    }
    public static void printMessage(Player player, String message) {
        if( player.getNome()==1){
            System.out.println(message);
            ConsoleUIHelper.drawLine(100);
        }
    }

}
