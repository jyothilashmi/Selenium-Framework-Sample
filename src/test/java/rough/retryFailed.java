package rough;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

public class retryFailed implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit = 4;
	@Override
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			System.out.println(counter);
			return true;
		}
		return false;
	}
	
	/*
	 * ExtentReports extent; ExtentTest logger; WebDriver driver;
	 * 
	 * ExtentHtmlReporter htmlReporter;
	 * 
	 * //helps to generate the logs in test report. String OS="WINDOWS"; String
	 * browser="chrome";
	 * 
	 * 
	 * 
	 * @BeforeTest public void startReport(){
	 * 
	 * htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	 * +"/test-output/testReport.html"); extent =new ExtentReports();
	 * extent.attachReporter(htmlReporter); //To add system or environment info by
	 * using the setSystemInfo method. extent.setSystemInfo("OS", this.OS);
	 * extent.setSystemInfo("Browser", this.browser);
	 * extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
	 * extent.setSystemInfo("Environment", "Automation Testing");
	 * extent.setSystemInfo("User Name", "Jyothi Lakshmi");
	 * htmlReporter.config().setChartVisibilityOnOpen(true);
	 * htmlReporter.config().setDocumentTitle("Extent Report Demo");
	 * htmlReporter.config().setReportName("Test Report");
	 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 * htmlReporter.config().setTheme(Theme.STANDARD); htmlReporter.config().
	 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"); }
	 * 
	 * public static String getScreenshot(WebDriver driver, String screenshotName)
	 * throws Exception { String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot ts =
	 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
	 * //after execution, you could see a folder "FailedTestsScreenshots" under src
	 * folder String destination = System.getProperty("user.dir") +
	 * "/FailedTestsScreenshots/"+screenshotName+dateName+".png"; File
	 * finalDestination = new File(destination);
	 * com.google.common.io.Files.copy(source,finalDestination); return destination;
	 * }
	 * 
	 * @AfterMethod public void getResult(ITestResult result) throws Exception{
	 * if(result.getStatus() == ITestResult.FAILURE){
	 * 
	 * logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ",
	 * ExtentColor.RED)); logger.fail(result.getThrowable());
	 * 
	 * //To capture screenshot path and store the path of the screenshot in the
	 * string "screenshotPath" //We do pass the path captured by this mehtod in to
	 * the extent reports using "logger.addScreenCapture" method. String
	 * screenshotPath = getScreenshot(driver, result.getName()); //To add it in the
	 * extent report logger.log(Status.FAIL, (Markup)
	 * logger.addScreencastFromPath(screenshotPath)); }else if(result.getStatus() ==
	 * ITestResult.SKIP){ //logger.log(LogStatus.SKIP,
	 * "Test Case Skipped is "+result.getName()); } // ending test //endTest(logger)
	 * : It ends the current test and prepares to create HTML report
	 * 
	 * //endTest(logger); }
	 * 
	 * @AfterTest public void endReport(){ // writing everything to document
	 * //flush() - to write or update test information to your report.
	 * extent.flush(); //Call close() at the very end of your session to clear all
	 * resources. //If any of your test ended abruptly causing any side-affects (not
	 * all logs sent to ExtentReports, information missing), this method will ensure
	 * that the test is still appended to the report with a warning message. //You
	 * should call close() only once, at the very end (in @AfterSuite for example)
	 * as it closes the underlying stream. //Once this method is called, calling any
	 * Extent method will throw an error. //close() - To close all the operation
	 * //extent.close(); }
	 * 
	 */	}


