package ExtentReport;

import org.junit.Assert;
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
import com.aventstack.extentreports.ExtentTest ;

public class Basic_Extent_Report {

	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport() {

		htmlReport = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);

//		add environment details
		reports.setSystemInfo("Machine", "PC1");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("User", "Rajendra");
		reports.setSystemInfo("browser", "chrome");

//		configuration to change Look and feel
		htmlReport.config().setDocumentTitle("ExtentReport Demo");
		htmlReport.config().setReportName("Test Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}


	@Test
	public void launchBrowser() {

		test = reports.createTest("Launch Browser Name ");
		test.info("browser launched");
		Assert.assertTrue(true);
	}

	@Test
	public void verifyEmail() {

		test = reports.createTest("Verify Email");
		test.info("Verified email Address");
		Assert.assertTrue(true);
	}

	@Test
	public void verifyUserName() {

		test = reports.createTest("Verify UserName");
		Assert.assertTrue(false);
	}

	@Test
	public void verifyLogo() {

		test = reports.createTest("Verify Logo");
		throw new SkipException("skiping this test case with new exceptions");

	}

	@AfterMethod
	public void getTestResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPEED", ExtentColor.YELLOW));
		}

	}

	@AfterTest
	public void tearDown() {
		reports.flush();
	}

}
