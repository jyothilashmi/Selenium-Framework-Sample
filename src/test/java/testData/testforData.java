package testData;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testforData {
	WebDriver driver;
	 
    @BeforeMethod

    public void beforeMethod() throws Exception {
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://blazedemo.com/login"); 

}

@Test(dataProvider="Authentication")

   public void Registration_data(String sUserName,String sPassword,String hello)throws  Exception{

       //driver.findElement(By.xpath(".//*[@id='account']/a")).click();

       driver.findElement(By.id("email")).sendKeys(sUserName);

System.out.println(sUserName);

       driver.findElement(By.id("password")).sendKeys(sPassword);

System.out.println(sPassword);

       driver.findElement(By.xpath("//button[@type='submit']")).click();

       System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
       
       System.out.println(" Login"+hello);

      // driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

}

   @DataProvider

   public Object[][] Authentication() throws Exception{

        Object[][] testObjArray = testData.getTableArray("C:\\Users\\j.lakshmi.s\\Documents\\TestData.xlsx","Sheet1");

        return (testObjArray);

}

   @AfterMethod

   public void afterMethod() {

 	    driver.close();

   	}
}

