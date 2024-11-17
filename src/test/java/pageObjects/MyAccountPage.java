package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
  public MyAccountPage(WebDriver driver) {
	super (driver);//span[text()='My Account']    //div[@id='content']//h2[1]
}
  @FindBy(xpath="//h2[text()='My Account']")  //my account page heading
  WebElement msgheading;
  
  @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
  WebElement btnLogout;
  @FindBy(xpath="//a[text()='Continue']")
  WebElement btncontinue;
  
  
  
  public boolean isMyAccountPageExists()
  {
	  try 
    {
	 return (msgheading.isDisplayed());
    }
    catch (Exception e)
    {
	  return false;
    }
  }
  public void Clicklogout() {
	  if(btnLogout.isEnabled() || btncontinue.isEnabled() ){
	  btnLogout.click();
	  btncontinue.click();
	  System.out.println("logout successful");
	  
	  }
  }
 /* public void ClickContinue() {
	  if(btncontinue.isEnabled()) {
		  btncontinue.click();
	  }
  }*/
}
