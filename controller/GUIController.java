package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import model.GUIPlayer;
import util.Util;
import view.Print;


public class GUIController {
    public static List<ImageIcon> imgs = new ArrayList<>(Arrays.asList(
                new ImageIcon("imgs\\barco.jpg"),
                new ImageIcon("imgs\\tiro_agua.jpg"),
                new ImageIcon("imgs\\explosao.jpg")));
    
    public static void shoot(GUIPlayer player, GUIPlayer bot) {
        for (JButton b : player.getButtons()) {
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    boolean playAgain = false;
                    if (player.getBarcosArray().contains(b.getName())){
                        b.setIcon(imgs.get(2));
                        b.removeActionListener(this);
                        player.setMessage("ACERTOU! jogue novamente.");
                        playAgain = true;
                        
                    } else {
                        b.setIcon(imgs.get(1));
                        b.removeActionListener(this);
                        player.setMessage("ERROU!");
                    }
                    player.getJogadas().add(b.getName());
                    gameOver(player,bot);
                    if (playAgain){
                        // repeat
                    } else {
                        botShoot(bot ,player);
                    }
                }
            });
        }
    }

    public static void botShoot(GUIPlayer bot, GUIPlayer player) {
        boolean continua;
        boolean playAgain = false;
        String randomNumber;
        do {
            randomNumber = String.valueOf(Util.intAleatorio(0,bot.getButtons().length));
            if(bot.getJogadas().contains(randomNumber)){
                continua=true;
            } else {
                continua = false;
            }
        } while(continua);

        if (bot.getBarcosArray().contains(randomNumber)){
            bot.getButtons()[Integer.parseInt(randomNumber)].setIcon(imgs.get(2));
            playAgain=true;
        } else {
            bot.getButtons()[Integer.parseInt(randomNumber)].setIcon(imgs.get(1));
        }
        bot.getJogadas().add(randomNumber);
        gameOver(bot, player);
        if(playAgain){
            botShoot(bot,player);
        }
    }

    public static void setBarcosManualmente(GUIPlayer player, GUIPlayer bot) {
        for (JButton b : player.getButtons()) {
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(player.getBarcosArray().size()<player.getnBarcos() && ! player.getBarcosArray().contains(b.getName())){
                        b.setIcon(imgs.get(0));
                        player.getBarcosArray().add(b.getName());
                        if (player.getBarcosArray().size()==player.getnBarcos()){
                            bot.setTurnOnScreen(true);
                            if(! bot.isWhoStarts()){
                                botShoot(player,bot); // bot começa primeiro
                            }
                            shoot(bot ,player);
                            player.setMessage("");
                            bot.setMessage("Escolha uma posição para atacar");
                        }
                    }
                }
            });
        }
    }

    public static boolean gameOver(GUIPlayer player, GUIPlayer secondPlayer) {
        int counter = 0;
        for (String jogada : player.getJogadas()) {
            if(player.getBarcosArray().contains(jogada)){
                counter+=1;
            }
        }
        if (player.getNome() == "player"){
            player.setMessage("Número de barcos destruídos :" + counter);
        }
        if (counter == player.getnBarcos()){
            if (player.getNome() == "bot"){
                Print.ShowMessage("Parabéns você ganhou! 💪");
            } else {
                revealAllBoats(secondPlayer);
                Print.ShowMessage("Que pena! A máquina venceu 😢");
            }
            System.exit(0);
            return true;
        }
        return false;
    }

    public static void revealAllBoats(GUIPlayer player) {
        for (String barco : player.getBarcosArray()) {
            if (! player.getJogadas().contains(barco)){
                player.setBarcoIcon(imgs.get(0), Integer.parseInt(barco));
            }
        }
    }

    public static void setBarcosAuto(GUIPlayer player, GUIPlayer bot, boolean start) {
        player.setBarcosArray(Util.generateRandomPositions(player.getnBarcos(),player.getButtons().length));
        for (String barco : player.getBarcosArray()) {
            // player.setBarcoIcon(imgs.get(0), Integer.parseInt(barco)); // CHEATMODE
        }
        if (start){
            shoot(bot, player);
        }
    }
}
