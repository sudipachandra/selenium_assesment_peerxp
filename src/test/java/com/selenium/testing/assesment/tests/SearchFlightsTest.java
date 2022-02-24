package com.selenium.testing.assesment.tests;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.testing.assesment.pagesObjects.SearchFlightsPage;
import com.selenium.testing.assesment.pagesObjects.ViewResultsPage;
import com.selenium.testing.assesment.utils.ExcelReader;

public class SearchFlightsTest extends TestBaseSetup {
	
	private static final String inputDataFileDirectoryName = "testdata";
	private static final String inputDataFileName = "input_data.xlsx";
	private static final String sheetname = "searchInputDetails";

	@Test(dataProvider = "searchDetails")
	public void testFlights(Hashtable<String, String> data) throws InterruptedException {
		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver);
		searchFlightsPage.searchFlights(data);

		ViewResultsPage viewResultsPage = new ViewResultsPage(driver);
		String actualFromFieldValue = viewResultsPage.fromFieldValue();
		String actualToFieldValue = viewResultsPage.toFieldValue();
		
		Assert.assertEquals(actualFromFieldValue.substring(0, actualFromFieldValue.indexOf(" (")), data.get("source_city"));
		Assert.assertEquals(actualToFieldValue.substring(0, actualToFieldValue.indexOf(" (")), data.get("destination_city"));

	}

	@DataProvider
	public Object[][] searchDetails() throws IOException {
		String projectPath = System.getProperty("user.dir");
		String filepath = projectPath + File.separator + inputDataFileDirectoryName;
		return ExcelReader.readExcelDataToObjArray(filepath, inputDataFileName, sheetname);
	}
}
