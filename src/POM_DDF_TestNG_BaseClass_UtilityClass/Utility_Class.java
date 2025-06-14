package POM_DDF_TestNG_BaseClass_UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class {

	public static String getTD(int rowIndex, int cellIndex)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream file = new FileInputStream("D:\\Automations Skills\\Parametrizations\\DDF.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;

	}

	public static void captureScreenShot(WebDriver driver, int TCID) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Automations Skills\\Selenium_Java\\ScreenShot" + TCID + ".jpg");
		FileHandler.copy(src, dest);
	}

	public static String readDataFromPF(String key) throws IOException {

		Properties obj = new Properties();
		FileInputStream file = new FileInputStream(
				"D:\\Automations Skills\\Selenium_Java\\Selenium_Project_TestNG\\PropertyFile.properties");
		obj.load(file);
		String value = obj.getProperty(key);
		return value;

	}

}
