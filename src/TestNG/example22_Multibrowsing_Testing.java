package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class example22_Multibrowsing_Testing {

	WebDriver driver = null;

	@Parameters("browserName")
	@Test
	public void TC1(String browserName) throws InterruptedException {

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		} else if (browserName.equals("edge")) {

			System.setProperty("webdriver.edge.driver",
					"D:\\Automations Skills\\edgedriver_win64 (2)\\msedgedriver.exe");

			driver = new EdgeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		} else if (browserName.equals("firefox")) {

		}
		// enter User Name
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		// enter password

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		// Click on login Button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// getClaimID
		WebElement clickonSearch = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
//				clickonSearch.click();
		clickonSearch.sendKeys("Claim");
		driver.findElement(By.xpath("//span[text()='Claim']")).click();

		// getClaim ID
		String expectedID = "202307180000003";
		String actclaimId = driver.findElement(By.xpath("//div[text()='202307180000003']")).getText();
//		System.out.println(actclaimId);
//
//		if (actclaimId.equals(expectedID)) {
//			System.out.println("Test Case Pass");
//		} else {
//			System.out.println("Test Case Fail");
//		}

		Thread.sleep(5000);
		driver.quit();

	}

}
