import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

// import TemperatureConverter.*;

public class GUIBatalhaNaval {
    private JFrame f;
    private JButton buttons[];
    private String nome;
    private int setLocationX;
    private int nBarcos = 5;
    private ArrayList<String> barcos;
    ArrayList<String> jogadas;

    GUIBatalhaNaval(String nome, int setLocationX) {
        barcos = new ArrayList<>();
        jogadas = new ArrayList<>();

        f = new JFrame("Batalha Naval");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1= new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
        
        String titulo = "";
        if(nome == "player"){
            titulo = "☠️ Seu tabuleiro";
        } else {
            titulo = "Tabuleiro da máquina";
        }
        JLabel title = new JLabel(titulo);
        panel1.add(title);
        

        JPanel panelButtons= new JPanel(new GridLayout(10,10));
        buttons = new JButton[100];
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setIcon(new ImageIcon("imgs\\agua.jpg"));
            buttons[i].setName(String.valueOf(i));
            panelButtons.add(buttons[i]);
        }

        // FRAME SETTINGS
        f.setSize(600, 600);
        f.setLocation(setLocationX, 0);
        f.add(panel1, BorderLayout.NORTH);
        f.add(panelButtons, BorderLayout.CENTER);
        f.setVisible(true);
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

    public static void shoot(GUIBatalhaNaval player, List<ImageIcon> imgs) {
        for (JButton b : player.getButtons()) {
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (player.getBarcosArray().contains(b.getName())){
                        b.setIcon(imgs.get(2));
                        b.removeActionListener(this);
                        
                    } else if (b.getIcon() != imgs.get(2)){
                        b.setIcon(imgs.get(1));
                        b.removeActionListener(this);
                    }
                    player.getJogadas().add(b.getName());
                    System.out.println(player.getJogadas());
                }
            });
        }
    }
    
    public static void setBarcosManualmente(GUIBatalhaNaval player, List<ImageIcon> imgs) {
        for (JButton b : player.getButtons()) {
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(player.getBarcosArray().size()<player.getnBarcos() && ! player.getBarcosArray().contains(b.getName())){
                        b.setIcon(imgs.get(0));
                        player.getBarcosArray().add(b.getName());
                        if (player.getBarcosArray().size()==player.getnBarcos()){
                            GUIBatalhaNaval bot = new GUIBatalhaNaval("bot", 600);
                            player.getBarcosArray().add("***");
                        }
                    }
                }
            });
        }
    }

    public static void setBarcosAuto(GUIBatalhaNaval player, List<ImageIcon> imgs) {
        for (String barco : player.getBarcosArray()) {
            player.setBarcoIcon(imgs.get(0), Integer.parseInt(barco));
        }
    }

    public static void main(String[] args) {
        List<ImageIcon> imgs = new ArrayList<>(Arrays.asList(
        new ImageIcon("imgs\\barco.jpg"),
        new ImageIcon("imgs\\tiro_agua.jpg"),
        new ImageIcon("imgs\\explosao.jpg") ));
        ArrayList<String> barcos2 = new ArrayList<>(Arrays.asList("2","6","22","26","30"));

        GUIBatalhaNaval player = new GUIBatalhaNaval("player",0);
        // ArrayList<String> barcos = new ArrayList<>();
        // setBarcosManualmente(player, imgs, barcos);
        ArrayList<String> jogadas = new ArrayList<>();
        player.setBarcosArray(barcos2);
        setBarcosAuto(player, imgs);
        
        
        GUIBatalhaNaval bot = new GUIBatalhaNaval("bot",600);
        bot.setBarcosArray(barcos2);
        shoot(bot, imgs);
    }

    public static void ShowMessage(Object message) {  
        JFrame f=new JFrame();  
        JOptionPane.showMessageDialog(f,message);  
    }


    // ImageIcon tiro_agua = new ImageIcon("tiro_agua.jpg");
    // ImageIcon barco = new ImageIcon("barco.jpg");
    // ImageIcon explosao = new ImageIcon("explosao.jpg");
    // List<Integer> barcos = new ArrayList<>(Arrays.asList(0,10,20,30,40));
    // List<Integer> tirosErrados = new ArrayList<>(Arrays.asList(1,11,21,31,41));
    // List<Integer> tirosCertos = new ArrayList<>(Arrays.asList(2,12,22,32,42));
}
