package pageObjects;


	//this is the parent of all page object classes

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;

	public class BasePage {
	    
		WebDriver driver;
		
		public BasePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		
	}

