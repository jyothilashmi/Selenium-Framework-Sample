package flows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.crm.qa.pages.LoginPage;

import pages.HomePage;
import Base.DriverManager;
import Base.DriverManagerFactory;
import Base.DriverType;

public class Sorting extends DriverManagerFactory{
	
HomePage homePage;
DriverManager driverManager;
WebDriver driver;
	/*
	public Sorting()
	{
		super();
		System.out.println("1");
	}*/
	
	@BeforeClass()
	public void setUp(){
		driverManager=DriverManagerFactory.getWebDriver(DriverType.CHROME);
		System.out.println("2");
		driver=	driverManager.getWebDriver();
		System.out.println("3");
		homePage = new HomePage(driver);
		System.out.println("4");
	}
	
	@Test(priority=2,groups={"smoke"})
	
	public void login()
	{
		driver.get("http://automationpractice.com/index.php");
		
	}
	
	@Test(priority=3,groups={"smoke"})
	public void searching()
	{
		
		homePage.searchKeyword("Dresses");
		homePage.search();
	}
	@Test(priority=4,groups={"smoke"})
	public void sortingInLowerPricetoHigh() throws InterruptedException
	{
		String criteria="Price: Lowest first";
		homePage.sorting(criteria);
		
	}
	
@AfterClass()
public void quit()
{
	
}
}