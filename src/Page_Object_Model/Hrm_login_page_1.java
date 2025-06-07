package Page_Object_Model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hrm_login_page_1 {
	
//	Step 1:
	//declaration
	
	@FindBy(xpath="//input[@name='username']") private WebElement UN;
//	private WebElement UN =driver.findElement(By.xpath("//input[@name='password']"))
	
	@FindBy(xpath="//input[@name='password']") private WebElement PWD;
//	private WebElement PWD =driver.findElement(By.xpath("//input[@name='password']"))
	
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
//	private WebElement loginButton =driver.findElement(By.xpath("//input[@name='password']"))

	
//	initialization within the Constructor
	
	public Hrm_login_page_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUN()
	{
		UN.sendKeys("Admin");
	}
	public void enterPWD() {
		PWD.sendKeys("admin123");
	}
	
	public void loginButton() {
		loginButton.click();
	}
}
