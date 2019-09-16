package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// learn-automation.com
public class ExcelConfig {

	//global variable
	XSSFWorkbook wb;
	XSSFSheet ws;
	
	//Constructor
	public ExcelConfig(String excelpath)
	{
		//create file object and read file
				try {
					File fs=new File(excelpath);
					FileInputStream fstr= new FileInputStream(fs);
					//create work book
					//XSSFWorkbook for .xlsx file
					//HSSFWorkbook for .xls file
					wb = new XSSFWorkbook(fstr);  //or new HSSFWorkbook();

				}
				//base exception is Exception(all type of error)
				catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
	}

//Method 
public String GetData(int SheetNum,int RowNum,int ColumnNum)
{
	//Read excel sheet
	ws=wb.getSheetAt(SheetNum);
//	reading cell data
	String Data=ws.getRow(RowNum).getCell(ColumnNum).getStringCellValue();
	return Data;
}

public int GetRowCount(int SheetIndex)
{
	int row=wb.getSheetAt(SheetIndex).getLastRowNum();
	row=row+1;
	return row;
}
}
