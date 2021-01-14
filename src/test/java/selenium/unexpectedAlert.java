package selenium;

public class unexpectedAlert {
	
	/*
	 * //I could think of a solution using a Thread, which always monitors if there
	 * is any alert present, if yes then accept else don't do any thing. Considering
	 * you are using a testNG or Junit framework, here is the sample:
	 * 
	 * 
	 * package poc.grid; import java.util.concurrent.TimeUnit; import
	 * org.openqa.selenium.By; import org.openqa.selenium.NoAlertPresentException;
	 * import org.openqa.selenium.WebDriver; import
	 * org.openqa.selenium.firefox.FirefoxDriver; import
	 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeTest;
	 * 
	 * public class Test {
	 * 
	 * static WebDriver driver;
	 * 
	 * //This method returns a Thread, which monitors any alert and accept whenever
	 * finds it. And this return a Thread object. public static Thread
	 * handleAlert(final WebDriver driver) { Thread thread = new Thread(new
	 * Runnable() { public void run() { while(true) { try {
	 * System.out.println("Checking alert .... ");
	 * driver.switchTo().alert().accept(); System.out.println("Alert Accepted. ");
	 * }catch(NoAlertPresentException n){ System.out.println("No Alert Present.  ");
	 * }catch (Exception e) { System.out.println("Exception: "+e.getMessage()); } }
	 * } });
	 * 
	 * return thread; }
	 * 
	 * @BeforeTest public void beforeTest() { driver = new FirefoxDriver();
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * //In before Test, just call Thread and start it. handleAlert(driver).start();
	 * }
	 * 
	 * //This is your normal Test
	 * 
	 * @org.testng.annotations.Test public static void test() { try {
	 * driver.get("https://payments.billdesk.com/pb/");
	 * 
	 * int i=0; while(i<=10) {
	 * driver.findElement(By.xpath("//button[@id='go']")).click();
	 * Thread.sleep(2000);
	 * 
	 * i++; } }catch(Exception e) {
	 * System.out.println("Exception: "+e.getMessage()); } }
	 * 
	 * //At the end of test, you can stop the Thread.
	 * 
	 * @AfterTest public void afterTest() { handleAlert(driver).stop(); }
	 * 
	 * }
	 */
}
