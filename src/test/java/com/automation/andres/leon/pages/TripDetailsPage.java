package com.automation.andres.leon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TripDetailsPage extends BasePage {

	public TripDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "cruise-glance:not(.header-glance) .cruise-glance-wrapper .duration-title p span")
	private WebElement cruiseDurationValue;
	
	@FindBy(css = ".itinerary-day-tile .day")
	private List<WebElement> itineraryDayTitles;
	
	@FindBy(id = "sm-booking-btn")
	private WebElement bookingHeaderButton;
	
	public boolean isEachDayInItineraryTile() {
		getWait().until(ExpectedConditions.visibilityOf(cruiseDurationValue));
		System.out.println(cruiseDurationValue.getText());
		return itineraryDayTitles.size() == Integer.parseInt(cruiseDurationValue.getText()) + 1;
	}
	
	public boolean isBookingButtonDisplayed() {
		return bookingHeaderButton.isDisplayed();
	}
	

}
