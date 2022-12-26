package model;

import util.Util;

public class Tabuleiro {
    public static void preencherTabuleiro(String [][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if(tabuleiro[i][j] != "+")
                tabuleiro[i][j]="~";
            }
        }
    }
    public static void posicionarNavios(String[][] tabuleiro,int quantidadeNavios) {
        for (int i = 0; i < quantidadeNavios; i++) {
            int linhaAleatoria = Util.intAleatorio(0,tabuleiro.length);
            int colunaAleatoria = Util.intAleatorio(0,tabuleiro.length);
            if (tabuleiro[linhaAleatoria][colunaAleatoria] == null){
                tabuleiro[linhaAleatoria][colunaAleatoria] = "+";
            } else {
                i=i-1;
            }
        }
    }

    
}
