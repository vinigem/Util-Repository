package com.vini.mysite.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	public static File createExcel(List<ArrayList<String>> excelList) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("My Sheet");
			for(int rowIndex = 0; rowIndex < excelList.size(); rowIndex++){
				XSSFRow row = sheet.createRow(rowIndex);
				List<String> rowList = excelList.get(rowIndex);
				for(int colIndex = 0; colIndex < rowList.size(); colIndex++){
					XSSFCell cell = row.createCell(colIndex);
					cell.setCellValue(rowList.get(colIndex));
				}
			}
			File file = File.createTempFile("temp", ".xlsx");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
