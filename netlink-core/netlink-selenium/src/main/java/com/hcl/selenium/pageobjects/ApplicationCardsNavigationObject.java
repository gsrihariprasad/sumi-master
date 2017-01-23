package com.hcl.selenium.pageobjects;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.utility.DriversUtility;



public class ApplicationCardsNavigationObject implements PageObjectInterface/*extends BasePageObject*/ {
	
	Logger logger = LoggerFactory.getLogger(ApplicationCardsNavigationObject.class);
	
	

	public ApplicationCardsNavigationObject() {
		
	}

	@DataProvider(name = "app")
	public Object[][] navigateName(Method m) {

		return new Object[][] { new Object[] { "Engineering" } };
	}

	@Test
	@Parameters({ "appNavigation" ,"driverName"})
	public void appCardsNavigation(String appNavigation,final String driverName) {
		WebDriver driver=DriversUtility.getDriverMap(driverName);
		logger.debug("ApplicationCardsNavigation...navigate" + appNavigation);
		String xpath = "//*[@id=\"bodyFrame\"]/div/ul//*[starts-with(normalize-space(text()),'" + appNavigation + "')]";
		int tries = 0, maxTries = 3;
		while (tries <= maxTries) {

			try {
				if (clickAndWait(xpath, 3, driver)) {
					break;
				}

			} catch (Exception e) {

				logger.error("Fail to click on " + xpath + ". Will retry once more.");
				clickAndWait(xpath, 3, driver);
				tries++;

			}
		}

	}

	public boolean clearPage() {

		return false;
	}

	/*
	 * public boolean logout(){ try { return clickAndWait(LOCATOR_PREFIX +
	 * "Logout",3); } catch (Exception e) { // Pause for few seconds here before
	 * trying again. This is to workaround an issue where // the logout button
	 * is not clickable due to a tooltip window that overlays it pause(10);
	 * return clickAndWait(LOCATOR_PREFIX + "Logout",3); } }
	 */
}
