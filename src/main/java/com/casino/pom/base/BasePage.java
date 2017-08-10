package com.casino.pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public String verifyTitle(String expTitle){
		return "";
	}

}
