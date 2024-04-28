package gui;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Sheets {

    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    int numberSheets;
    ArrayList<String> names = new ArrayList<>();

    Sheets(String filePath){

        try {
            file  = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "файл не найден");
            throw new RuntimeException(e);
        }
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ошибка считывания книги");
            throw new RuntimeException(e);
        } catch (NotOfficeXmlFileException e) {
            JOptionPane.showMessageDialog(null, "ошибка считывания книги");
            throw new RuntimeException(e);
        }
        names = namesSheets();
        numberSheets = numberSheets();
    }

    public int numberSheets() {
        int numberOfSheets = workbook.getNumberOfSheets();
        return numberOfSheets;
    }

    public ArrayList<String> namesSheets() {
        for (int i = 0; i < numberSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            names.add(sheet.getSheetName());
        }
        return names;
    }

    public String[] namesNumbers() {
        String[] temp = new String[numberSheets];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(i) + " " + workbook.getSheetAt(i).getSheetName();
        }
        return temp;
    }
}
