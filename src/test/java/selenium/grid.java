package selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//java -Dwebdriver.chrome.driver="C:\Users\j.lakshmi.s\Documents\Driver\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.4:4444/grid/register -port 5566
public class grid {
	
	WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.1.4:4444/wd/hub";
       
        /*DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);*/
        //capability.setCapability(ChromeOptions.CAPABILITY, options);
        //options.setBinary("/path/to/other/chrome/binary");
        
        //ChromeOptions options=new ChromeOptions();
        //options.addExtensions(new File("/path/to/extension.crx"));
       // options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
        //options.merge(capability);
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);*/
        
        ChromeOptions option = new ChromeOptions();
     
		option.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		//option.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
		
		   option.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		 driver = new RemoteWebDriver(new URL(nodeURL), option);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);
        

        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

    }
}



