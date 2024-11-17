package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	@Test
	public void verify_account_registration() throws InterruptedException
	{
		
	/*	HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName("John");
		regpage.setLastName("David");
		regpage.setEmail("abcjohndavidf@gmail.com"); // randomly generate the e mail
		regpage.setTelephone("23123123");
		regpage.setpassword("xyz12356");
		regpage.setConfirmpassword("xyz12356");
		regpage.setPrivacyPolicy();
		Thread.sleep(2000);
		regpage.ClickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	*/
	// randomly generated email	----appraoch 2
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("clicked on myAccount link....");
		hp.ClickRegister();
	    logger.info("clicked on Register link....");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("providing customer details..");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); // randomly generate the e mail
		regpage.setTelephone(randomNumber());
		
		
		String password=randomAlphaNeumeric();     // we can store in variable because we want same number in both the places
		
		regpage.setpassword(password);
		regpage.setConfirmpassword(password);
		
		regpage.setPrivacyPolicy();
		Thread.sleep(2000);
		regpage.ClickContinue();
		
		logger.info("validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		System.out.println("confirmation message : "+confmsg);
		
	}
		catch(Exception e)
		{
		logger.error("Test failed...");
		logger.debug("Debug logs..");
		Assert.fail();
	}
		logger.info("****** Finished TC001 AccountRegistrationTest ******");
	}
}

