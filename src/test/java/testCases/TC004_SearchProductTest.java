package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {
    @Test
	public void vreify_wishlist() {
		logger.info("*****Starting TC004_wishlist");
		
		SearchProductPage sp=new SearchProductPage(driver);
     	sp.search_Product(p.getProperty("searchproduct"));
		sp.clickonsearch();
		sp.clickonsearch();
		//sp.clickonsearch2(p.getProperty("searchproduct2"));
		sp.clickonsearch();
		
	/*	wp.clickonphone();
		wp.addQuantity("2");
		wp.addToCart();
		wp.clickcartitems();
		wp.clickviewcart();
		wp.clickcheckout();
		*/
		/*logger.info("validating expected message..");
		String confmmsg=wp.getConfirmationMsg();
		Assert.assertEquals(confmmsg,"Success: You have added iPhone to your shopping cart!");
		System.out.println("confirmation message : "+confmmsg);
		*/
		
		logger.info("*****Ending TC004_wishlist");
		
	}

		
	
}
