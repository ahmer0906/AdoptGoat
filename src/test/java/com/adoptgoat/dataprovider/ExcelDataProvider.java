package com.adoptgoat.dataprovider;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelDataProvider {

	public String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	// Sheet path
	public ExcelDataProvider(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("AdoptorDetails");
			fis.close();
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Get the row count from sheet
	public int getRowCount(String sheetName) {
		Reporter.log("Sheet Name ----> " + sheetName, true);
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int lastRowNumber = sheet.getLastRowNum() + 1;
			Reporter.log("Number  of rows available ---> " + lastRowNumber, true);
			return lastRowNumber;
		}
	}

	public int getColumnCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		int noOfColumns = sheet.getRow(index).getPhysicalNumberOfCells() + 1;
		System.out.println("Number of columns: " + noOfColumns);
		if (noOfColumns == -1)
			return -1;
		else
			return noOfColumns;
	}

	// Returns the data from sheet based on the "Sheet name,Column count, Row count"
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colNum, int rowNum) {
		String cellData ="";
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) 
				cellData = cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
				cellData =  String.valueOf(cell.getNumericCellValue()).split("\\.")[0];
		} catch (Exception e) {
			e.printStackTrace();
			cellData = "row " + rowNum + " or column " + colNum + " does not exist in given Excel";
		}
		return cellData;
	}
}
