package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManagerFactory;

public class BasicsPage extends DriverManagerFactory {
	
	 WebDriver driver;
	 //this.wait= 
	 WebDriverWait wait;
	 Alert al;
	 
	 @FindBy(how=How.NAME,using="cusid")
	 WebElement id;
	 
	 @FindBy(how=How.NAME,using="submit")
	 WebElement submit;
	 
	//Initializing the Page Objects:
	public BasicsPage(WebDriver driver){
		
		this.driver=driver;
		//this.wait=new WebDriverWait(driver,100);
		
		PageFactory.initElements(driver, this);
	}
	
	public void alertEnter()
	{
		id.sendKeys("53920");
		submit.click();
	}
	
	public String alert()
	{
		al=driver.switchTo().alert();
		
		String msg=al.getText();
		
		return msg;
		
	}
	public void accept(){
		al.accept();
	}
}
