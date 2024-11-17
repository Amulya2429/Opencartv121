package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	private static final java.net.URL URL = null;
	public ExtentSparkReporter sparkReporter; // UI of the Report
	public ExtentReports extent; // populate common  info on the report
	public ExtentTest test;   // creating test case entries in the report and update status of the test methods
	
	String repName;
	
	public void onStart(ITestContext testcontext) 
	{
		
	/* SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp = df.format(dt);
	*/	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp
		repName= "Test-Report-" + timeStamp + ".html" ;
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);  // specify the location of the report
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");  // Title of the report
		sparkReporter.config().setReportName("OpenCart Functional Testing");   // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application","OpenCart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("SubModule","Customer");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		String os= testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operatin System","os");
		
		String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser",browser);
		
		List<String> includedGroups=testcontext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
				extent.setSystemInfo("Groups",includedGroups.toString());
			}
		}

	
	 public void onTestSuccess(ITestResult result) {
		 test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		 test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		 test.log(Status.PASS,result.getName()+"got successfully executed"); // update status p/f/s
	 }
	 
	 
	 
	 public void onTestFailure(ITestResult result) {
		// test=extent.createTest(result.getName()); 
		 test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		 test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		 
		 test.log(Status.FAIL,result.getName()+"got failed");
		// test.log(Status.INFO, result.getThrowable().getMessage());
		
		 String imgpath=new BaseClass().CaptureScreen(result.getName());
		   test.addScreenCaptureFromPath(imgpath);
		
		  }
	 
	 
	 public void onTestSkipped(ITestResult result) {
		 test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		 test.assignCategory(result.getMethod().getGroups()); // to display groups in report
         test.log(Status.SKIP,result.getName()+"got skipped");
      //   test.log(Status.INFO, result.getThrowable().getMessage());
	 }
	 
	 
	 public void onFinish(ITestContext context) {
		
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File ExtentReport = new File(pathOfExtentReport); 
		
		try {
			Desktop.getDesktop().browse(ExtentReport.toURI());
		}
		catch (IOException e)
		{
		   e.printStackTrace();
		}
	 	
	 
	/* try
	 {
		 
	 URL url= new URL ("file:///"+ System.getProperty("user.dir") + "\\reports\\" + repName);
	 // create the email message
	 ImageHtmlEmail email= new ImageHtmlEmail();
	 email.setDataSourceResolver(new DataSourceUrlResolver(URL));
	 email.setHostName("smtp.googlemail.com");
	 email.setSmtpPort(465);
	 email.setAuthenticator(new DefaultAuthenticator("amulyagoud580@gmail.com","amulya@2498"));
	 email.setSSLOnConnect(true);
	 email.setFrom("amulyagoud580@gmail.com"); // sender
	 email.setSubject("Test Result");
	 email.setMsg("please find Attached Report...");
	 email.addTo("xyz@1335");// receiver
	 email.attach(url,"extent report", "please check report...");
	 email.send();//send mail
	 
	 }catch(Exception e) {
		 
		 e.printStackTrace();
	 }*/
	 
	 
	 
	 
	 }
	 
}
