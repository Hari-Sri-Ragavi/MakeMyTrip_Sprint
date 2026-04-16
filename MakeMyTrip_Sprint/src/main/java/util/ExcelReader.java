package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    Workbook wb;
    Sheet sheet;

    // Load Excel File
    public void loadExcelFile(String filePath, String sheetName)
            throws EncryptedDocumentException, IOException {

        FileInputStream fis = new FileInputStream(filePath);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheet(sheetName);
        fis.close();
    }

    // Read Single Cell
    public String getDataFromSingleCell(int rowNo, int cellNo) {

        Row row = sheet.getRow(rowNo);
        if (row == null) return "";

        Cell cell = row.getCell(cellNo);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    // Write Data
    public void writeDataInTheCell(String filePath, int rowNo, int cellNo, String data)
            throws IOException {

        Row row = sheet.getRow(rowNo);
        if (row == null) {
            row = sheet.createRow(rowNo);
        }

        Cell cell = row.getCell(cellNo);
        if (cell == null) {
            cell = row.createCell(cellNo);
        }

        cell.setCellValue(data);

        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);
        fos.close();
    }
}