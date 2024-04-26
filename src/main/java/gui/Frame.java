package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame {
    Panel panel = new Panel();
    public Frame(){
        setTitle("Окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        add(panel);
    }
}
