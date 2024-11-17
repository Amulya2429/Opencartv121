package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test
	public void VerifyLogin() {
		
		logger.info("***** starting TC002_LoginTest *****");
		try {
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
	    lp.setpassword("ammu12355");
		// lp.setpassword(p.getProperty("pwd"));
		lp.ClickLoginbtn();
		
		
	    
	    //MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		
		boolean targetpage=map.isMyAccountPageExists();
		Assert.assertTrue(targetpage);    // Assert.assertEquals(targetpage,true,"Login Failed");
		
		map.Clicklogout();
		}catch(Exception e)
		{
			Assert.fail();
		}
		
     logger.info("***** Finished TC002_LoginTest *****");
		}
	
	}

