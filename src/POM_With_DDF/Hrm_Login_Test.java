package POM_With_DDF;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hrm_Login_Test {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
FileInputStream file = new FileInputStream("D:\\Automations Skills\\Parametrizations\\DDF.xlsx");
		
		Sheet Sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Hrm_login_page_1 login1= new Hrm_login_page_1(driver);
		login1.enterUN(Sheet.getRow(0).getCell(0).getStringCellValue());
		login1.enterPWD(Sheet.getRow(0).getCell(1).getStringCellValue());
		login1.loginButton();
		
		Hrm_DashBoard_Page dash= new Hrm_DashBoard_Page(driver);
		dash.verifyUserName(Sheet.getRow(0).getCell(2).getStringCellValue());
		
		HRM_ClaimID_Page claimID= new HRM_ClaimID_Page(driver);
		claimID.enterText();
//		claimID.clickSearch();
		claimID.verifyClaimID(Sheet.getRow(0).getCell(3).getStringCellValue());
		
		Thread.sleep(3000);
		driver.quit();
	}

}
