package controller;

import model.Player;
import util.ConsoleUIHelper;
import util.Util;
import view.Print;

public class TabuleiroController {

    public static int option() {
        return ConsoleUIHelper.askChooseOption("Quem jogará primeiro, humano ou máquina?", "Humano", "Máquina");
    }
    public static boolean lerRegras() {
        return ConsoleUIHelper.askConfirm("Deseja ler as regras?", "Sim", "Não");
    }

    public static void jogada(Player player) {
        Boolean continuarJogada = true;
        while(continuarJogada){
            continuarJogada = shooting(player);
            // System.out.println(player.getJogadasFeitas());// MOSTRAR JOGADAS por enquanto
            
        }
    }


    public static boolean shooting(Player player){
        int lineShoot= -9;
        int columnShoot= -9;

        do{
            if (player.getNome()==1){
                String line = ConsoleUIHelper.askNoEmptyInput("Which line?", 3);
                lineShoot = Util.returnInt(line);
                columnShoot = ConsoleUIHelper.askInt("Which column?");
            } else{
                lineShoot = Util.intAleatorio(0, player.getTabuleiro().length);
                columnShoot = Util.intAleatorio(0, player.getTabuleiro().length);
            }

        } while(jogadaUnica(lineShoot,columnShoot,player));

        if (player.getTabuleiro()[lineShoot][columnShoot] == "+"){
            player.getMatriz().setShoot(lineShoot, columnShoot, "#");
            
            if( verificarVitoria(player.getTabuleiro())){
                Print.printMessage(player,"\nParabéns você ganhou!");
                Print.imprimirTabuleiro(player.getTabuleiroEmBranco());
                System.exit(0);
            }
            
            Print.printMessage(player, "\nAcertou em cheio, tem direito a outra jogada.");
            Print.imprimirTabuleiro(player.getTabuleiroEmBranco());
            return true;
        } else {
            player.getMatriz().setShoot(lineShoot, columnShoot, "-");
            Print.printMessage(player, "\nErrou, mais sorte na proxima vez.");
            return false;
        }
    }

    public static Boolean verificarVitoria(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if(tabuleiro[i][j] == "+"){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Boolean jogadaUnica(int lineShoot, int columnShoot, Player player) {
        String line = String.valueOf(lineShoot);
        String column = String.valueOf(columnShoot);
        Object jogada = line + column;
        if ( player.getJogadasFeitas().contains(jogada)){
            Print.printMessage(player, "Jogada já realizada, por favor selecione outros valores");
            return true;
        } else {
            player.getJogadasFeitas().add(jogada);
            return false;
        }
    }

}
