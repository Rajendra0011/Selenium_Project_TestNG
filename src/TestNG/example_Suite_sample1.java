package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class example_Suite_sample1 {
	@Test
	public void TC1() {
		Reporter.log("Running test case TC1", true);
	}
	@Test
	public void TC2() {
		Reporter.log("Running test case TC2", true);
	}
}
