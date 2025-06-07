package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example12_parallels_execution_1 {
	@Test
	public void openFacebookApp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

//		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://facebook.com");
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
