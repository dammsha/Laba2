package gui;

import javax.swing.*;
import java.awt.*;

public class Jfilechooser extends Component {

    private JFileChooser fileChooser;
    private final String[][] FILTERS = {{"xlsx", "Файлы Excel (*.xlsx)"}};

    public Jfilechooser() {
        fileChooser = new JFileChooser();
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
