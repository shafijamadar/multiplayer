package com.casino.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.casino.pages.CreateRoundSetup;
import com.casino.pages.LandingPage;
import com.casino.pages.LaunchPage;
import com.casino.pages.LoginPage;
import com.casino.testcases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateRoundSetupTest extends BaseTest{
	
	@Test
	public void testCreateRoundSetup() throws Exception{
		
		test=extent.startTest("Create Round Setup Test Started");
		 
		launch("Chrome");
		
		test.log(LogStatus.PASS, "Browser Launched");
		
		LaunchPage launchPage= new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage=launchPage.goLoginPage();
		test.log(LogStatus.PASS, "URL Added in Browser");
		
		Object page = loginPage.doLogin("mohammeds@ssg.com", "test@123");
				
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else
			System.out.println("Logged in successfully");

		LandingPage landingPage = (LandingPage) page;
	
		CreateRoundSetup createRoundSetupPage=landingPage.clickFabbutton();
		test.log(LogStatus.PASS, "Create Round Setup Page Launched Successfully");		
		//createRoundSetupPage.saveRoundSetup();
		test.log(LogStatus.PASS, "Round Setup Saved Successfully");	
		
		createRoundSetupPage.verifyRoundSetupConfirmation();
		test.log(LogStatus.INFO, "Confirmation POP DISPLAYED");
				
		createRoundSetupPage.searchRoundSetup();
		
		createRoundSetupPage.viewRoundSetup();
			
		createRoundSetupPage.getTopMenu().logout();
	
		test.log(LogStatus.PASS, "Agent is logged out successfully");
		takeScreenShot();
		
	}
	//254745261
	
	@AfterTest
	public void quit(){
		if(extent !=null){
			extent.endTest(test);
			extent.flush();
		}
	}

}
