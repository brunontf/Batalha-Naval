package model;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUIPlayer {
    
    private JFrame f;
    private JButton buttons[];
    private String nome;
    private int setLocationX;
    private int nBarcos = 10;
    private ArrayList<String> barcos;
    private ArrayList<String> jogadas;
    private boolean autoToPosition;
    private boolean whoStarts = true;
    private boolean turnOnScreen = true;
    private JLabel message;

    public GUIPlayer(String nome, int setLocationX) {//, boolean autoToPosition, boolean whoStarts
        barcos = new ArrayList<>();
        jogadas = new ArrayList<>();
        this.nome = nome;

        f = new JFrame("Batalha Naval");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1= new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
        
        String titulo = "";
        if(nome == "player"){
            titulo = "☠️ Seu tabuleiro";
        } else {
            titulo = "🤖 Tabuleiro da máquina";
        }
        JLabel title = new JLabel(titulo);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        panel1.add(title);
        

        JPanel panelButtons= new JPanel(new GridLayout(10,10));
        buttons = new JButton[100];
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setIcon(new ImageIcon("imgs\\agua.jpg"));
            buttons[i].setName(String.valueOf(i));
            panelButtons.add(buttons[i]);
        }

        message = new JLabel();
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
        message.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        messagePanel.add(message);

        // FRAME SETTINGS
        f.setSize(600, 600);
        f.setLocation(setLocationX, 0);
        f.add(panel1, BorderLayout.NORTH);
        f.add(panelButtons, BorderLayout.CENTER);
        f.add(messagePanel, BorderLayout.SOUTH);
        f.setResizable(false);
        f.setVisible(false);

    }

    public int getnBarcos() {
        return nBarcos;
    }

    public JButton[] getButtons() { 
        return buttons;
    }

    public void setBarcoIcon(Icon img, int i) {
        buttons[i].setIcon(img);
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }
    
    public ArrayList<String> getBarcosArray() {
        return barcos;
    }

    public void setBarcosArray(ArrayList<String> barcos) {
        this.barcos = barcos;
    }

    public ArrayList<String> getJogadas() {
        return jogadas;
    }

    public void setJogadas(ArrayList<String> jogadas) {
        this.jogadas = jogadas;
    }

    public boolean isWhoStarts() {
        return whoStarts;
    }

    public void setWhoStarts(boolean whoStarts) {
        this.whoStarts = whoStarts;
    }

    public void setTurnOnScreen(boolean turnOnScreen) {
        if(turnOnScreen){
            f.setVisible(true);
        }else {
            f.setVisible(false);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    

}
