package excel;

import gui.FrameCombo;
import operations.AllOperations;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ExcelWriter {
    FileInputStream file;
    FileOutputStream outFile;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFSheet sheetCov;
    String nameCov;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<ArrayList<?>> results = new ArrayList<>();
    ArrayList<ArrayList<Double>> cov = new ArrayList<>();
    FileOutputStream file1 = new FileOutputStream("ДЗ5.xlsx");

    public ExcelWriter(String filePath, ArrayList<ArrayList<?>> result, AllOperations allOperations) throws IOException {

        try {
            file = new FileInputStream(filePath);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "выберите файл и произведите рассчеты");
            throw new RuntimeException(e);
        }

//        FileOutputStream file1 = new FileOutputStream("target/ДЗ5.xlsx");
//        file1.getParentFile().mkdirs();
//        outFile = new FileOutputStream(file1);
        workbook = new XSSFWorkbook();
//        workbook.removeSheetAt(workbook.getNumberOfSheets() - 1);
        sheet = workbook.createSheet("Результаты");
        sheetCov = workbook.createSheet("Коэффициенты ковариации");
        names = allOperations.fillNames();
        results = result;
        cov = allOperations.getCovariation();
        nameCov = allOperations.getCovName();
        writeIntoExcel();
    }

    public void writeIntoExcel() throws IOException {
        for (int i = 0; i < names.size(); i++) {
            Row row = sheet.createRow(i);
            Cell name = row.createCell(0);
            name.setCellValue(names.get(i));
        }

        int rowIndex = 0;
        int colIndex = 1; // Начинаем с индекса столбца B

        for (ArrayList<?> sublist : results) {
            for (Object element : sublist) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    row = sheet.createRow(rowIndex);
                }
                Cell cell = row.createCell(colIndex);
                cell.setCellValue(element.toString());
                colIndex++;
            }
            rowIndex++;
            colIndex = 1;
        }

        int rowCov = 0;
        int colCov = 1;
        Row row2 = sheetCov.createRow(rowCov);
        Cell name = row2.createCell(0);
        name.setCellValue(nameCov);

        for(ArrayList<Double> row : cov) {
            for (Object el : row) {
                Row row1 = sheetCov.getRow(rowCov);
                if (row1 == null) {
                    row1 = sheetCov.createRow(rowCov);
                }
                Cell cell = row1.createCell(colCov);
                cell.setCellValue(el.toString());
                colCov++;
            }
            rowCov++;
            colCov = 1;
        }
        workbook.write(file1);
        JOptionPane.showMessageDialog(null, "запись файла выполнена");
        workbook.close();
        file.close();
    }
}
