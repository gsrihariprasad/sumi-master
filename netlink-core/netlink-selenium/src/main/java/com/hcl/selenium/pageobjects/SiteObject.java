package com.hcl.selenium.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;

public class SiteObject implements PageObjectInterface {
	WebDriver driver = null;
	static boolean check = false;
	 final Logger logger = LoggerFactory.getLogger(SiteObject.class);
	public void sitecreatebuttonclick(WebDriver driver) {
		logger.debug("SiteObject sitecreate button clicked");
		String xpathForCreateButton = null;
		if (check) {
			xpathForCreateButton = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xpathForCreateButton",
					"com.hcl.selenium.pageobjects.SiteObject");
			int num = 0;
			while (!clickAndWait(xpathForCreateButton, 1, driver)) {
				++num;
				logger.error(num + " attempeting to find sitecreatebuttonclick " + xpathForCreateButton);
				 
			}
		}
	}

	@Test /*
			 * (dependsOnMethods = { "loginInputs", "appCardsNavigation"
			 * ,"tabCardsNavigation","objNavinagation"})
			 */
	@Parameters({ "createSite_SiteId", "createSite_SiteDesc", "driverName" })
	public void creatSite(String createSite_SiteId, String createSite_SiteDesc, final String driverName) {
		logger.debug("Entered to SiteObject creatSite()");

		driver = DriversUtility.getDriverMap(driverName);
		check = true;

		sitecreatebuttonclick(driver);

		pause(1);

		DriversUtility.setDriverMap(driverName, driver);
		DriversUtility.setDriverName(driverName, driver.getWindowHandle());

		String sitName = createSite_SiteId;
		String siteDescription = createSite_SiteDesc;

		String xPathSiteName = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForSiteName",
				"com.hcl.selenium.pageobjects.SiteObject");
		int num = 0;
		while (!sendKeys(xPathSiteName.trim(), sitName.trim(), driver)) {
			++num;
			logger.error(num + " attempeting to find creatSite " + xPathSiteName);
		}
		String xPathSiteDesc = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForSiteDesc",
				"com.hcl.selenium.pageobjects.SiteObject");
		sendKeys(xPathSiteDesc.trim(), siteDescription.trim(), driver);

		String siteSub = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForsiteSub",
				"com.hcl.selenium.pageobjects.SiteObject");
		By locator = By.xpath(siteSub);
		if (click(locator, driver)) {
			logger.debug("site creation successfully completed");
		} else {
			logger.error("site creation not completed");
		}
		logger.debug("SiteObject site create completed..");
		sitePreviewBefore();
	}

	public void sitePreviewBefore() {

		try {
			Thread.sleep(20000);
			String subdriver = null;
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				WebDriver dr = null;
				subdriver = iterator.next();
				logger.debug(subdriver);
				dr = driver.switchTo().window(subdriver);
				try {
					logger.info("sitePreviewBeforesitePreviewBefore.............1");
					String path = "/html/body/div[1]/div[3]/div/button[2]";
					By locator1 = By.xpath(path);
					WebElement result = checkAndReturnElement(locator1, dr);
					result.click();

				} catch (Exception exp) {
					logger.error("enterSiteValues " + exp);

				}
			}
		} catch (Exception eeee) {
			logger.error("enterSiteValues ..." + eeee);
		}

	}

}
