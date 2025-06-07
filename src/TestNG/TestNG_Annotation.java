package TestNG;

import org.junit.AfterClass;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotation {
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("---@Before Suite---", true);
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("---@Before Test---",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("---@Before class---", true);
	}
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("---@Before method---", true);
	}
	
	@Test
	public void TC1() {
		Reporter.log("Test Case passed", true);
		
	}
	@Test
	public void TC2() {
		Reporter.log("Test Case passed", true);
	}
	@Test
	public void TC3() {
		Reporter.log("Test Case passed", true);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("---@After Method---", true);
	}
	
	@AfterClass
	public void afterClass()
	{
		Reporter.log("---@After Class---", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("---@After Class---", true);
	}
	
	@AfterSuite
	public void aftersuite() {
		Reporter.log("---@After Suite---", true);
	}
	

}
