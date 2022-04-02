package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName){
		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount(){
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		return rowCount;
	}
	
	public int getColCount(){
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}
	
	public String getCellDataString(int rowNum,  int colNum){
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
	}
	
	public void getCellDataNumber(int rowNum, int colNum){
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	}
}
