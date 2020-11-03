package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.DriverManager;
import Base.DriverManagerFactory;
import Base.DriverType;
import junit.framework.Assert;
import pages.BasicsPage;
import pages.HomePage;

public class basics extends DriverManagerFactory{
	
	BasicsPage basicspage;
DriverManager driverManager;
WebDriver driver;

@BeforeClass()
public void setUp(){
	driverManager=DriverManagerFactory.getWebDriver(DriverType.CHROME);
	System.out.println("2");
	driver=	driverManager.getWebDriver();
	System.out.println("3");
	basicspage = new BasicsPage(driver);
	System.out.println("4");
}
	
@Test(priority=1)
public void alert()
{
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	basicspage.alertEnter();
	String msg=basicspage.alert();
	
	System.out.println(msg);
	
	Assert.assertEquals("Do you really want to delete this Customer?", msg);
}

@Test(priority=2,description="accepting alert")
public void accepting()
{
	basicspage.accept();
}
}
