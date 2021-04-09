package com.automation.andres.leon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage{
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(tagName = "ccl-view-result-grid-item")
	private List<WebElement> searchResults;
	
	@FindBy(className = "vrgf-price-box__price-value")
	private List<WebElement> resultsPriceValues;
	
	@FindBy(id = "sfn-nav-pricing")
	private WebElement pricingFilterButton;
	
	@FindBy(className = "filter-price")
	private WebElement pricingFilterMenu;
	
	@FindBy(className = "rz-pointer-min")
	private WebElement priceFilterMinButton;
	
	@FindBy(className = "rz-pointer-max")
	private WebElement priceFilterMaxButton;
	
	@FindBy(className = "rz-floor")
	private WebElement priceFilterMinValue;
	
	@FindBy(className = "rz-ceil")
	private WebElement priceFilterMaxValue;
	
	
	public boolean areGridResultsPresent() {
		return searchResults.size() > 0;
	}
	
	public void displayPricingFilterOptions() {
		clickElement(pricingFilterButton);
		getWait().until(ExpectedConditions.visibilityOf(pricingFilterButton));
	}

	public void setPriceFilterRange(int minValue, int maxValue) {
		Actions moveFloorSlider = new Actions(getDriver());
		Action actionUp;
		while(Integer.parseInt(priceFilterMinButton.getAttribute("aria-valuenow")) < minValue) {
			actionUp = moveFloorSlider.dragAndDropBy(priceFilterMinButton, 10, 0).build();
			actionUp.perform();
		}
		
		Actions moveCeilSlider = new Actions(getDriver());
		Action actionDown;
		while(Integer.parseInt(priceFilterMaxButton.getAttribute("aria-valuenow")) > maxValue) {
			actionDown = moveCeilSlider.dragAndDropBy(priceFilterMaxButton, -10, 0).build();
			actionDown.perform();
		}
	}
	
	public boolean areAllResultsInPriceRange(int minValue, int maxValue) {
		for(WebElement resultPrice : resultsPriceValues) {
			int tripValue = Integer.parseInt(resultPrice.getText());
			if( tripValue < minValue || tripValue > maxValue ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean areAllResultsSortedInAscendantOrder() {
		int previousValue = 0;
		for(WebElement resultPrice : resultsPriceValues) {
			int tripValue = Integer.parseInt(resultPrice.getText());
			if( previousValue <= tripValue) {
				previousValue = tripValue;
			} else {
				return false;
			}
		}
		return true;
	}
	
}
