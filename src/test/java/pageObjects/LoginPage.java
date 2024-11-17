package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	//@FindBy(xpath="//a[text()='Cameras']")
	// WebElement addCamera;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys (email);
	}
	
	public void setpassword(String pwd) {
		
		txtpassword.sendKeys(pwd);
	}
	public void ClickLoginbtn() {
		btnLogin.click();
	//	addCamera.click();
	}

	public static void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}
}





