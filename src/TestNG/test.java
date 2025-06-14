package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void TC1() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rajen\\Downloads\\geckodriver-v0.36.0-win-aarch64 (3)\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

//		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://google.com");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
