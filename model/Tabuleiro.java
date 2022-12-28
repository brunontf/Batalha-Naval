package model;

import util.Util;
import view.Print;


public class Tabuleiro {
    
    private String[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new String[10][10];
        posicionarBarcos(5);
        preencherTabuleiro();
        // Print.imprimirTabuleiro(tabuleiro);
    }


    public void setShoot(int line, int column, String shoot) {
        this.tabuleiro[line][column] = shoot;
    }

    public void setNavios(int line, int column, String navio) {
        this.tabuleiro[line][column] = navio;
    }


    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void preencherTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] != "+")
                    tabuleiro[i][j] = "~";
            }
        }
    }

    public void posicionarBarcos(int quantidadeBarcos) {
        for (int i = 0; i < quantidadeBarcos; i++) {
            int linhaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            int colunaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            if (tabuleiro[linhaAleatoria][colunaAleatoria] == null) {
                setNavios(linhaAleatoria,colunaAleatoria,"+");
            } else {
                i = i - 1;
            }
        }
    }
}
