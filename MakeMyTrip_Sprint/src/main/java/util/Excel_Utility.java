package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	Workbook wb;
	Sheet sheet;
	String value;

	// Load excel file
	public void loadExcelFile(String filepath, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis);
		sheet = wb.getSheet(sheetName);
	}

	// Read data from a single cell
	public String getStringDataFromSingleCell(int rowNo, int cellNo) throws IOException {
		CellType data = sheet.getRow(rowNo).getCell(cellNo).getCellType();

		if (data == CellType.STRING) {
			value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		} else if (data == CellType.NUMERIC) {
			double val = sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue();
			int intVal = (int) val;
			value = String.valueOf(intVal);
		}

		wb.close();
		return value;
	}

	// Write data
	public void writeDataInTheCell(String filePath, int rowNo, int cellNo, String data)
			throws EncryptedDocumentException, IOException {
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

	// Get entire data using Data provider
	public Object[][] getDataFromTheExcelSheet() throws IOException {
		int rowNo = sheet.getLastRowNum();
		int columnNo = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowNo][columnNo];

		for (int i = 1; i <= rowNo; i++) {
			for (int j = 0; j < columnNo; j++) {
				data[i - 1][j] = getStringDataFromSingleCell(i, j);
			}
		}

		return data;
	}

}
