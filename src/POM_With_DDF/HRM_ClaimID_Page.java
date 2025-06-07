package POM_With_DDF;


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
	
//	public void clickSearch() {
//		clickOnSearch.click();
//	}
	
	public void verifyClaimID(String ID) {
		String actClaimID = claimID.getText();
		String expClaimID =ID;
		if(actClaimID.equals(expClaimID)) {
			System.out.println("verifyClaimID : Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
	}
}


//WebElement clickonSearch = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
////clickonSearch.click();
//clickonSearch.sendKeys("Claim");
//driver.findElement(By.xpath("//span[text()='Claim']")).click();