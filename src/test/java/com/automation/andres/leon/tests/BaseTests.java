package com.automation.andres.leon.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.andres.leon.DriverFactory;


public class BaseTests {
	
	DriverFactory myDriver;
	
	@BeforeTest(alwaysRun=true)
	public void beforeSuite() {
		myDriver = new DriverFactory("chrome");
		myDriver.getDriver().manage().window().maximize();
	}
	
	@AfterTest(alwaysRun=true)
	public void afterSuite() {
	}
 
}
