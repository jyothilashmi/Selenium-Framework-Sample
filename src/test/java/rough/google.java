package rough;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class google {

	 
    public static void main(String[] args) {
		
	
    	WebDriver driver;
    
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com"); 
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB);
       // String parent=driver.getWindowHandle();
     // Set<String>tabs=driver.getWindowHandles();
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("window.open()");
      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      driver.get("http://facebook.com");
      
       

}

}

