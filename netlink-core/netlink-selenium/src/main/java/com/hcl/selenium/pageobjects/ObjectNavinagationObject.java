package com.hcl.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;


public class ObjectNavinagationObject implements PageObjectInterface /*extends BasePageObject*/ {
	// public static final String LOCATOR_PREFIX = "ObjectNavinagation.";
	/*@Autowired
	TestDataForm demoform;*/

	//WebDriver driver=DriversUtility.getDriverMap("Hari");
	WebDriver baseDriver = null;

	public ObjectNavinagationObject() {

	}

	public ObjectNavinagationObject(WebDriver driver) {
		//super(Login.getDriver());
	}

	public WebDriver switchToObjectDriver(WebDriver driver,final String driverName) {
		try {
			baseDriver =DriversUtility.getDriverMap(driverName);;
			DriversUtility.setDriverMap("siteObjectMainDriver", baseDriver);
			driver = driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div/div[3]/div/iframe")));

		} catch (Exception eeee) {
			Log.error("EEEEEEEEEEEEEEEEEEEEEE............" + eeee);
		}
		return driver;
	}

	
	
	@Test/*(dependsOnMethods = { "loginInputs", "appCardsNavigation" ,"tabCardsNavigation"})*/
	@Parameters({"objNavigation","driverName"})
	public void objNavinagation(String objNavigation,final String driverName) {
		WebDriver driver=DriversUtility.getDriverMap(driverName);
		driver=switchToObjectDriver(driver,driverName);
		String[] links = objNavigation.split("\\|");

		if (clickAndWait("/html/body/div/div/p[contains(.,'" + links[0].trim() + "')]", 3, driver)) {
			Log.debug(" objnavigation ." + objNavigation);
		} else {
			Log.error("Failed to novigation objnavigation ." + objNavigation);
		}
		int tries = 0, maxTries = 1;
		tries++;
		driver = baseDriver;

	}

	public boolean clearPage() {

		return false;
	}

	/*
	 * public boolean logout(){ try { return clickAndWait(LOCATOR_PREFIX +
	 * "Logout",3,driver); } catch (Exception e) {
	 * 
	 * pause(10); return clickAndWait(LOCATOR_PREFIX + "Logout",3,driver); } }
	 */
}
