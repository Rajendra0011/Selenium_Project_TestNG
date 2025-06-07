package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class example_Suite_sample3 {
	
	@Test
	public void TC5() {
		Reporter.log("Running test case TC5", true);
	}
	@Test
	public void TC6() {
		Reporter.log("Running test case TC6", true);
	}

}
