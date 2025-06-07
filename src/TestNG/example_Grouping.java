package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class example_Grouping {
	@Test(groups = "login")
	public void TC1() {
		Reporter.log("Running test case TC1", true);
	}

	@Test(groups = "login")
	public void TC2() {
		Reporter.log("Running test case TC2", true);
	}

	@Test(groups = "fund")
	public void TC3() {
		Reporter.log("Running test case TC3", true);
	}

	@Test(groups = "fund")
	public void TC4() {
		Reporter.log("Running test case TC4", true);
	}

	@Test(groups = "order")
	public void TC5() {
		Reporter.log("Running test case TC5", true);
	}

	@Test(groups = "order")
	public void TC6() {
//		Assert.fail();
		Reporter.log("Running test case TC6", true);
	}
}
