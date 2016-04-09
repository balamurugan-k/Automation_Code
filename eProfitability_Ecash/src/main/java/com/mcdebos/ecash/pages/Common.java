package com.mcdebos.ecash.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Common {

	public WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public Common(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		action = new Actions(driver);
	}
	
	public Common(String browser) {
		getWebDriver(browser);
	}

	public Common() {}

	public WebDriver getWebDriver(String browser) {
		switch (browser) {
		case "internet-explorer":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();

		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public void navigate(String applicationURL) {
		driver.get(applicationURL);
		(new WebDriverWait(driver, 200)).until(ExpectedConditions.elementToBeClickable(By.id("user-icon")));
	}

}
