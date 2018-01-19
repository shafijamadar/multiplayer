package com.casino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.casino.pom.base.BasePage;
import com.casino.utils.CasinoConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BasePage {

	@FindBy(id=CasinoConstants.USERNAME_ID)
	public WebElement username;
	
	@FindBy(xpath=CasinoConstants.PASSWORD_XPATH)
	public WebElement password;
	
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver, test);
	}
	
	public Object doLogin(String Username, String Password) throws Exception{
			
	/*	WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(Username);*/
			
		Thread.sleep(5000);
		username.sendKeys(Username);
		password.sendKeys(Password);
		password.sendKeys(Keys.ENTER);
		
		//logic to validate login is successful	 
		boolean loginsuccess= isElementPresent(CasinoConstants.TOURNAMENT_HEADER_XPATH);	
		
		if(loginsuccess){
			
			LandingPage landingPage= new LandingPage(driver, test);
			PageFactory.initElements(driver, landingPage);
			test.log(LogStatus.PASS, "Landing Page Loaded Successfully");
			return landingPage;		
		}
		else{
			LoginPage loginPage= new LoginPage(driver, test);
			PageFactory.initElements(driver, loginPage);
			test.log(LogStatus.FAIL, "Login is not successful");
			return loginPage;
			
			
			
	}
}
}
