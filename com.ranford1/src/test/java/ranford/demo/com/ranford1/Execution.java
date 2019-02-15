package ranford.demo.com.ranford1;



import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Excel.Excelclass;

public class Execution extends Repository{
	@BeforeSuite
	
	public static void m1()
	{
		System.out.println("BeforeSuite");
	}
	@BeforeClass
	public static void m2()
	{
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public static void m3()
	{
		System.out.println("BeforeMethod");
	}
	@BeforeTest
	public static void m4()
	{
		System.out.println("BeforeTest");
	}
	@Test
	public static void m5()
	{
		System.out.println("Test1");
	}
	@Test
	public static void m9()
	{
		System.out.println("Test2");
	}
	@AfterMethod
	public static void m6()
	{
		System.out.println("AfterMethod");
	}
	@AfterTest
	public static void m7()
	{
		System.out.println("AfterTest");
	}
	@AfterSuite
	public static void m8()
	{
		System.out.println("AfterSute");
	}
/*	@Test(priority=1)
    public void verify_launch() 
	{  
		launch();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	@Test(priority=2)
	public void verify_login() 
	{  
		login();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.close();
		
	}*/
	@Test(priority=1)
	public void verify_excellogin() 	{
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Excelclass.excelconnection("data.xls", "Sheet1");
		Excelclass.outputexcelconnection("data.xls", "output.xls", "Sheet1");
		for(int r=1;r<Excelclass.rowcount();r++)
		{
			String username = Excelclass.readdata(0, r);
			String password = Excelclass.readdata(1, r);
			login(username,password);
		
			String actualtitle = driver.getTitle();
			String expectedtitle = "KEXIM BANK";
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
			driver.close();
			if (actualtitle.contains(expectedtitle))
			{
				Excelclass.writedata(2, r, "Test Passed");
			} else if(!(actualtitle.contains(expectedtitle)))
			{
				Excelclass.writedata(2, r, "Test failed");
			} else
			{
				Excelclass.writedata(2, r, "Invalid Data");
				
			}
		
		}
		Excelclass.saveworkbook();
		
	
	}

	
	
	
	
	}
	

