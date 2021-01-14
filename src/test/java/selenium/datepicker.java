package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class datepicker {
	
	public static void main(String[] args) {
		WebDriverWait wait;
		String baseUrl = "https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";					
        System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Documents\\Driver\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        driver.get(baseUrl);
        


    
            driver.findElement(By.xpath("//span[@class='input-group-addon']")).click();

   
        //return driver.findElement(calendar).isDisplayed();
    
        
        
	}

}
