package com.selenium.testing.assesment.pagesObjects;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightsPage {

	@FindBy(xpath = "//*[@id=\"BE_flight_origin_city\"]")
	private WebElement departFromField;
	@FindBy(xpath = "//*[@id=\"BE_flight_arrival_city\"]")
	private WebElement goingToField;
	@FindBy(xpath = "/html/body/div[2]/div/section/div[1]/div/div[1]/section/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/ul/li[1]/section/label/input")
	private WebElement departureDateField;
	// @FindBy(xpath="//*[@id=\"02/03/2022\"]")
	@FindBy(xpath = "//*[@id='02/03/2022']")
	private WebElement departureDate;
	@FindBy(xpath = "//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[1]/a")
	private WebElement oneWayButton;
	@FindBy(xpath = "//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[2]/a")
	private WebElement roundTripButton;
	@FindBy(xpath = "//*[@id=\"BE_flight_flsearch_btn\"]")
	private WebElement searchFlightsButton;
	// @FindBy(xpath="//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li")
	@FindBy(xpath = "//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li")
	private WebElement departureCityField;
	// @FindBy(xpath="//*[@class='ac_cityname' and text()='New Delhi ']")
	@FindBy(xpath = "/html/body/div[2]/div/section/div[1]/div/div[1]/section/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/ul/li[3]/div/div/ul/div/div/div/li")
	private WebElement arrivalCityField;

	private WebDriver driver = null;

	public SearchFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ViewResultsPage searchFlights(Hashtable<String, String> data) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement departure = wait.until(ExpectedConditions.elementToBeClickable(departFromField));
		departure.click();
		departure.clear();
		String s = Keys.chord(Keys.CONTROL, "delete ");
		departure.sendKeys(s);
		departure.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		departure.sendKeys(data.get("source_city"));
		WebElement departureCity = wait.until(ExpectedConditions.elementToBeClickable(departureCityField));
		Actions builder = new Actions(driver);
		builder.moveToElement(departureCity).click().build().perform();

		// for going to
		goingToField.click();
		goingToField.clear();
		String s1 = Keys.chord(Keys.CONTROL, "delete ");
		goingToField.sendKeys(s1);
		goingToField.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		goingToField.sendKeys(data.get("destination_city"));
		WebElement arrivalCity = wait.until(ExpectedConditions.elementToBeClickable(arrivalCityField));
		builder = new Actions(driver);
		builder.moveToElement(arrivalCity).click().build().perform();
		Thread.sleep(5000);
		departureDateField.click();
		Thread.sleep(2000);
		WebElement travelDate = driver.findElement(By.xpath("//*[@id='" + data.get("onward_journey_date") + "']"));
		travelDate.click();

		Thread.sleep(4000);
		searchFlightsButton.click();
		return new ViewResultsPage(driver);
	}
}
