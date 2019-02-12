package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Base {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static File f;
	public static FileInputStream file;
	public static  FileReader filer;
	public static By loc;
	//public static Properties property;
	public static void LoadOR()
	{
		f = new File(".\\src\\main\\java\\configuration\\OR.properties");
		try {
			filer = new FileReader(f);
			or.load(filer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
    public static By ORgetElement(String key)
    
    {   System.out.println("OR.properties key is "+key);
    	LoadOR();
    	
        try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//By loc = null;
    	
        String value = or.getProperty(key);
        System.out.println("Key value is "+ value);
         String loctype = value.split(":")[0];
         System.out.println("Loctype value is "+ loctype);
         String locvalue = value.split(":")[1];
         System.out.println("Locvalue value is "+ locvalue);
         if(loctype.contains("id"))
          {  System.out.println("Entered id if condition");
        	loc =  By.id(locvalue);
         } else if (loctype.contains("name"))
         {
        	 loc = By.name(locvalue);
         }else if (loctype.contains("xpath"))
         {   
        	System.out.println("xpath entered");
        	 loc = By.xpath(locvalue);
         
         }
		return loc;
         
    	
    } 
    public static void LoadConfig() 
	//public static void main(String[] args) throws IOException  
    {
		
    	f = new File(".\\src\\main\\java\\configuration\\config.properties");
		try {
			filer = new FileReader(f);
			config.load(filer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
			

}
	
    public static String getConfig(String key)
    {   
    	LoadConfig();
    	try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	System.out.println(key);
    	System.out.println("getConfig Started");
    	String k = config.getProperty(key);
		System.out.println("key value is "+k);
    
		System.out.println("getConfig Finished");
         
		return k;
    	
    }

}
