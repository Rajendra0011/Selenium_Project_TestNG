package Page_Object_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hrm_Login_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Hrm_login_page_1 login1= new Hrm_login_page_1(driver);
		login1.enterUN();
		login1.enterPWD();
		login1.loginButton();
		
		Hrm_DashBoard_Page dash= new Hrm_DashBoard_Page(driver);
		dash.verifyUserName();
		
		HRM_ClaimID_Page claimID= new HRM_ClaimID_Page(driver);
		claimID.enterText();
//		claimID.clickSearch();
		claimID.verifyClaimID();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
