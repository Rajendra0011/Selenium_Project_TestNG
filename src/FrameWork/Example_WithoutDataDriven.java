package FrameWork;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_WithoutDataDriven {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		// enter User Name
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		// enter password
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		// Click on login Button
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// getClaimID
		WebElement clickonSearch = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
//		clickonSearch.click();
		clickonSearch.sendKeys("Claim");
		driver.findElement(By.xpath("//span[text()='Claim']")).click();
		
		// getClaim ID
		String expectedID = "202307180000003";
		String actclaimId = driver.findElement(By.xpath("//div[text()='202307180000003']")).getText();
		System.out.println(actclaimId);
		
		if(actclaimId.equals(expectedID)) {
			System.out.println("Test Case Pass");
		}else {
			System.out.println("Test Case Fail");
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
