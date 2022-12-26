package controller;

import model.Tabuleiro;
import util.ConsoleUIHelper;

import java.util.Scanner;

public class TabuleiroController {
    Tabuleiro tabuleiro = new Tabuleiro();

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

}
