package com.selenium.testing.assesment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static final DataFormatter formatter = new DataFormatter();

	public static Object[][] readExcelDataToObjArray(String filepath, String filename, String sheetname)
			throws IOException {
		File file = new File(filepath + File.separator + filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		Object[][] data = new Object[rowCount][1];
		Hashtable<String, String> rec = null;
		Row keysRow = sheet.getRow(0);
		for (int r = 1; r < rowCount + 1; r++) {
			Row dataRow = sheet.getRow(r);
			rec = new Hashtable<String, String>();
			for (int c = 0; c < dataRow.getLastCellNum(); c++) {
				String key = keysRow.getCell(c).getStringCellValue();
				String val = formatter.formatCellValue(dataRow.getCell(c));
				rec.put(key, val);
			}
			data[r - 1][0] = rec;
		}

		workbook.close();
		return data;
	}
}
