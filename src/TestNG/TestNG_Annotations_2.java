package TestNG;



import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Annotations_2 {

	
	@BeforeClass
	public void OpenBrowser() {
		Reporter.log("Open Browser", true);
	}
	
	@BeforeMethod
	public void loginToApp() {
		Reporter.log("Login To App", true);
	}
	@Test
	public void VerifyDashBoard() {
		Reporter.log("Running verify Dashboard", true);
	}
	@Test
	public void VerifyUserName() {
		Reporter.log("Running verify Profile Name", true);
	}
	@AfterMethod
	public void logoutFromApp() {
		Reporter.log("Logout from App", true);
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("Close Browser", true);
	}

}
