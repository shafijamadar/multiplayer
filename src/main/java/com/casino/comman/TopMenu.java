package com.casino.comman;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.casino.pom.base.BasePage;
import com.casino.utils.CasinoConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TopMenu {
	
	@FindBy (id=CasinoConstants.OPTIONS_XPATH) public WebElement OPTION;
	@FindBy (xpath=CasinoConstants.LOGOUT_XPATH) public WebElement LOGOUT;
	
	WebDriver driver;
		
	public TopMenu(WebDriver driver){
		this.driver=driver;
	}
	
	/* Logout option which is available on every page*/
	
	public void logout() throws InterruptedException{
		
		Thread.sleep(3000);
				
		Actions act= new Actions(driver);
		act.moveToElement(OPTION).click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(LOGOUT));
		LOGOUT.click();
	//	test.log(LogStatus.PASS, "Agent is logged Out Successfully");	
	}
}
