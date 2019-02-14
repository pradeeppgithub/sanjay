package Excel;

import java.io.File;
import java.io.IOException;

import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excelclass extends Base {
	static Sheet sh;
	public static File f;
	public static Workbook wb;
	public static String folderpath = getConfig("folderpath");
	
	public static void excelconnection(String filename, String sheetname)
	{

	 f = new File(folderpath+filename);
	try {
		wb = Workbook.getWorkbook(f);
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sh =wb.getSheet(sheetname);
	}

	public static int rowcount()
	{
	   int row = sh.getRows();
	   System.out.println("rows are "+row);
	return row;
	}

	public static int colcount()
	{
	   int col = sh.getColumns();
	   System.out.println("Columns are "+col);
	return col;

	}
	public static String readdata(int col, int row)
	{
	  String x = sh.getCell(col,row).getContents();
	return x;
	}


}
