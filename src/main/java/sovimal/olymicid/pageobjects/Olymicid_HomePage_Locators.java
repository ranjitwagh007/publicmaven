package sovimal.olymicid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sovimal.olymicid.commonutility.BaseClass;


public class Olymicid_HomePage_Locators  extends BaseClass{
	
	
	
	private  static WebElement emailheader = getDriver().findElement(By.xpath("//div[@class='hl1']//child::a[text()='engineeringolympiads@gmail.com']"));

	
	
	//encapsulation
	
	public static  WebElement getEmailName(){
		
		
		return emailheader;
	}
}
