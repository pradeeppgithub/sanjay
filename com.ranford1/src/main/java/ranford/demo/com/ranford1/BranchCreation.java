package ranford.demo.com.ranford1;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class BranchCreation extends Base{
	
	public static WebElement branch_button() 
	{

		return driver.findElement(ORgetElement("branchbutton"));
				
				
	}
	public static WebElement newbranch_button() 
	{
		
		return driver.findElement(ORgetElement("newbranchbutton"));
				
				
	}
	
	public static WebElement branch_name() 
	{
		
		return driver.findElement(ORgetElement("newbranchname"));
				
				
	}
	public static WebElement address_field() 
	{
		
		return driver.findElement(ORgetElement("addressfield"));
				
				
	}
	public static WebElement zip_code() 
	{
		
		return driver.findElement(ORgetElement("zipcode"));
				
				
	}
	
	
	

}
