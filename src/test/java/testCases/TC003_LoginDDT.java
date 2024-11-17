package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid  - login success - testpass - logout
 * Data is invalid - login failed - testfailed
 * 
 * Data is invalid - login sucess - testfailed - logout
 * Data is invalid - login failed - testpass
 */



public class TC003_LoginDDT extends BaseClass {
	
@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) // getting dataprovider from different class
public void VerifyLoginDDT(String email,String pwd,String exprel) throws InterruptedException {
	
	logger.info("***** starting TC003_LoginDDT *****");
    
	
		//HomePage
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
	//	Extent.Test()
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setpassword(pwd);
		// lp.setpassword(p.getProperty("pwd"));
		lp.ClickLoginbtn();
	    
	    //MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		
		boolean targetpage=map.isMyAccountPageExists();
		
		map.Clicklogout();
	
		


	//	Assert.assertTrue(targetpage);    // Assert.assertEquals(targetpage,true,"Login Failed");
		
		/* Data is valid  - login success - testpass - logout
		 *                - login failed - testfailed
		 * 
		 * Data is invalid - login sucess - testfailed - logout
		 *                 - login failed - testpass
		 */
   /* if(exprel.equalsIgnoreCase("valid"))
     {
    	if(targetpage==true) 
    	{
    		map.Clicklogout();
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		Assert.assertTrue(false);
    	}
     }
     
     if (exprel.equalsIgnoreCase("Invalid"))
     {
    	 if (targetpage==true)
    	 {
    		 map.Clicklogout();
    		// Assert.assertTrue(false);
    	 }
    	 else
    	 {
    	     Assert.assertTrue(true);
    	 }
     }
     
     }catch(Exception e)
	{
    	 Assert.fail();
	}*/
     logger.info("***** Finished TC003_LoginDDT *****");

}
}


