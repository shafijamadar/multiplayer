package com.casino.pages;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.casino.pom.base.BasePage;
import com.casino.utils.CasinoConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateRoundSetup extends BasePage{
	
	@FindBy (name=CasinoConstants.ROUNDNAME_NAME) public WebElement RoundName;
	@FindBy (id=CasinoConstants.GAMENAMEDROPDOWN_XPATH) public WebElement gameName;
	@FindBy (xpath=CasinoConstants.DROPDOWNLIST_XPATH) public WebElement list;
	@FindBy (id=CasinoConstants.ALLOWEDCONTINUE_ID)	public WebElement allowedContinueCheckbox;
	@FindBy (id=CasinoConstants.ALLOWREBUY_ID) public WebElement allowedRebuyCheckbox;
	@FindBy (xpath=CasinoConstants.STARTINGCREDITS_XPATH) public WebElement startingCredits;
	@FindBy (xpath=CasinoConstants.PLAYTIME_ID)	public WebElement playTime;
	@FindBy (id=CasinoConstants.ROUNDDURATIONHOURS_ID) public WebElement roundDurationHours;
	@FindBy (id=CasinoConstants.ROUNDDURATIONMINUTEST_ID) public WebElement roundDurationMinutes;
	@FindBy (id=CasinoConstants.CONTINUEAMOUNT_ID) public WebElement continueAmount;	
	@FindBy (id=CasinoConstants.CONTINUEFEE_ID) public WebElement continueFee;
	@FindBy (id=CasinoConstants.CONTINUECREDITS_ID)	public WebElement continueCredits;
	@FindBy (id=CasinoConstants.CONTINUEMINUTES_ID)	public WebElement continueMinutes;
	@FindBy (id=CasinoConstants.REBUYAMOUNT_ID) public WebElement rebuyAmount;
	@FindBy (id=CasinoConstants.REBUYCREDITS_ID) public WebElement rebuyCredits;
	@FindBy (id=CasinoConstants.REBUYFEE_ID) public WebElement rebuyFee;
	@FindBy (id=CasinoConstants.REBUYMINUTES_ID) public WebElement rebuyMinutes;
	@FindBy (id=CasinoConstants.SAVEBUTTON_ID) public WebElement saveButton;
	@FindBy (xpath=CasinoConstants.OKBUTTON_XPATH) public WebElement OKBUTTON;
	@FindBy (xpath=CasinoConstants.POPTEXT_XPATH) public WebElement POPUP;
	@FindBy (xpath=CasinoConstants.SearchRound_ID) public WebElement SEARCH;
	@FindBy (xpath=CasinoConstants.VIEWROUNDSETUP_XPATH) public WebElement VIEWROUND;
	
	public String roundN="";
	
	public CreateRoundSetup(WebDriver driver, ExtentTest test){
		super(driver, test);
	}

	/* Save Round Setup */
	
	public void saveRoundSetup(Hashtable<String,String> xlsData) throws InterruptedException {
			
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(RoundName));
		
	// Call the Create Name method creates the name and stores in roudN variable
		roundN = "RS_"+createName();
		RoundName.sendKeys(roundN);
		gameName.click();
		
	// Waits for the GameName dropdown to be appeared
		wait.until(ExpectedConditions.visibilityOf(list));		
		list.click();
		
		/*Assert.assertTrue(list.isDisplayed());
		list.click();*/
		/*WebDriverWait wait= new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOf(list)).click();*/
	
	/*	if(!allowedContinueCheckbox.isSelected()){
		//	Assert.fail("AllowedContinue Checkbox is not selected");
		}
		if (!allowedRebuyCheckbox.isSelected()){
		//	Assert.fail("AllowedRebuy Checkbox is not selected");
		}*/
		
		String a=xlsData.get("Starting Credits");
		startingCredits.sendKeys(a);
	
		
	/*	if(!playTime.equals(10)){
			Assert.fail("Default Value of PlayTime is not 10");
		}
		
		if(!roundDurationHours.equals(24)){
			Assert.fail("Default Value of Round Duration Hours is not 24 HOURS");
		}
		if(!roundDurationMinutes.equals(0)){
			Assert.fail("Default Value of Round Duration Minutes is not 0 Minutes");
		}*/
		roundDurationMinutes.sendKeys("24");
			
		String b=xlsData.get("Continue Amount");
		continueAmount.sendKeys(b);
		continueFee.sendKeys(xlsData.get("Continue Fee"));
		continueCredits.sendKeys(xlsData.get("Continue Credits"));
		continueMinutes.sendKeys(xlsData.get("Continue Minutes"));
		
		rebuyAmount.sendKeys(xlsData.get("Rebuy Amount "));
		rebuyCredits.sendKeys(xlsData.get("Rebuy Fee"));
		rebuyFee.sendKeys(xlsData.get("Rebuy Credits"));
		rebuyMinutes.sendKeys(xlsData.get("Rebuy Minutes"));
		
		saveButton.click();	
	}
	
	
	/* Click on OK on Save round setup Confirmation pop up */
	public void verifyRoundSetupConfirmation() throws InterruptedException {
			
	/*WebDriverWait wait= new WebDriverWait(driver, 80);
	wait.until(ExpectedConditions.visibilityOf(OKBUTTON));*/
		
	//	String expectedTitle="Round Setup Saved Successfully. Note: The Setup may not appear in the list immediately";
	//	System.out.println(POPUP.getText())
		
		Thread.sleep(10000);
		takeScreenShot();
	//	driver.switchTo().alert();
		OKBUTTON.click();
		
	}

	/* Search the newly created round by above Save Round Setup method */
	public void searchRoundSetup() throws InterruptedException{
		Thread.sleep(5000);
		/*WebDriverWait wait= new WebDriverWait(driver, 80);
		takeScreenShot();
		wait.until(ExpectedConditions.visibilityOf(SEARCH)).sendKeys(roundN);*/
		SEARCH.sendKeys(roundN);
		System.out.println(SEARCH.getText()); //sendKeys(roundN);
		System.out.println(SEARCH.isDisplayed());
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Newely Created Round is displayed in Result Table Grid");
		takeScreenShot();
	}
	
	/* Select the searched round from Result Table grid */
	public void viewRoundSetup() throws InterruptedException{
	
		Thread.sleep(2000);
		VIEWROUND.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "View Round Screen is loaded Successfully");
		takeScreenShot();
	}
}
