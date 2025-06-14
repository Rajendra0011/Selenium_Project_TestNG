package ExtentReport;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;

public class Extent_Report {
	
	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeTest
	public void startReport() throws UnknownHostException {
		
		htmlReport = new ExtentSparkReporter("ExtenTReportDeMo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		
		// add System/Environment details		
		reports.setSystemInfo("Enviroment", "QA");
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Browser", "Chrome 114");
		reports.setSystemInfo("Tester", "Rajendra");
		reports.setSystemInfo("Build Version", "55");
		reports.setSystemInfo("Machine Name", Inet4Address.getLocalHost().getHostName());
			
		// Configuration to look and fee		
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setReportName("Automation Test Result");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	@Test
	public void LuanchBrowser() {
		
	test= reports.createTest("Browser launched");
	test.info("Browser launched successfully");
	Assert.assertTrue(true);
	}
	
	@Test
	public void verifyHomePage() {
		
		test =reports.createTest("Verified Home Page");
		test.info("verified email success fully");
		Assert.assertTrue(true);
	}
	
	@Test
	public void verifyUserName() {
		
		test=reports.createTest("Verified User Name");
		test.info("verified userName Success fully");
		Assert.assertTrue(false);
		
	}
	@Test
	public void verifyLogo() {
		test =reports.createTest("Verified logo");
		test.info("Verified logo");
		throw new SkipException("Skkipped");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {			
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+" FAIL", ExtentColor.RED));
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {			
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {			
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.YELLOW));
		}
		
		
		
	}
	@AfterTest
	public void tearDown() {
		reports.flush();
	}
	
	
	
	
	
	
	
	
	

}
