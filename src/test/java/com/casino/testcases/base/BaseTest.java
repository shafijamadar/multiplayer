package com.casino.testcases.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.casino.pages.LandingPage;
import com.casino.pages.LaunchPage;
import com.casino.pages.LoginPage;
import com.casino.utils.CasinoConstants;
import com.casino.utils.ExtentManager;
import com.casino.utils.Xls_Reader;
import com.casino.utils.userNameAuthentication;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

 public class BaseTest {
	
	public WebDriver driver;
	
	public ExtentReports extent=ExtentManager.getInstance();
	public ExtentTest test;
	public Xls_Reader xls = new Xls_Reader(CasinoConstants.XLS_PATH);
	
	userNameAuthentication hostName = new userNameAuthentication();
	String Username = hostName.setUsername(); 
	
	public LandingPage Setup() throws Exception{
		
		launch("Mozilla");
		test.log(LogStatus.PASS, "Browser Launch Successfully");
		
		LaunchPage launch = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launch);
		
		LoginPage loginPage = launch.goLoginPage();
		
		Object page = loginPage.doLogin(Username, "test");
		
		Thread.sleep(5000);
		if(page instanceof LoginPage){
			Assert.fail("Login Failed");
		}
		
		LandingPage landingPage = (LandingPage)page;
		return landingPage;
	}
	
	public void launch(String bType){
		
		if(bType.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", CasinoConstants.GECKODRIVER_EXE);
			driver= new FirefoxDriver();
		}
		else if(bType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Shafi\\Temp\\Shafi\\Selenium\\Jar files\\chromedriver_win32 (2)\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
			ChromeOptions options = new ChromeOptions();

			options.addArguments("test-type");
		//	options.addArguments("disable-infobars");
		//	options.addArguments("--disable-web-security");
			options.addArguments("chrome.switches","--disable-extensions");	
			capabilities.setCapability("chrome.binary", "D:\\Shafi\\Temp\\Shafi\\Selenium\\Jar files\\chromedriver_win32 (1)\\chromedriver.exe");
			
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				
			 driver= new ChromeDriver(capabilities);
		}
		else if(bType.equals("IE")){
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void takeScreenShot(){
		
	}

}
