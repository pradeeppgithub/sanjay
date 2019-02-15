package Excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excelclass extends Base {
	static Sheet sh;
	public static File f;
	public static Workbook wb;
	public static String folderpath = getConfig("folderpath");
	public static WritableWorkbook wwb;
	public static WritableSheet wsh;
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
	public static void outputexcelconnection(String ifilename, String ofilename,String sheetname)
	{
		try {
			FileInputStream fis = new FileInputStream(folderpath+ifilename);
			Workbook wb = Workbook.getWorkbook(fis);
			sh = wb.getSheet(sheetname);
			FileOutputStream fos = new FileOutputStream(folderpath+ofilename);
 wwb=Workbook.createWorkbook(fos, wb);
			wsh =wwb.getSheet(sheetname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void writedata(int c, int r, String data)
	{
		jxl.write.Label l =new jxl.write.Label(c, r, data);
		try {
			wsh.addCell(l);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void saveworkbook()
{
	try {
		wwb.write();
		wwb.close();
		wb.close();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
