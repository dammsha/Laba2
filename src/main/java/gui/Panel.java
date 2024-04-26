package gui;

import data.Data;
import excel.ExcelWriter;
import operations.AllOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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


    Panel() {
        setLayout(gr);
        add(b_openFile);
        add(b_start);
        add(b_saveFile);
        add(b_exit);

        b_openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfilechooser = new Jfilechooser();
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
                    }
                }
                list = data.getDataArray();
                allOperations.start(list);
                results = allOperations.fillResults();
            }
        });

        b_saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excelWriter = new ExcelWriter(path, results, allOperations);
                } catch (IOException ex) {
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
