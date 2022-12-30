package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Tabuleiro tabuleiro;
    private String nome;
    private List<Object> jogadasFeitas;
    private int autoPosicionar;

    public Player(String nome, int autoPosicionar) {
        this.nome = nome;
        this.autoPosicionar = autoPosicionar;
        jogadasFeitas = new ArrayList<>();
        tabuleiro = new Tabuleiro(this.autoPosicionar);
    }

    public String[][] getTabuleiro() {
        return tabuleiro.getTabuleiro();
    }
    public String[][] getTabuleiroEmBranco() {
        return tabuleiro.getTabuleiroEmBranco();
    }
    public Tabuleiro getMatriz() {
        return tabuleiro;
    }
    public int getNome(){
        if(nome.equals("player")){
            return 0;
        }else{
            return 1;
        }
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public List<Object> getJogadasFeitas() {
        return jogadasFeitas;
    }

    public int getAutoPosicionar() {
        return autoPosicionar;
    }
    
}
