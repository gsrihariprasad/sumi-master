package com.hcl.selenium.pageobjects;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;

public class TabbedCardsNavigationObject implements PageObjectInterface/*extends BasePageObject*/ {
	 final Logger logger = LoggerFactory.getLogger(TabbedCardsNavigationObject.class);
	// public static final String LOCATOR_PREFIX = "TabbedCardsNavigation.";
	WebDriver baseDriver=null;

	public TabbedCardsNavigationObject() {

	}

	

	/*
	 * public boolean navigateAndWait(String navigationLinks, long timeout) { if
	 * (navigate(navigationLinks)) { pause(timeout); return true; } return
	 * false; }
	 */

	public WebDriver switchToApplicationCardDriver(WebDriver driver,final String driverName) {
		try {
			baseDriver = driver;
			
			String latestFrame = "/html/body/div[@id=\"windowPane\"]//div/div/div[@class=\"ui-tabs-panel\"]/div[@class=\"tabFrame\"]/iframe";
			driver = driver.switchTo().frame(driver.findElement(By.xpath(latestFrame)));

		} catch (Exception eeee) {
			logger.error("TabbedCardsNavigation  switchToApplicationCardDriver.." + eeee);
		}
		return driver;
	}

	@DataProvider(name = "tabbed")
	public Object[][] tabbedcard(Method m) {

		Object[][] data = new Object[3][2];

		return new Object[][] { new Object[] { "Enterprise PDM" } };
	}
	@Test(groups="common")
	//@Test/*(dependsOnMethods = { "loginInputs", "appCardsNavigation" })*/
	@Parameters({ "tabNavigation","driverName" })
	public void tabCardsNavigation(String tabNavigation,final String driverName) {
		WebDriver driver=DriversUtility.getDriverMap(driverName);
		String navigationLinks = tabNavigation;
		driver=switchToApplicationCardDriver(driver,driverName);
		int tries = 0, maxTries = 3;
		while (tries <= maxTries) {
			if (clickAndWait("//*[@id=\"windowPane\"]/div/ul/li[contains(.,'" + navigationLinks.trim() + "')]", 3,
					driver)) {
				break;
			} else {
				tries++;
			}
		}
		driver = baseDriver;
	}

	public boolean clearPage() {

		return false;
	}

	/*
	 * public boolean logout() { try { return clickAndWait(LOCATOR_PREFIX +
	 * "Logout", 3); } catch (Exception e) {
	 * 
	 * pause(10); return clickAndWait(LOCATOR_PREFIX + "Logout", 3); } }
	 */
}
