package ranford.demo.com.ranford1;


import org.openqa.selenium.WebElement;

import TestBase.Base;

public class LoginPage extends Base {
	
	
	public static WebElement username_editbox()
	{
		return driver.findElement(ORgetElement("username"));
		
				
	}
	
	public static WebElement password_editbox() 
	{
		return driver.findElement(ORgetElement("password"));
		
				
	}
	public static WebElement login_button() 
	{
		return driver.findElement(ORgetElement("login"));
	
				
	}
	

}
