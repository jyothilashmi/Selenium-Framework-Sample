package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	
	public static void main(String[] args) {
		
		String baseUrl = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";					
        System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Documents\\Driver\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        driver.get(baseUrl);
        
        Select drop = new Select(driver.findElement(By.id("multi-select")));
        
        if(drop.isMultiple())
        {
        	System.out.println(drop.getOptions());
        	
        	 drop.selectByVisibleText("Florida");
        	 drop.selectByIndex(4);
             drop.selectByIndex(3);
             
        }
       
        
		
	}

}
