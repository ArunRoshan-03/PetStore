package com.web.application.automation.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains method date and time.
 * 
 * @author arunroshan.r
 *
 */
public class Utility {
	public static String date;
	public static String time;

	/**
	 * This method to validate by adding five mins with current time.
	 * 
	 * @return
	 */
	public static String currentTimeAndDate() {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm");

		Date dates = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));

		date = dateFormat.format(dates);
		time = String.valueOf(date);

		System.out.println(time);
		return time;
	}

	public static void writeToExcelSheet(WebDriver driver, String title, List<WebElement> elementsName,
			String sheetName, String filePath) {
		String[] row_heading = { title };

		List<WebElement> users = elementsName;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(sheetName);

		Row headerRow = spreadsheet.createRow(0);

		// Creating header
		for (int i = 0; i < row_heading.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(row_heading[i]);
		}

		// Creating data rows for each user
		for (int i = 0; i < users.size(); i++) {
			Row dataRow = spreadsheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(users.get(i).getText());
		}
		System.out.println();
		// Write the workbook in file system
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Write to excel sheet done  successfully...........");
	}
}
