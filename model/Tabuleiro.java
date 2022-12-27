package model;

import util.Util;
import view.Print;


public class Tabuleiro {


    public Tabuleiro() {
        preencherTabuleiro();
    }

    private String[][] tabuleiro = new String[10][10];

    public void setShoot(int line, int column, String shoot) {
        this.tabuleiro[line][column] = shoot;
    }

    public void setNavios(int line, int column, String navio) {
        this.tabuleiro[line][column] = navio;
    }



    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    void preencherTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] != "+")
                    tabuleiro[i][j] = "~";
            }
        }
    }


}
