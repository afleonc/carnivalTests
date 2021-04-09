package com.automation.andres.leon.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.andres.leon.DriverFactory;
import com.automation.andres.leon.pages.HomePage;


public class BaseTests {
	
	DriverFactory myDriver;
	
	private HomePage homePage;
	
	@BeforeTest(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new DriverFactory("chrome");
		homePage = new HomePage(myDriver.getDriver());
		homePage.navigate();
		myDriver.getDriver().manage().window().maximize();
	}
	
	@AfterTest(alwaysRun=true)
	public void afterSuite() {
		homePage.dispose();
	}
	
	public HomePage getHomePage() {
		return homePage;
	}
 
}
