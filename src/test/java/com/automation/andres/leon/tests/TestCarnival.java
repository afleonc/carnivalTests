package com.automation.andres.leon.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.andres.leon.pages.HomePage;
import com.automation.andres.leon.pages.SearchResultsPage;
import com.automation.andres.leon.pages.TripDetailsPage;

public class TestCarnival extends BaseTests {

	@Test(description = "US01-00 Search cruises with valid dates", groups = { "userStory01" })
	public void searchCruises() {
		HomePage homePage = getHomePage();
		homePage.navigate();
		homePage.selectSailDestination("The Bahamas");
		homePage.selectDuration("6 - 9 Days");
		SearchResultsPage searchResultsPage = homePage.search();
	    assertTrue(searchResultsPage.areGridResultsPresent(), "No grid results are shown");
	}
	
	@Test(description = "US01-01 Filter search results by price", groups = { "userStory01" })
	public void filterSearchResult() {
		HomePage homePage = getHomePage();
		homePage.navigate();
		SearchResultsPage searchResultsPage = homePage.search();
	    searchResultsPage.displayPricingFilterOptions();
	    searchResultsPage.setPriceFilterRange(200, 1800);
	    assertTrue(searchResultsPage.areAllResultsInPriceRange(200, 1800), "Results out of price range");
	    assertTrue(searchResultsPage.areAllResultsSortedInAscendantOrder(), "Results not sorted in ascendant order");
	}
	
	@Test(description = "US02-00 Choose one sail to learn more about the trip", groups = { "userStory02" })
	public void viewTripDetails() {
		HomePage homePage = getHomePage();
		homePage.navigate();
		homePage.selectSailDestination("The Bahamas");
		homePage.selectDuration("6 - 9 Days");
		SearchResultsPage searchResultsPage = homePage.search();
		TripDetailsPage tripDetailsPage = searchResultsPage.selectSearchResultByIndex(1);
		assertTrue(tripDetailsPage.isEachDayInItineraryTile(), "There is not a tile for each day of the itinerary");
		assertTrue(tripDetailsPage.isBookingButtonDisplayed(), "Booking button is not present on header");
	}

}
