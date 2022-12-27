package controller;

import model.Tabuleiro;
import util.ConsoleUIHelper;
import util.Util;

import java.util.Scanner;

public class TabuleiroController {
    private Tabuleiro tabuleiro = new Tabuleiro();


    public boolean shooting(){
        int lineShoot = ConsoleUIHelper.askInt("Which line?");
        int columnShoot = ConsoleUIHelper.askInt("Which column?");
        if(tabuleiro.getTabuleiro()[lineShoot][columnShoot] == "+"){
            tabuleiro.setShoot(lineShoot, columnShoot, "#");
            System.out.println("Acertou em cheio, tem direito a outra jogada.");
            return true;
        } else {
            tabuleiro.setShoot(lineShoot, columnShoot, "-");
            System.out.println("Errou, mais sorte na proxima vez.");
            return false;
        }
    }

    public void posicionarBarcos(int quantidadeBarcos) {
        for (int i = 0; i < quantidadeBarcos; i++) {
            int linhaAleatoria = Util.intAleatorio(0, tabuleiro.getTabuleiro().length);
            int colunaAleatoria = Util.intAleatorio(0, tabuleiro.getTabuleiro().length);
            if (tabuleiro.getTabuleiro()[linhaAleatoria][colunaAleatoria] == null) {
                tabuleiro.setNavios(linhaAleatoria,colunaAleatoria,"+");
            } else {
                i = i - 1;
            }
        }
    }

}
