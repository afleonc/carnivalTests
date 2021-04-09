package com.automation.andres.leon.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.andres.leon.pages.HomePage;
import com.automation.andres.leon.pages.SearchResultsPage;

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
	    searchResultsPage.setPriceFilterRange(500, 700);
	    assertTrue(searchResultsPage.areAllResultsInPriceRange(500, 700), "Results out of price range");
	    assertTrue(searchResultsPage.areAllResultsSortedInAscendantOrder(), "Results not sorted in ascendant order");
	}

}
