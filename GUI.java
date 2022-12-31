import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

// import TemperatureConverter.*;

public class GUI {

    GUI() {
        JFrame f = new JFrame("Temperature Converter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JButton b1=new JButton("1");
        JLabel title = new JLabel("Select the temperature scales and type a value to convert");
        JLabel emptLabel = new JLabel("");
        f.add(title); f.add(emptLabel);

        String scales[] = { "Celsius", "Fahrenheit", "Kelvin" };
        JComboBox cb1 = new JComboBox(scales);
        JComboBox cb2 = new JComboBox(scales);

        JTextField tf1 = new JTextField("10");
        // JTextField tf2 = new JTextField();
        Button b1 = new Button("To convert");
        JLabel result = new JLabel();
        
        f.add(cb1); f.add(tf1);
        f.add(cb2); f.add(result);
        f.add(b1);  //f.add(result);
        
        // Event Listener
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> inputs = new ArrayList<>();
                inputs.add(cb1.getSelectedItem());
                inputs.add(cb2.getSelectedItem());
                inputs.add(tf1.getText());
                // inputs.add(tf2.getText());
                String newTemperature = TemperatureConverter.converter(inputs);

                result.setText(newTemperature);
            }
        });
        
        
        // setting grid layout of 4 rows and 2 columns
        f.setLayout(new GridLayout(4, 2));
        f.setSize(1000, 300);
        f.setVisible(true);
    }

    public static void ShowMessage(Object message) {  
        JFrame f=new JFrame();  
        JOptionPane.showMessageDialog(f,message);  
     }


    public static void main(String[] args) {
        new GUI();
    }

}
