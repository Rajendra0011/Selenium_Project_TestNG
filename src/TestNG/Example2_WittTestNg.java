package TestNG;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example2_WittTestNg {
	
	@Test
	public void openBrowser() {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.quit();
	}

}
