package com.automation.andres.leon.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		wait.pollingEvery(Duration.ofSeconds(1));
		this.driver = driver;
	}
	
	public WebDriverWait getWait() {
		return wait;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	void clickElement(WebElement clickableElement) {
		getWait().until(ExpectedConditions.elementToBeClickable(clickableElement));
		clickableElement.click();
	}
	
	void setTextToElement(WebElement editableElement, String text) {
		getWait().until(ExpectedConditions.elementToBeClickable(editableElement));
		editableElement.clear();
		editableElement.sendKeys(text);
	}
	
	void selectValueElementDropdown(WebElement dropdownElement, String value) {
		getWait().until(ExpectedConditions.elementToBeClickable(dropdownElement));		
		Select dropdownSelect = new Select(dropdownElement);
		dropdownSelect.selectByValue(value);
	}
	
	String getElementText(WebElement textElement) {
		getWait().until(ExpectedConditions.visibilityOf(textElement));
		return textElement.getText();
	}
	
	WebElement getParentElement (WebElement childElement) {
		return (WebElement) ((JavascriptExecutor) driver).
				executeScript("return arguments[0].parentNode;", childElement);
	}
	
	void forcedWait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
