package POM_DDF_TestNG_BaseClass_UtilityClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class {
	
	WebDriver driver=null;
	public void initailzeBrowser() throws IOException {	
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Utility_Class.readDataFromPF("URL"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
