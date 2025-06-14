package FrameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2_With_DataDriven {
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		FileInputStream file = new FileInputStream("D:\\Automations Skills\\Parametrizations\\DDF.xlsx");
		
		Sheet Sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automations Skills\\Browser Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		// enter User Name
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Sheet.getRow(0).getCell(0).getStringCellValue());
		
		// enter password
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Sheet.getRow(0).getCell(1).getStringCellValue());
		
		// Click on login Button
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// getClaimID
		WebElement clickonSearch = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));

		
		clickonSearch.sendKeys("Claim");
		driver.findElement(By.xpath("//span[text()='Claim']")).click();
		
		// getClaim ID
		String expectedID = Sheet.getRow(0).getCell(2).getStringCellValue();
		String actclaimId = driver.findElement(By.xpath("//div[text()='202307180000003']")).getText();
//		System.out.println(actclaimId);
//		
//		if(actclaimId.equals(expectedID)) {
//			System.out.println("Test Case Pass");
//		}else {
//			System.out.println("Test Case Fail");
//		}
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
