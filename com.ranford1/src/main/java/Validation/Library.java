package Validation;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import TestBase.Base;

public class Library extends Base
{
   public static boolean IsTitlePresent(String exp)
   {
	   
	   
	   boolean b=driver.getTitle().contains(exp);
	   return b;
	     
   }

   public static boolean IsAlertPresent(String exp)
   {
	   
	   
	   boolean b=driver.getTitle().contains(exp);
	   return b;
	     
   }
     
    public static void takescreenshot(String screenshot)
    {
    	
    	try {
			Robot r = new Robot();
			BufferedImage br = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(br, "png",new File("./screenshot/"+screenshot+".png"));
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
