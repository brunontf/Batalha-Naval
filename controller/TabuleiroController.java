package controller;

import exceptions.BoardException;
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
        while (continuarJogada) {
            continuarJogada = shooting(player);
            // System.out.println(player.getJogadasFeitas());// MOSTRAR JOGADAS por enquanto

        }
    }


    public static boolean shooting(Player player) {
        int lineShoot = -9;
        int columnShoot = -9;
        boolean flag;
        do {
            if (!player.getNome()) {
                lineShoot = askLine(lineShoot);
                columnShoot = askColumn(columnShoot);
                flag = jogadaUnica(lineShoot, columnShoot, player);
                if (flag) {
                    continue;
                }
                break;

            } else {
                lineShoot = Util.intAleatorio(0, player.getMatriz().length);
                columnShoot = Util.intAleatorio(0, player.getMatriz().length);
                flag = jogadaUnica(lineShoot, columnShoot, player);
                if (flag) {
                    continue;
                }
                break;
            }
        } while (true);

        if (player.getMatriz()[lineShoot][columnShoot].equals("+")) {
            player.getTabuleiro().setShoot(lineShoot, columnShoot, "#");

            if (verificarVitoria(player.getMatriz())) {
                Print.printMessage(player, "\nParabéns você ganhou!");
                Print.imprimirTabuleiro(player.getTabuleiroEmBranco());
                System.exit(0);
            }

            Print.printMessage(player, "\nAcertou em cheio, tem direito a outra jogada.");
            Print.imprimirTabuleiro(player.getTabuleiroEmBranco());
            return true;
        } else {
            player.getTabuleiro().setShoot(lineShoot, columnShoot, "-");
            Print.printMessage(player, "\nErrou, mais sorte na proxima vez.");
            return false;
        }
    }

    public static Boolean verificarVitoria(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j].equals("+")) {
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
        if (player.getJogadasFeitas().contains(jogada)) {
            Print.printMessage(player, "Jogada já realizada, por favor selecione outros valores");
            return true;
        } else {
            player.getJogadasFeitas().add(jogada);
            return false;
        }
    }

    public static int askLine(int lineShoot) {
        while (true) {
            try {
                String line = ConsoleUIHelper.askNoEmptyInput("Which line?", 3).toUpperCase();
                //lineShoot = Util.returnInt(line);
                //int intLine = Integer.parseInt(line);
                lineShoot = (int) line.charAt(0) - 65;
                if (lineShoot < 0 || lineShoot > 9) {
                    throw new BoardException("Linha incorreta, digite uma opção entre A,B,C,D,E,F,G,H,I,J");
                }
                break;
            }/*catch (NumberFormatException e) {
                System.out.println("Number format exception");
            }*/ catch (BoardException e) {
                System.out.println(e.getMessage());
            }
        }
        return lineShoot;
    }

    public static int askColumn(int columnShoot) {
        columnShoot = Util.askColumnUtil("Which column?");
        return columnShoot;
    }

}
