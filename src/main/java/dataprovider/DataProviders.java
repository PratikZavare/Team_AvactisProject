package dataprovider;


//import org.testng.annotations.Test;

import utility.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
//@Test(dataProvider ="testData")
//	public void test1(String email, String password)
//	{
//	System.out.println(email+" | "+password);
//	
//	}
	
@DataProvider(name = "signdata")
	public Object[][] getData()
	{
	
	
		String excelPath = "F:\\java\\Avactis\\src\\test\\resources\\TestData\\TestData.xlsx";
		Object data[][] = testData(excelPath, "Credential");
		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName){
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
//Row
		for(int i=1;i<rowCount;i++)
		{
//Col		
			for(int j=0;j<colCount;j++)
			{
			
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
		
	}
	
}
