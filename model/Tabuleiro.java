package model;

import util.Util;
import view.Print;


public class Tabuleiro {
    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    private String[][] tabuleiro = new String[10][10];

    public void setShoot(int line, int column, String shoot) {
        this.tabuleiro[line][column] = shoot;
    }

    public Tabuleiro() {
        preencherTabuleiro();
    }

    void posicionarNavios(int quantidadeNavios) {
        for (int i = 0; i < quantidadeNavios; i++) {
            int linhaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            int colunaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            if (tabuleiro[linhaAleatoria][colunaAleatoria] == null) {
                tabuleiro[linhaAleatoria][colunaAleatoria] = "+";
            } else {
                i = i - 1;
            }
        }
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
