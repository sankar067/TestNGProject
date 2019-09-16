import lib.ExcelConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		
		ExcelConfig readexl= new ExcelConfig("C:/Users/SANKAR/workspace2/MyTest/Data/Book1.xlsx");
		System.out.println(readexl.GetData(0, 0, 0));
	}

}
