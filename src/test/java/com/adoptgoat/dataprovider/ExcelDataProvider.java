package com.adoptgoat.dataprovider;
/*package com.philipslifeline.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {
		try {
			
			File src = new File("./Data/Data.xlsx"); // Specify the path of file
			FileInputStream fis = new FileInputStream(src);  // load file
			wb = new XSSFWorkbook(fis); // Load workbook

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getExcelStringData(String sheetName, int rowNumber, int cellNumber) {
		
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
	
	public double getExcelNumericData(String sheetName, int rowNumber, int cellNumber) {
		
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
	}
	
	public Date getExcelDateData(String sheetName, int rowNumber, int cellNumber) {
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getDateCellValue();
	}
}
*/