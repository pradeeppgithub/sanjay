package ranford.demo.com.ranford1;




import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import TestBase.Base;
import Validation.Library;

public class Repository extends Base {
	
	public void launch()
	{

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getConfig("build2")); 
		
		String expurl = getConfig("build2");
		String actualurl = driver.getCurrentUrl(); 
		if (actualurl.contains(expurl))
		{    
			Reporter.log(("Launch test is pass because my actual url: "+actualurl+" is same as my exptected url: ")+expurl);
		}else
		{
			
		
		
			Reporter.log(("Launch test is fail because my actual url: "+actualurl+" is not same as my exptected url: ")+expurl);
		
			 Library.takescreenshot("Lauch");
		}
        
	}
	
	public  void login(String username, String password)
	{
		launch();
		//LoginPage.username_editbox().sendKeys(getConfig("username_build2"));
		LoginPage.username_editbox().sendKeys(username);
		//LoginPage.password_editbox().sendKeys(getConfig("password_build2"));
		LoginPage.password_editbox().sendKeys(password);
        LoginPage.login_button().click();	
        if(Library.IsTitlePresent(getConfig("loginexptitle")))
        	{
        	     Reporter.log("Login test is pass because my actual title: "+driver.getTitle()+" is mathcing with my expected url");
                              	
        		}else
        		{
        			 Reporter.log("Login test is fail because my actual title: "+driver.getTitle()+" is not mathcing with my expected url");	
        			 Library.takescreenshot("Login");
        		}
        
        		
	}
	public void branchCreation()
	{
		//System.out.println(driver.getTitle());
//driver.get(getConfig("branchbuttonurl")); 
		
	     try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	     BranchCreation.branch_button().click();
		BranchCreation.newbranch_button().click();
		/*LoginPage.username_editbox().sendKeys(getConfig("username_build2"));
		LoginPage.password_editbox().sendKeys(getConfig("password_build2"));*/
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BranchCreation.branch_name().sendKeys(getConfig("newbranchname"));
		BranchCreation.address_field().sendKeys(getConfig("address"));
		BranchCreation.zip_code().sendKeys(getConfig("zipcode"));
	}
	
}
