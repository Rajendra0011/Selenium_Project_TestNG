package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Keword_invocationCount {
	
	@Test(invocationCount = 3)
	public void TC1() {
		Reporter.log("Open Browser", true);
	}

}
