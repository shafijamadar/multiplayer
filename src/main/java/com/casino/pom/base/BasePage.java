package com.casino.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.casino.comman.TopMenu;
import com.casino.utils.CasinoConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BasePage {
	
	public WebDriver driver;
	public TopMenu menu;

	public ExtentTest test;
	
	public BasePage(){}
	
	public BasePage(WebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		menu=PageFactory.initElements(driver, TopMenu.class);
		
	}
	public void clickPlusButton(WebElement plusButton){
		
		
		try {
			test.log(LogStatus.INFO, "Clicking on Tab Name");
			plusButton.click();
			
		}catch(ElementNotSelectableException e){
		e.getMessage();
		}
	}
	

	
	public TopMenu getTopMenu(){
		return menu;
	}
	
	public String createName(){
		
		Date d= new Date();
		String name="Create_"+d.toString().replace(" IST","").replace(" ","_");
		System.out.println(name);
		return name;
	}
	
	public String verifyTitle(String expTitle){
		return "";
	}
	
	public String verifyText(String locator, String expText){
		return "";
	}
	
	public boolean isElementPresent(String applicationLogo) throws InterruptedException{
		Thread.sleep(5000);
		int i= driver.findElements(By.xpath(applicationLogo)).size();
		System.out.println("Size of image"+i);
		if(i==0){
			test.log(LogStatus.FAIL, "Element is not found" +applicationLogo);
			return false;
		}
		else{
			test.log(LogStatus.PASS, "Element is found" +applicationLogo);
			return true;	
		}
		
	}
	
	public void takeScreenShot(){
		Date d= new Date();
		String screenShotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=CasinoConstants.REPORTSPATH+"Screenshots//"+screenShotFile;
		//Store the screenshot in the file
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
		
			FileUtils.copyFile(scrFile, new File(filePath));
		}catch(IOException e){
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	
	}

}
