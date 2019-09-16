import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteExcelData {

	public static void main(String[] args) throws Exception {
		
		File fs=new File("/MyLearningProject/Data/Book1.xlsx");
		FileInputStream fstr= new FileInputStream(fs);
		
		XSSFWorkbook wb = new XSSFWorkbook(fstr);
		
		XSSFSheet ws=wb.getSheetAt(0);

		ws.getRow(0).createCell(2).setCellValue("pass1212555");
		ws.getRow(1).createCell(2).setCellValue("Fail");
		FileOutputStream fout= new FileOutputStream(fs);
		wb.write(fout);
		wb.close();
	}

}
