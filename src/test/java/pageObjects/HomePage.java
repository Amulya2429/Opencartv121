package pageObjects;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class HomePage extends BasePage{
		
	   WebDriver driver;
	   
	   public HomePage(WebDriver driver)
	   {
		   super(driver);
	   }
	   
	   @FindBy(xpath="//span[text()='My Account']")
	   WebElement lnkMyaccount;
	   
	   @FindBy(xpath="//a[text()='Register']")
	   WebElement lnkRegister;
	   
	   @FindBy(xpath="//a[text()='Login']")
	   WebElement linkLogin;
	   
	   public void ClickMyAccount() {
		   lnkMyaccount.click();
	   }
	   public void ClickRegister() {
		   lnkRegister.click();
	   }
	   public void ClickLogin() {
		   linkLogin.click();
	   }
	   
	}


