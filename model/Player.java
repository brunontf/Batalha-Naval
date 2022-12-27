package model;

import controller.TabuleiroController;
import view.Print;

public class Player {
    Tabuleiro tabuleiro = new Tabuleiro();


    public Player() {
        if (TabuleiroController.regras()){
            Print.regras();
        }

    }

    public String[][] getTabuleiro() {
        return tabuleiro.getTabuleiro();
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
