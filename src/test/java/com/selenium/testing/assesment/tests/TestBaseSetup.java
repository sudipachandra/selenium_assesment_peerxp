package com.selenium.testing.assesment.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBaseSetup {

     static WebDriver driver = null;
 
    @BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
    	//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/");
    }
	
    @AfterMethod
    public void quitDriver() throws InterruptedException {
    	//Thread.sleep(4000);
    	driver.quit();
    }
}
