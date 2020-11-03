package report;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class report {
	 ExtentHtmlReporter htmlReporter;
	    
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest test;
	 String OS="WINDOWS";
	    String browser="chrome";
	    

	    @BeforeTest()
	    public void startReport(){
	    	// initialize the HtmlReporter
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	        extent =new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //To add system or environment info by using the setSystemInfo method.
	        extent.setSystemInfo("OS", this.OS);
	        extent.setSystemInfo("Browser", this.browser);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        

}
	    @Test
	    public void testCase2() {
	        test = extent.createTest("Test Case 2", "PASSED test case");
	        Assert.assertTrue(true);
	    }
	    @Test()
	    public void testCase3() {
	        test = extent.createTest("Test Case 3", "skipped test case");
	        
	        Assert.assertTrue(true);
	        throw new SkipException("Skipping - This is not ready for testing ");
	    }
	    @Test()
	    public void testCase4() {
	        test = extent.createTest("Test Case 4", "failed test case");
	        Assert.assertTrue(false);
	        //throw new SkipException("Skipping - This is not ready for testing ");
	    }
	    
	    @Test()
		public void testCase6(){
				test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
				throw new SkipException("Skipping - This is not ready for testing ");
			}
	    @AfterMethod(alwaysRun = true)
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    
	        extent.flush();
	  
	    }
	     
	 
	    
}
