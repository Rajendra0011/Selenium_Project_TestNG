package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hrm_DashBoard_Page {
	

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") private WebElement dashBoard;
	
	
	public Hrm_DashBoard_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUserName() {
		String actresult = dashBoard.getText();
		System.out.println(actresult);
		String expResult="Gsuatvo user";
		if(actresult.equals(expResult)) {
			System.out.println("verifyDashboard : Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
	}

}
