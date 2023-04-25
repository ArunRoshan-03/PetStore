package com.web.application.automation.dataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.web.application.automation.constants.FilePathConstants;
import com.web.automation.automation.testbase.BaseClass;

public class ExcelUtils extends BaseClass {
	public static Object[][] readExcelData(String filePath, String sheetName)
			throws IOException, InvalidFormatException {
		XSSFWorkbook workbook = new XSSFWorkbook(new File(filePath));
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		int numRows = firstSheet.getLastRowNum();
		int cols = firstSheet.getRow(0).getLastCellNum();

		Object[][] excelData = new Object[numRows][cols];
		for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
			XSSFRow row = firstSheet.getRow(rowIndex + 1);
			if (row != null) {
				for (int cellIndex = 0; cellIndex < cols; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					if (cell != null) {
						try {
							excelData[rowIndex][cellIndex] = String.valueOf(cell);
						} catch (IllegalStateException e) {
							System.out.println("Cell data is not a double");
						}
					}
				}
			}
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excelData;
	}

	@DataProvider(name = "data")
	public static Object[][] getDataFromExcel() throws InvalidFormatException, IOException {

		Object[][] data = readExcelData(FilePathConstants.EXCEL_READER_DATA_PATH, "animal");
		return data;

	}
}
