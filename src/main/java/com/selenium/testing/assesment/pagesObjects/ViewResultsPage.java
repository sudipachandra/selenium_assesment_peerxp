package com.selenium.testing.assesment.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewResultsPage {

	@FindBy(xpath = "//*[@name=\"origin_0\"]")
	private WebElement fromField;
	@FindBy(xpath = "//*[@name=\"destination_0\"]")
	private WebElement toField;
	@FindBy(xpath = "//*[@id=\"flight_depart_date_0\"]")
	private WebElement departureDateField;

	private WebDriver driver = null;

	public ViewResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String fromFieldValue() throws InterruptedException {
		return fromField.getAttribute("value");
	}

	public String toFieldValue() throws InterruptedException {
		return toField.getAttribute("value");
	}
}
