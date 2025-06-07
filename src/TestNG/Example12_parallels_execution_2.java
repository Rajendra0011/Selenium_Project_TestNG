package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Example12_parallels_execution_2 {

	
	@Test
	public void openGoogle() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","D:\\Automations Skills\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

//		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://google.com");
		Thread.sleep(5000);
		driver.quit();
		
		
	}
}
