package model;

import controller.TabuleiroController;
import util.ConsoleUIHelper;
import util.Util;
import view.Print;


public class Tabuleiro {

    private String[][] tabuleiro;
    private String[][] tabuleiroEmBranco;

    public Tabuleiro(int autoPosicionar) {
        tabuleiro = new String[10][10];
        tabuleiroEmBranco = new String[10][10];
        // meuTabuleiro = player.getTabuleiro();
        preencherTabuleiro(tabuleiro);
        preencherTabuleiro(tabuleiroEmBranco);

        if (autoPosicionar != 0) {// posiciona automaticamente
            posicionarBarcosAuto(10);
        } else {
            posicionarManualmente(10);
        }
    }

    public void preencherTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = "\uD83C\uDF0A"; //onda
            }
        }
    }

    public void posicionarBarcosAuto(int quantidadeBarcos) {
        for (int i = 0; i < quantidadeBarcos; i++) {
            int linhaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            int colunaAleatoria = Util.intAleatorio(0, tabuleiro.length);
            if (tabuleiro[linhaAleatoria][colunaAleatoria].equals("\uD83C\uDF0A")) {
                setNavios(linhaAleatoria, colunaAleatoria);
            } else {
                i = i - 1;
            }
        }
    }

    public void posicionarManualmente(int quantidadeBarcos) {
        int i = 0;
        while (i < quantidadeBarcos) {
            Print.imprimirTabuleiro(tabuleiro);
            int linhaEscolhida = TabuleiroController.askLine(-9);
            int colunaEscolhida = TabuleiroController.askColumn(-9);
            if (checkLineCol(linhaEscolhida, colunaEscolhida)) {
                Print.print("Posição já escolhida, escolha outra por favor!\n");
            } else {
                setNavios(linhaEscolhida, colunaEscolhida);
                i++;
            }
        }
    }

    public Boolean checkLineCol(int linhaEscolhida, int colunaEscolhida) {
        return tabuleiro[linhaEscolhida][colunaEscolhida].equals("\u26F5");
    }

    public void setShoot(int line, int column, String shoot) {
        this.tabuleiro[line][column] = shoot;
        this.tabuleiroEmBranco[line][column] = shoot;
    }

    public void setNavios(int line, int column) {
        this.tabuleiro[line][column] = "\u26F5"; //barco
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public String[][] getTabuleiroEmBranco() {
        return tabuleiroEmBranco;
    }


}
