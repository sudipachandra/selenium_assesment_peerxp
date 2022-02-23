package com.selenium.testing.assesment.pagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightsPage {

	@FindBy(xpath="//*[@id=\"BE_flight_origin_city\"]")
	private WebElement departFromField;
	@FindBy(xpath="//*[@id=\"BE_flight_arrival_city\"]")
	private WebElement goingToField;
	@FindBy(xpath="/html/body/div[2]/div/section/div[1]/div/div[1]/section/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/ul/li[1]/section/label/input")
	private WebElement departureDateField;
	@FindBy(xpath="//*[@id=\"02/03/2022\"]")
	private WebElement departureDate;
	@FindBy(xpath="//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[1]/a")
	private WebElement oneWayButton;
	@FindBy(xpath="//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[2]/a")
	private WebElement roundTripButton;
	@FindBy(xpath="//*[@id=\"BE_flight_flsearch_btn\"]")
	private WebElement searchFlightsButton;
	//@FindBy(xpath="//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li")
	@FindBy(xpath="//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li")
	private WebElement departureCityField;
	//@FindBy(xpath="//*[@class='ac_cityname' and text()='New Delhi ']")
	@FindBy(xpath="/html/body/div[2]/div/section/div[1]/div/div[1]/section/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/ul/li[3]/div/div/ul/div/div/div/li")
	private WebElement arrivalCityField;
	
	
	WebDriver driver = null;
	
	public SearchFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public ViewResultsPage searchFlights() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//for depart from
		WebElement departure = wait.until(ExpectedConditions.elementToBeClickable(departFromField));
		departure.click();
		departure.clear();
		String S = Keys.chord(Keys.CONTROL, "delete ");
		departure.sendKeys(S);
		departure.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
//		departure.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		departure.sendKeys("Bangalore");
		//Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".ac_over")).click();
//		Actions builder = new Actions(driver);
//		builder.sendKeys(Keys.ENTER);
		
//		departure.sendKeys(Keys.ENTER);
		//driver.findElement(By.id("IDValue")).sendKeys(Keys.ENTER);
		//Thread.sleep(5000);
		WebElement departureCity = wait.until(ExpectedConditions.elementToBeClickable(departureCityField));
		Actions builder=new Actions(driver);
	    builder.moveToElement(departureCity).click().build().perform();
		
	    //for going to
	    goingToField.click();
		goingToField.clear();
	    String S1 = Keys.chord(Keys.CONTROL, "delete ");
	    goingToField.sendKeys(S);
	    goingToField.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		goingToField.sendKeys("New Delhi");
		//driver.findElement(By.cssSelector(".ac_over")).click();
//		driver.findElement(By.id("IDValue")).sendKeys(Keys.ENTER);
		//Thread.sleep(4000);
		WebElement arrivalCity = wait.until(ExpectedConditions.elementToBeClickable(arrivalCityField));
		Actions builder1=new Actions(driver);
	    builder1.moveToElement(arrivalCity).click().build().perform();
	    Thread.sleep(5000);
//	    driver.findElement(By.cssSelector(".ac_over")).click();
	   // WebElement travelDateField = wait.until(ExpectedConditions.elementToBeClickable(departureDateField));
	   // System.out.println("11111");
	    departureDateField.click();
		//builder.moveToElement(travelDateField).click().build().perform();
	   // System.out.println("3456");
//	    travelDateField.click();
	   // System.out.println("3456");
  	  WebElement travelDate = wait.until(ExpectedConditions.elementToBeClickable(departureDate));
  //	System.out.println("22222");
	   travelDate.click();
	  // System.out.println("3333");
	  // driver.findElement(By.cssSelector(".ac_over")).click();
        Thread.sleep(4000);
        searchFlightsButton.click();
//        WebElement submitSeaerch = wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
//        submitSeaerch.click();
		return new ViewResultsPage(driver);
	}
	
}
