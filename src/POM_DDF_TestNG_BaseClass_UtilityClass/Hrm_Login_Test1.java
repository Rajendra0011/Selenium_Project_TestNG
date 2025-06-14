package POM_DDF_TestNG_BaseClass_UtilityClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hrm_Login_Test1 extends Base_Class {

	Hrm_login_page_1 login1;
	Hrm_DashBoard_Page dash;
	HRM_ClaimID_Page claimID;
	int TCID;

	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException {

		initailzeBrowser();
		login1 = new Hrm_login_page_1(driver);
		dash = new Hrm_DashBoard_Page(driver);
		claimID = new HRM_ClaimID_Page(driver);

	}

	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		login1.enterUN(Utility_Class.readDataFromPF("UN"));
		login1.enterPWD(Utility_Class.readDataFromPF("PWD"));
		login1.loginButton();
	}

	@Test(priority = 1)
	public void verifyProfile() throws EncryptedDocumentException, InvalidFormatException, IOException {
		TCID = 100;
		String expectUserName = Utility_Class.getTD(0, 2);
		String actualUserName = dash.getVerifyUserName();
		Assert.assertEquals(actualUserName, expectUserName, "both result are different");
	}

	@Test(enabled = false)
	public void verifyClaimID() throws EncryptedDocumentException, InvalidFormatException, IOException {
		claimID.enterText();
		String expectID = Utility_Class.getTD(0, 3);
		String actID = claimID.getVerifyClaimID();
		Assert.assertEquals(actID, expectID, "Both result are different");

	}

	@AfterMethod
	public void logoutFromApp(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			Utility_Class.captureScreenShot(driver, TCID);
		}
		Reporter.log("executed", true);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
