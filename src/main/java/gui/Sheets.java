package gui;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Sheets {
    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String filePath;
    int numberSheets;
    ArrayList<String> names = new ArrayList<>();


    Sheets(String filePath) throws IOException {
        file  = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
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
