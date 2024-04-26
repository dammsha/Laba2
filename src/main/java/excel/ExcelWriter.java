package excel;

import gui.FrameCombo;
import operations.AllOperations;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriter {
    FileInputStream file;
    FileOutputStream outFile;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String filePath;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<ArrayList<?>> results = new ArrayList<>();


    public ExcelWriter(String filePath, ArrayList<ArrayList<?>> result, AllOperations allOperations) throws IOException {
        file = new FileInputStream(filePath);
        outFile = new FileOutputStream("ДЗ6.xlsx");
        workbook = new XSSFWorkbook(file);
        sheet = workbook.createSheet("Результаты");
        names = allOperations.fillNames();
        results = result;
        writeIntoExcel();
    }

    public void writeIntoExcel() throws IOException {
        for (int i = 0 ; i < names.size(); i++) {
            Row row = sheet.createRow(i);
            Cell name = row.createCell(0);
            name.setCellValue(names.get(i));
        }

        for (int i = 0; i < results.size(); i++) {
            Row row = sheet.createRow(i);
            ArrayList<?> temp = new ArrayList<>();
            temp = results.get(i);
            for (int j = 0; j < temp.size() - 1; j++) {
                Cell name = row.createCell(j++);
                name.setCellValue(temp.get(j).toString());
            }
        }

        workbook.write(outFile);
        workbook.close();

    }

}
