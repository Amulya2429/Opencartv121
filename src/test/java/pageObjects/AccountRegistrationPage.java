package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
	    super(driver);	
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmpassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement txtCheckpolicy;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	
	public void setFirstName(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void setConfirmpassword(String pwd)
	{
		txtConfirmpassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy()
	{
		txtCheckpolicy.click();
	}
	public void ClickContinue() 
	{
		//sol1
		btncontinue.click();
		
		//sol2
		//btncontinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btncontinue).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btncontinue);
		
		//sol5
		//btncontinue.sendKeys(Keys.RETURN);
		
		//sol6
	    //WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
		
		}
	public String getConfirmationMsg()  {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	
}

