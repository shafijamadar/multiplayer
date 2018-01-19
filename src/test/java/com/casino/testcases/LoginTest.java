package com.casino.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.casino.pages.LaunchPage;
import com.casino.pages.LoginPage;
import com.casino.testcases.base.BaseTest;
import com.casino.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {
	
	@Test
	public void doLogin() throws Exception{
		
		test = extent.startTest("Login Test Started");
		test.log(LogStatus.INFO, "Starting test");
				
		launch("Chrome");
		
		test.log(LogStatus.PASS, "Browser Launched");
		
		LaunchPage launchPage= new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		test.log(LogStatus.PASS, "URL Added in Browser");
		
		LoginPage loginPage=launchPage.goLoginPage();
		loginPage.doLogin("mohammeds@ssg.com", "test");
		
		test.log(LogStatus.INFO, "Logged in successfully");	
	}
	
	@AfterMethod
	public void quit(){
		
		if(extent !=null){
			extent.endTest(test);
			extent.flush();
		}
	}
	
	
	
	

}
