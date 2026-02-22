package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData()  {
		String loginData[][] = null;
		int totalrows;
		int totalcols;
		try {
			String path = "C:\\Users\\HP\\SeleniumJavaPractice\\openCartV1\\testData\\Opencart_LoginData.xlsx"; // taking excel file from testData
			
			ExcelUtility xlutil = new ExcelUtility(path); // creating an object for xlUtility
			
			 totalrows = xlutil.getRowCount("Sheet1");
			 totalcols = xlutil.getCellCount("Sheet1",1);
			
			 loginData = new String[totalrows][totalcols]; // created two dimensional array which can store username passwords
			
			for(int i=1;i<=totalrows; i++) {
				
				for(int j=0; j<totalcols;j++) {
					loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
				//	return loginData;
				}
			}
			
			
		}
		catch(Exception e) {
			
		}
		return loginData;
		
		
	}
}

// DataProvider2

// DataProvider3
