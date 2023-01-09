package model;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.GUIController;
import view.Print;

import java.awt.*;
import java.awt.event.*;

public class GUIOptions {
    private boolean autoToPosition = true;
    private boolean whoStarts = true;
    private boolean frameVisible = true;

    public GUIOptions(GUIPlayer player, GUIPlayer bot){
        JFrame options = new JFrame();
        options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel positionPanel = new JPanel(new FlowLayout());
        JPanel whoStartsPanel = new JPanel(new FlowLayout());
        JPanel regrasPanel = new JPanel(new FlowLayout());
        
        JLabel positionLabel = new JLabel("Deseja posicionar manualmente ?");
        JRadioButton rb1=new JRadioButton("Sim");
        JRadioButton rb2=new JRadioButton("Não",true);
        ButtonGroup bg1 =new ButtonGroup();
        bg1.add(rb1);bg1.add(rb2);
        
        JLabel whoStartsLabel = new JLabel("Deseja começar primeiro ?");
        JRadioButton rb3=new JRadioButton("Sim",true);
        JRadioButton rb4=new JRadioButton("Não");
        ButtonGroup bg2 =new ButtonGroup();
        bg2.add(rb3);bg2.add(rb4);

        JButton regras = new JButton("Ler regras");
        JButton start = new JButton("Clique para Jogar");

        regras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Print.ShowMessage(Print.GUIRules);
            }
        });
        
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(rb1.isSelected()){
                    GUIController.setBarcosManualmente(player,bot);
                    player.setMessage("Posicione suas embarcações");
                    GUIController.setBarcosAuto(bot,player,false);
                }else {
                    GUIController.setBarcosAuto(bot,player,false);
                    GUIController.setBarcosAuto(player,bot,true);
                    bot.setMessage("Escolha uma posição para atacar");
                    bot.setTurnOnScreen(true);
                }
                if (rb4.isSelected() && rb2.isSelected()){
                    GUIController.botShoot(player,bot); //bot começa primeiro
                    }
                if (rb1.isSelected() && rb4.isSelected()){
                    bot.setWhoStarts(false); //bot começa primeiro
                    }
                    player.setTurnOnScreen(true);
                    options.dispose();
            }
        });
        

        positionPanel.add(positionLabel);
        positionPanel.add(rb1);
        positionPanel.add(rb2);
        whoStartsPanel.add(whoStartsLabel);
        whoStartsPanel.add(rb3);
        whoStartsPanel.add(rb4);

        regrasPanel.add(regras);
        regrasPanel.add(start);

        options.add(positionPanel);
        options.add(whoStartsPanel);
        options.add(regrasPanel);
        options.setSize(300,300);
        options.setLayout(new GridLayout(3,1) );
        options.setBounds(600, 300, 400, 150);
        options.setVisible(true);


    }

    public boolean isAutoToPosition() {
        return autoToPosition;
    }

    public boolean isWhoStarts() {
        return whoStarts;
    }

    public boolean isFrameVisible() {
        return frameVisible;
    }
    
    public void setFrameVisible(boolean frameVisible) {
        this.frameVisible = frameVisible;
    }

}
