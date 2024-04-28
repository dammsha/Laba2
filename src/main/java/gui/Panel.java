package gui;

import data.Data;
import excel.ExcelWriter;
import operations.AllOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Panel extends JPanel {
    JButton b_openFile = new JButton("Открыть файл");
    JButton b_saveFile = new JButton("Сохранить файл");
    JButton b_start = new JButton("Начать рассчеты");
    JButton b_exit = new JButton("Выйти из программы");
    GridLayout gr = new GridLayout(4, 1);
    Data data;
    AllOperations allOperations = new AllOperations();
    Jfilechooser jfilechooser = new Jfilechooser();
    String path;
    FrameCombo frameCombo;
    ExcelWriter excelWriter;
    ArrayList<ArrayList<Double>> list;
    ArrayList<ArrayList<?>> results = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();


    Panel() throws URISyntaxException {
        setLayout(gr);
        add(b_openFile);
        add(b_start);
        add(b_saveFile);
        add(b_exit);

        b_openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jfilechooser = new Jfilechooser();
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                path = jfilechooser.openFile();
                try {
                    frameCombo = new FrameCombo(path);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        data = new Data(path, frameCombo.getIndexSheet());
                    } catch (IOException q) {
                        throw new RuntimeException(q);
                    } catch (NullPointerException w) {
                        JOptionPane.showMessageDialog(null, "не был выбран файл");
                        throw new RuntimeException(w);
                    }
                    list = data.getDataArray();
                    allOperations.start(list);
                    results = allOperations.fillResults();
                    JOptionPane.showMessageDialog(null, "Рассчеты выполнены, по-моему это зачет");
                }
            }
        });


        b_saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excelWriter = new ExcelWriter(path, results, allOperations);
                    JOptionPane.showMessageDialog(null, "Файл сохранен");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ошибка сохранения");
                    throw new RuntimeException(ex);
                }
            }
        });

        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.exit(0);
            }
        });
    }


}
