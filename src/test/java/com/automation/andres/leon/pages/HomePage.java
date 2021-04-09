package com.automation.andres.leon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "vifp-close")
	private WebElement closeOfferButton;

	@FindBy(id = "cdc-destinations")
	private WebElement sailToButton;
	
	@FindBy(css = "[filter='model.filterCollection.destinations'] li button")
	private List<WebElement> destinationsButtons;
	
	@FindBy(id = "cdc-ports")
	private WebElement sailFromButton;
	
	@FindBy(css = "[filter='model.filterCollection.ports'] li button")
	private List<WebElement> originButtons;
	
	@FindBy(id = "cdc-dates")
	private WebElement datesButton;
	
	@FindBy(id = "cdc-durations")
	private WebElement durationButton;
	
	@FindBy(css = "[data-tealium='cdc-filter-duration'] li button")
	private List<WebElement> durationButtons;
	
	@FindBy(css = "[data-tealium='cdc-search-cruises-cta']")
	private WebElement searchCruisesButton;

	public void navigate() {
		getDriver().get("https://www.carnival.com");
	}
	
	public void closeOffer() {
		clickElement(closeOfferButton);
	}
	
	public void selectSailDestination(String destination) {
		clickElement(sailToButton);
		destinationsButtons.forEach(destinationButton -> {
			if(destinationButton.getText().contains(destination)) {
				clickElement(destinationButton);
			}
		});
	}
	
	public void selectSailOrigin(String origin) {
		clickElement(sailFromButton);
		originButtons.forEach(originButton -> {
			if(originButton.getText().contains(origin)) {
				clickElement(originButton);
			}
		});
	}
	
	public void selectDuration(String duration) {
		clickElement(durationButton);
		durationButtons.forEach(durationIntervalButton -> {
			if(durationIntervalButton.getText().contains(duration)) {
				clickElement(durationIntervalButton);
			}
		});
	}
	
	public SearchResultsPage search() {
		clickElement(searchCruisesButton);
		return new SearchResultsPage(getDriver());
	}
}
