package selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



//import org.apache.commons.io.FileUtils;
public class webTable {
	WebDriver driver;
	 
    @BeforeMethod

    public void beforeMethod() throws Exception {
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\j.lakshmi.s\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html"); 

}
    @Test
    public void webtable()
    {
    	List<WebElement>tableHeader=driver.findElements(By.xpath("//table[@class='table table-hover']//tr//th"));
    	List<String>headerName=new ArrayList<String>();
    	for(WebElement e:tableHeader)
    	{
    		String value=e.getText();
    		headerName.add(value);
    	}
    	List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
		boolean flag = true;

		while (flag) {
			// Get total rows count
			String rowLoc = "//table[@class='table table-hover']//tbody//tr";
			List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
			for (int i = 1; i <= allRowsEle.size(); i++) {
				String specificRowLoc = "//table[@class='table table-hover']//tbody/tr[" + i + "]";
				List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
						.findElements(By.tagName("td"));
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<String,String>();
				// Iterating each cell
				for (int j = 0; j < allColumnsEle.size(); j++) {
					// Getting cell value
					String cellValue = allColumnsEle.get(j).getText();
					// We will put in to map with header name and value with iteration
					// Get jth index value from allHeaderNames and jth cell value of row
					eachRowData.put(headerName.get(j), cellValue);
				}
				// After iterating row completely, add in to list.
				allTableData.add(eachRowData);
				System.out.println(allTableData);
 
			}
			if ((driver.findElement(By.xpath("//table[@class='table table-hover']")).getAttribute("class").contains("disabled"))) {
				flag = false;
				break;
			} else {
				// Before clicking Checking current page
				int currentPage = Integer.parseInt(driver.findElement(By.xpath("//a[@class='page_link active']")).getText().trim());
				System.out.println("We are at page "+currentPage+" now.");
				driver.findElement(By.xpath("//a[@class='next_link']")).click();
				// Now we know for which page I need to wait
				String customLoc = "//a[contains(@class,'page_link') and text()='"+(currentPage+1)+"']";
				// Waiting till class attribute contains current
				new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(By.xpath(customLoc), "class", "current"));
			}
		}
 
		System.out.println(allTableData);
    }
		@AfterMethod
		public void screenShot(ITestResult result)
		{
			if(ITestResult.FAILURE==result.getStatus())
			{
				try
				{
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					File src=screenshot.getScreenshotAs(OutputType.FILE);
					//result.getName();
					//FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
					FileHandler.copy(src, new File("C:\\Users\\j.lakshmi.s\\"+result.getName()+".png"));	
					
					System.out.println("Successfully captured a screenshot");
					}
				catch(Exception e)
				{
					System.out.println("Exception while taking screenshot "+e.getMessage());
				}
				driver.quit();
		}
				
				


    }

}
