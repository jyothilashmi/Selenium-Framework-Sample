package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ajax {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverWait wait;
		String baseUrl = "https://www.seleniumeasy.com/test/input-form-demo.html";					
        System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Documents\\Driver\\chromedriver.exe");					
        WebDriver driver = new ChromeDriver();					
        		
        driver.get(baseUrl);
		/*
		 * By linl=By.xpath("//a[contains(text(),'Input Forms')])[2]"); wait = new
		 * WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(linl));
		 */
        
        driver.findElement(By.xpath("(//a[contains(text(),'Input Forms')])[2]")).click();
        List<WebElement>list=driver.findElements(By.xpath("(//a[contains(text(),'Input Forms')])[2]"));
        
    	System.out.println("hi");
        String[] linkTexts = new String[list.size()];
        for(WebElement e:list)
        {
        	
        								
		int					i = 0;					

		//extract the link texts of each link element		
								
		linkTexts[i] = e.getText();		
		
		System.out.println(i);
		i++;
        }
        
        /*for (String t : linkTexts) {	
        	
        	if(t.contains("Ajax Form Submit"))
        		System.out.println("hi");*/
        	
        	By lin=By.xpath("(//a[contains(text(),'Ajax Form Submit')])[2]");
        	 wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(lin));
			
    		driver.findElement(By.xpath("(//a[contains(text(),'Ajax Form Submit')])[2]")).click();
        	
        //}
        
       // Thread.sleep(10);
    		
    		
        WebElement e=driver.findElement(By.id("title"));
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,20);
		 * 
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(e));
		 */
        By title=By.id("title");
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        driver.findElement(By.id("title")).sendKeys("hello");
        By des=By.id("description");
        wait.until(ExpectedConditions.presenceOfElementLocated(des));
        driver.findElement(By.id("description")).sendKeys("description");
        By cl=By.id("btn");
        wait.until(ExpectedConditions.elementToBeClickable(cl));
        driver.findElement(By.id("btn-submit")).submit();
        
        Thread.sleep(5);
        
        
        
	}

}
