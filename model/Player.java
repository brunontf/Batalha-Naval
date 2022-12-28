package model;

import controller.TabuleiroController;
import view.Print;

public class Player {
    private Tabuleiro tabuleiro;
    private String nome;

    public Player(String nome) {
        this.nome = nome;
        tabuleiro = new Tabuleiro();
    }

    public String[][] getTabuleiro() {
        return tabuleiro.getTabuleiro();
    }
    public Tabuleiro getMatriz() {
        return tabuleiro;
    }
    public int getNome(){
        if(nome == "player"){
            return 0;
        }else{
            return 1;
        }
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
