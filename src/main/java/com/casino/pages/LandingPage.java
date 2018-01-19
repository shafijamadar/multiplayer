package com.casino.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.casino.pom.base.BasePage;
import com.casino.utils.CasinoConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends BasePage {
	
	@FindBy (xpath=CasinoConstants.CREATEROUNDSETUPBUTTON_XPATH)
	public WebElement plusButton;
	
	@FindBy (xpath=CasinoConstants.ROUNDSET_HEADER_XPATH)
	public WebElement roundSetupHeader;
	
	@FindBy (xpath=CasinoConstants.PRIZESTRUCTURE_HEADER_XPATH)
	public WebElement prizeStructureHeader;
	
	@FindBy (xpath=CasinoConstants.TEMPLATE_HEADER_XPATH)
	public WebElement templateHeader;
	
	@FindBy (xpath=CasinoConstants.TOURNAMENT_HEADER_XPATH)
	public WebElement tournamentHeader;
	
	public LandingPage(WebDriver driver, ExtentTest test){
		super(driver, test);
	}
	
		
	public CreateRoundSetup clickFabbutton() throws InterruptedException{
		
		roundSetupHeader.click();
		Thread.sleep(5000);
	//	plusButton.click();
		clickPlusButton(plusButton);
		
		CreateRoundSetup round= new CreateRoundSetup(driver, test);
		PageFactory.initElements(driver, round);
		return round;	
	}
	
	public PrizeStructureLanding prizeStructure() throws InterruptedException{
		
		prizeStructureHeader.click();
		clickPlusButton(plusButton);
		Thread.sleep(5000);
		
		
		PrizeStructureLanding prize= new PrizeStructureLanding(driver,test);
		PageFactory.initElements(driver, prize);
		return prize;
	}
	
	public CreateTemplate template() throws InterruptedException{
		
		templateHeader.click();
		plusButton.click();
		Thread.sleep(5000);
		
		CreateTemplate template= new CreateTemplate(driver, test);
		PageFactory.initElements(driver, template);
		return template;
	}
	
	public CreateTournament tournament() throws InterruptedException {
		
		CreateTournament tournament = null;
		
		boolean tournamentSelected=isElementPresent(CasinoConstants.TOURNAMENT_HEADER_XPATH);
		if(!tournamentSelected){
			throw new ElementNotSelectableException("Tournament Tab is not selected");
		}
		else{
	
		tournament= new CreateTournament(driver, test);
		PageFactory.initElements(driver, tournament);
		}
		return tournament;
}

}
