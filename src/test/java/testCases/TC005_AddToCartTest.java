package testCases;

import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass {
	@Test
    public void addtocart() {
    	AddToCartPage acp=new AddToCartPage(driver);
    	acp.clickonphone();
		acp.addQuantity("2");
		acp.addToCart();
		acp.clickcartitems();
		acp.clickviewcart();
		acp.clickcheckout();

    }
    
}
//*[@id="content"]/div/div[2]/div[1]/button[1]