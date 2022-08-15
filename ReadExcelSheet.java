package indepencedaymarathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelSheet {
     @Test
	public static String[][] getExceldata(String excelName) throws IOException
	{
	XSSFWorkbook wbook=new XSSFWorkbook("data/"+excelName+".xlsx");
	XSSFSheet sheet = wbook.getSheetAt(0);//Go to first sheet
	int rowCount = sheet.getLastRowNum();//Get Row Count
	System.out.println("Print Row count\t:"+rowCount);
	int colCount = sheet.getRow(0).getLastCellNum();//Get column count
	System.out.println("Print column count\t:"+colCount);
	String[][] data=new String[rowCount][colCount];
	
	for (int i = 1; i <= rowCount; i++){//Start from data column ignore header 
		XSSFRow row= sheet.getRow(i);//assign the fetched value 
		for (int j = 0; j < colCount; j++) {//loop through the column
			XSSFCell cell=row.getCell(j);//get all cell value
			System.out.println(cell.getStringCellValue());//print it
			data[i-1][j]=cell.getStringCellValue();
		}
	}
	wbook.close();
	return data;
	}
     
     
     
}


