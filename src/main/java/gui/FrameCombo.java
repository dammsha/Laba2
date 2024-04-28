package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameCombo extends JFrame {

    JComboBox comboBox;
    JButton b_exit = new JButton("Выход");
    GridLayout gr = new GridLayout(2,1);

    public FrameCombo(String filePath) throws IOException {
        setTitle("Окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setLayout(gr);

        comboBox =  new JComboBox(new Sheets(filePath).namesNumbers());

        add(comboBox);
        add(b_exit);

        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public int getIndexSheet() {
        return comboBox.getSelectedIndex();
    }
}
