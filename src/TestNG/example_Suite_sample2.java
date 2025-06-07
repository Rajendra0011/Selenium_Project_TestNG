package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class example_Suite_sample2 {

	
	@Test
	public void TC3() {
		Reporter.log("Running test case TC3", true);
	}
	@Test
	public void TC4() {
		Reporter.log("Running test case TC4", true);
	}
}
