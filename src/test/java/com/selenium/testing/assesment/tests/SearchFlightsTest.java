package com.selenium.testing.assesment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.testing.assesment.pagesObjects.SearchFlightsPage;
import com.selenium.testing.assesment.pagesObjects.ViewResultsPage;

public class SearchFlightsTest extends TestBaseSetup{

	@Test
	public void testFlights() throws InterruptedException {
		
		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver);
		searchFlightsPage.searchFlights();
		ViewResultsPage viewResultsPage = new ViewResultsPage(driver);
//		String fromFieldValue = viewResultsPage.fromFieldValue();
//		System.out.println("the desired value is :" + fromFieldValue);
		
	}
	
}
