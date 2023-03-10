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

    public String[][] getMatriz() {
        return tabuleiro.getTabuleiro();
    }
    public String[][] getTabuleiroEmBranco() {
        return tabuleiro.getTabuleiroEmBranco();
    }
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    public boolean getNome(){
        return nome.equals("player");
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
