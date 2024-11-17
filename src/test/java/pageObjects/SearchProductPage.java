package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage{

	public SearchProductPage(WebDriver driver) {
	super(driver);
	}
	
//	@FindBy(xpath="//a[text()='Cameras']")
//	WebElement addCamera;
// @FindBy(xpath="//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[2]")
//	WebElement clickon_wishlist;
	@FindBy(xpath="//input[@class='form-control input-lg']")
	WebElement search;
	@FindBy(xpath="//span[@class='input-group-btn']")
	WebElement clickonsearch;
//	@FindBy(xpath="//input[@class='form-control input-lg']")
//	WebElement search2;
	
/*	@FindBy(xpath="//a[text()='iPhone']")
	WebElement clickon_phone;
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtocart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement confirmation_msg;
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement cartitems;
	@FindBy(xpath="//strong[text()='View Cart']")
	WebElement viewcart;
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement checkout;
	*/
	public void search_Product(String searchproduct) {
	//addCamera.click();
	//clickon_wishlist.click();
		search.sendKeys(searchproduct);
		//search.click();
     }
	public void clickonsearch()
	{
		clickonsearch.click();
	}
	
/*	public void clickonsearch2(String camera)
	{
		clickonsearch.sendKeys(camera);
	}
	*/
/* public void clickonphone()
	{
		clickon_phone.click();
	}
	public void addQuantity(String qun) {
		quantity.clear();
		quantity.click();
		quantity.sendKeys(qun);
	}
	
	
	public void addToCart()
	{
		addtocart.click();
	}
	/*public String getConfirmationMsg()  {
		try {
			return (confirmation_msg.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}*/
	/* public void clickcartitems() {
		cartitems.click();
		
	}
	public void clickviewcart() {
		viewcart.click();
	}
	public void clickcheckout() {
		checkout.click();
	}
	*/

}
