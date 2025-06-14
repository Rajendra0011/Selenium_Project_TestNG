package POM_DDF_TestNG_BaseClass_UtilityClass;

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
	
	public String getVerifyUserName() {
		String actresult = dashBoard.getText();
		return actresult;
		
	}

}
