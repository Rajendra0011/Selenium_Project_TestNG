package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Eamialbl_Report {
	@Test
	public void TC1() {
//		System.out.println("TC1");
		Reporter.log("Test Case Pass", true);
	}
	
	@Test
	public void TC2() {
//		System.out.println("TC2");
		Reporter.log("Test Case Pass", true);
	}
	
	@Test
	public void TC3() {
//		System.out.println("TC3");
		Reporter.log("Test Case Pass", true);
	}

}
