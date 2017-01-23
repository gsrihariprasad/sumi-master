package com.hcl.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.utility.Log;

public class Browser {
	private static final Logger logger = LoggerFactory.getLogger(Browser.class);
	public Browser() {
		logger.debug("i am constructor Browser() ");

	}

	public static WebDriver getNewWebDriver(String drivertype, String driverpath, String url) {
		Log.debug("Browser class executoed...");
		System.setProperty(drivertype, driverpath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}

	/*
	 * public static void createDiver(String drivertype,String driverpath,String
	 * url){ Log.debug("Browser class executoed...");
	 * System.setProperty(drivertype, driverpath); driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * driver.navigate().to(url);
	 * 
	 * }
	 */

	/*
	 * public static WebDriver getDriver(){ if(driver==null){ new
	 * Browser("webdriver.chrome.driver", "d://chromedriver.exe",
	 * "http://localhost:39379/NetLink/"); } //
	 * createDiver("webdriver.chrome.driver", "d://chromedriver.exe",
	 * "http://localhost:39379/NetLink/"); return driver; }
	 */

}
