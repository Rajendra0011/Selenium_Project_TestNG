package POM_DDF_TestNG;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hrm_Login_Test1 {

	WebDriver driver = null;
	Sheet Sheet;
	Hrm_login_page_1 login1;
	Hrm_DashBoard_Page dash;
	HRM_ClaimID_Page claimID;

	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream file = new FileInputStream("D:\\Automations Skills\\Parametrizations\\DDF.xlsx");
		Sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		login1 = new Hrm_login_page_1(driver);
		dash = new Hrm_DashBoard_Page(driver);
		claimID = new HRM_ClaimID_Page(driver);


	}

	@BeforeMethod
	public void loginToApp() {
		login1.enterUN(Sheet.getRow(0).getCell(0).getStringCellValue());
		login1.enterPWD(Sheet.getRow(0).getCell(1).getStringCellValue());
		login1.loginButton();
	}

	@Test(priority = 1)
	public void verifyProfile() {
		String expectUserName = Sheet.getRow(0).getCell(2).getStringCellValue();
		String actualUserName = dash.getVerifyUserName();
		Assert.assertEquals(actualUserName, expectUserName,"both result are different");
	}

	@Test(enabled = false)
	public void verifyClaimID() {
		claimID.enterText();
		String expectID = Sheet.getRow(0).getCell(3).getStringCellValue();
		String actID = claimID.getVerifyClaimID();
		Assert.assertEquals(actID, expectID,"Both result are different");

	}

	@AfterMethod
	public void logoutFromApp() {
 Reporter.log("executed", true);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
