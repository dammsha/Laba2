package gui;

import Laba_2.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;

public class Jfilechooser extends Component {

    private JFileChooser fileChooser;
    private final String[][] FILTERS = {{"xlsx", "Файлы Excel (*.xlsx)"}};

    public Jfilechooser() throws URISyntaxException {
        fileChooser = new JFileChooser(new File("src/main/resources/"));
//        new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile()
    }

    public String openFile() {
        fileChooser.setDialogTitle("Выбор файла");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(Jfilechooser.this);
        if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(null, fileChooser.getSelectedFile());

        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    public void saveFile() {
        fileChooser.setDialogTitle("Сохранение файла");
        // Определение режима - только файл
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showSaveDialog(Jfilechooser.this);
        // Если файл выбран, то представим его в сообщении
        if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(Jfilechooser.this,
                    "Файл '" + fileChooser.getSelectedFile() +
                            " ) сохранен");
    }

}
