package POM_DDF_TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_ClaimID_Page {

	
	@FindBy(xpath="//input[@placeholder='Search']")  private WebElement enterText;
	@FindBy(xpath="//a[@class='oxd-main-menu-item']")  private WebElement clickOnSearch;
	@FindBy(xpath="//div[text()='202307180000003']") private WebElement claimID;
	
	
	public HRM_ClaimID_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterText() {
		enterText.sendKeys("Claim");
		clickOnSearch.click();
	}
	
	public String getVerifyClaimID() {
		String actClaimID = claimID.getText();
		return actClaimID;
	}
}
