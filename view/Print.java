package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import enums.Emojis;
import model.Player;
import util.ConsoleUIHelper;

public class Print {
    public static void imprimeColuna(boolean valor){
        if (valor){
            System.out.println("\n  "+" 0️⃣"+" 1️⃣"+" 2️⃣ "+"3️⃣ "+"4️⃣ "+"5️⃣ "+"6️⃣ "+"7️⃣ "+"8️⃣ "+"9️⃣");
        }else {
            System.out.println("\n  "+" 0"+" 1"+" 2 "+"3 "+"4 "+"5 "+"6 "+"7 "+"8 "+"9");

        }
    }
    public static void imprimirTabuleiro(String [][] tabuleiro) {
        imprimeColuna(Emojis.isEmoji);
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
        ConsoleUIHelper.drawHeader("Regras", 100);
        System.out.println("Você como jogador pode inicialmente colocar 10 barcos manualmente ou pode setar eles automaticamente.");
        System.out.println("O jogo funciona em turnos, onde o jogador faz sua jogada e em seguida o bot faz a dele.");
        System.out.println("O jogador terá de posicionar os barcos de acordo com o tabuleiro (ex: C 5)");
        System.out.println("No jogo você não pode: \n1-Fazer jogadas repetidas \n2-Jogadas inexistentes \n3-Empatar(não há empates)");
        ConsoleUIHelper.drawLine(100);
        ConsoleUIHelper.askSimpleInput("Digite algo para sair das regras");
        ConsoleUIHelper.drawLine(100);
    }
    public static void printMessage(Player player, String message) {
        if( !player.getNome()){
            System.out.println(message);
            //ConsoleUIHelper.drawLine(100);
        }
    }
    public static void print(String message) {
            System.out.println(message);
            ConsoleUIHelper.drawLine(100);
    }
    public static void printOwnerTabuleiro(Player player) {
        ConsoleUIHelper.drawLine(100);
        String msg;
        if(player.getNome()){
            msg = Emojis.isEmoji? "☠" : "";
            System.out.println( msg + " SEU TABULEIRO ");
        } else {
            msg = Emojis.isEmoji? "\uD83E\uDD16" : "";
            System.out.println(msg + " TABULEIRO DA MÁQUINA");
        }
    }
    public static void ShowMessage(Object message) {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, message);
    }
    public static String GUIRules = """
            Primeiramente, no menu opções você deve escolher se deseja posicionar as embarcações manualmente ou não, bem como começar primeiro.
            Caso tenha escolhido posicionar manualmente, posicione no tabuleiro da esquerda suas 10 embarcações e, então, comece a jogar no tabuleiro da direita.
            Caso tenha escolhido posicionar automaticamente, inicie já jogando no tabuleiro da direita.
            A cada rodada você terá direito a um chute, e, caso acerte, ganhará um chute extra.
            Ganha quem descobrir todas as 10 embarcações inimigas primeiro.
            Bom jogo!
            """;
}
