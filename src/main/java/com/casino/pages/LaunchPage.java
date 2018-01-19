package com.casino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.casino.pom.base.BasePage;
import com.casino.utils.CasinoConstants;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage {
	
	public LaunchPage(WebDriver driver, ExtentTest test){
		super(driver, test);
	}
	
	/* GoLoginPage method loads the application URL and returns the object of loginPage */

	public LoginPage goLoginPage(){
		
		LoginPage loginPage = null;
	
		try{
		test.log(LogStatus.INFO, "Opening URL - " +CasinoConstants.APP_URL);
		
		driver.get(CasinoConstants.APP_URL);
		test.log(LogStatus.INFO, "URL Opened Successfully- " +CasinoConstants.APP_URL);		
		
		loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		
		}catch(Exception e){
			test.log(LogStatus.ERROR, "Browser did not launch");
		}
		return loginPage;
		
	}
}

