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
import com.hcl.xpathApi.ENGINEERING_API;

/*
XPATH_FOR_CREATE_ROUTING_NAME		/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input
XPATH_FOR_CREATE_ROUTING_IDENTIFIER		/html/body/div[5]/div[2]/div[2]/div[4]/div/input
XPATH_FOR_CREATE_ROUTING_VERSION		/html/body/div[5]/div[2]/div[2]/div[5]/div/div/table/tbody/tr/td[1]/input
XPATH_FOR_CREATE_ROUTING_DESC		/html/body/div[5]/div[2]/div[2]/div[6]/div/input

create	XPATH_FOR_CREATE_ROUTING_BUTTON		/html/body/div[1]/div[3]/div/button[11]

change		/html/body/div[1]/div[3]/div/button[12]
delete		/html/body/div[1]/div[3]/div/button[14]
quickChange		/html/body/div[1]/div[3]/div/button[13]

XPATH_FOR_CHANGE_ROUTING_SITE_NAME		/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
XPATH_FOR_CHANGE_ROUTING_IDENTIFIER		/html/body/div[4]/div[2]/div[2]/div[2]/div/input
XPATH_FOR_CHANGE_ROUTING_VERSION		/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input
XPATH_FOR_CHANGE_ROUTING_DESC		/html/body/div/div[4]/div/div/div[2]/div/div/div/div/div/input

XPATH_FOR_DELETE_ROUTING_SITENAME		/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
XPATH_FOR_DELETE_ROUTING_SITENAME		/html/body/div[4]/div[2]/div[2]/div[2]/div/input
XPATH_FOR_DELETE_ROUTING_VERSION		/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input

XPATH_FOR_QUICKCHANGE_ROUTING_NAME		/html/body/div[5]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER		/html/body/div[5]/div[2]/div[2]/div[2]/div/input
XPATH_FOR_QUICKCHANGE_ROUTING_VERSION		/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input
*/
public class RoutingObject implements PageObjectInterface {

	// WebDriver driver=null;
	private static final Logger logger = LoggerFactory.getLogger(RoutingObject.class);

	public RoutingObject() {

	}

	static boolean check = false;
	static String parentWindowHandler = null;

	public void routingCreateButtonclick(WebDriver driver) {

		String XPATH_FOR_CREATE_ROUTING_BUTTON = null;
		if (check) {
			XPATH_FOR_CREATE_ROUTING_BUTTON = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
					ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_BUTTON.toString(),
					"com.hcl.selenium.pageobjects.RoutingObject");
			int num = 0;
			while (!clickAndWait(XPATH_FOR_CREATE_ROUTING_BUTTON.trim(), 1, driver)) {
				++num;
				logger.error(num + " attempeting to find sitecreatebuttonclick " + XPATH_FOR_CREATE_ROUTING_BUTTON);
			}
		}
	}

	// insertRoutingValues

	@Test
	@Parameters({ "CreateRouting_RoutingName", "CreateRouting_RoutingIdentifier", "CreateRouting_RoutingVersion",
			"CreateRouting_RoutingDescription", "driverName" })
	public void createRouting(String routingName, String routingIdentifier, String routingVersion,
			String routingDescription, String driverName) throws InterruptedException {
		WebDriver driver = DriversUtility.getDriverMap(driverName);
		logger.debug(" Entered RoutingObject  createRouting() ...");
		check = true;
		routingCreateButtonclick(driver);
		DriversUtility.setDriverMap("routingObjectMainDriver", driver);
		DriversUtility.setDriverName("routingDriver", driver.getWindowHandle());

		String XPATH_FOR_CREATE_ROUTING_NAME = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
				ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_NAME.toString(), "com.hcl.selenium.pageobjects.RoutingObject");
		sendKeys(XPATH_FOR_CREATE_ROUTING_NAME.trim(), routingName.trim(), driver);

		String XPATH_FOR_CREATE_ROUTING_IDENTIFIER = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
				ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_IDENTIFIER.toString(),
				"com.hcl.selenium.pageobjects.RoutingObject");

		sendKeys(XPATH_FOR_CREATE_ROUTING_IDENTIFIER.trim(), routingIdentifier.trim(), driver);
		String XPATH_FOR_CREATE_ROUTING_VERSION = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
				ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_VERSION.toString(),
				"com.hcl.selenium.pageobjects.RoutingObject");

		sendKeys(XPATH_FOR_CREATE_ROUTING_VERSION.trim(), routingVersion.trim(), driver);
		String XPATH_FOR_CREATE_ROUTING_DESC = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
				ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_DESC.toString(), "com.hcl.selenium.pageobjects.RoutingObject");
		sendKeys(XPATH_FOR_CREATE_ROUTING_DESC.trim(), routingDescription.trim(), driver);

		String routingSub = "/html/body/div[5]/div[3]/button[1]";
		By locator = By.xpath(routingSub);
		click(locator, driver);
		 routingPreviewBefore(driver);
	}

	public void routingPreviewBefore(WebDriver driver) {

		try {
			Thread.sleep(20000);
			String subdriver = null;
			Set<String> handles = driver.getWindowHandles(); // get all window
			// handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				WebDriver dr = null;
				subdriver = iterator.next();
				logger.debug(subdriver);
				dr = driver.switchTo().window(subdriver);
				try {
					logger.debug("K GOOD.............1");
					String path = "/html/body/div[1]/div[3]/div/button[2]";
					By locator1 = By.xpath(path);
					WebElement result = checkAndReturnElement(locator1, dr);
					result.click();

				} catch (Exception exp) {
					logger.error("enterRoutingValues " + exp);

				}
			}
		} catch (Exception eeee) {
			logger.error("enterRoutingValues ..." + eeee);
		}

	}

	/*
	 * @DataProvider(name = "routingQuickChangeinput") public Object[][]
	 * routingQuickChangeinputdata(Method m) {
	 * 
	 * return new Object[][] { new Object[] { "Y9X", "EXP11", "9", "yesSuccess"
	 * } };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "routingQuickChangeinput") public boolean
	 * routingQuickChange(String routingName, String routingIdentifier, String
	 * routingVersion, String routingDescription) throws InterruptedException {
	 * 
	 * DriversUtility.setDriverMap("routingDriver", driver);
	 * DriversUtility.setDriverName("routingDriver", driver.getWindowHandle());
	 * 
	 * 
	 * String XPATH_FOR_QUICKCHANGE_ROUTING_NAME
	 * =GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_QUICKCHANGE_ROUTING_NAME.toString(),
	 * "com.hcl.selenium.pageobjects.RoutingObject");
	 * sendKeys(XPATH_FOR_QUICKCHANGE_ROUTING_NAME.trim(), routingName.trim(),
	 * driver);
	 * 
	 * String XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER.toString());
	 * sendKeys(XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER.trim(),
	 * routingIdentifier.trim(), driver);
	 * 
	 * String XPATH_FOR_QUICKCHANGE_ROUTING_VERSION =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_QUICKCHANGE_ROUTING_VERSION.toString());
	 * sendKeys(XPATH_FOR_QUICKCHANGE_ROUTING_VERSION.trim(),
	 * routingVersion.trim(), driver);
	 * 
	 * String routingSub = "/html/body/div[4]/div[3]/button[1]";
	 * driver.findElement(By.xpath(routingSub)).click();
	 * logger.debug("button clicked");
	 * 
	 * 
	 * String XPATH_FOR_QUICKCHANGE_ROUTING_DESC =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_QUICKCHANGE_ROUTING_DESC.toString());
	 * sendKeys(XPATH_FOR_QUICKCHANGE_ROUTING_DESC.trim(),
	 * routingDescription.trim(), driver);
	 * 
	 * String deletePop = "/html/body/div[6]/div[3]/button[1]"; By locator =
	 * By.xpath(deletePop);
	 * 
	 * if (click(locator, driver)) {
	 * logger.debug("Quick Change updated Successfully"); return true;
	 * 
	 * } return false;
	 * 
	 * }
	 * 
	 * @DataProvider(name = "routingDeleteinput") public Object[][]
	 * routingDeleteinputdata(Method m) { return new Object[][] { new Object[] {
	 * "Y9X", "EXP11", "9" } };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "routingDeleteinput") public boolean
	 * deleteRouting(String routingName, String routingIdentifier, String
	 * routingVersion) throws InterruptedException {
	 * 
	 * DriversUtility.setDriverMap("routingDriver", driver);
	 * DriversUtility.setDriverName("routingDriver", driver.getWindowHandle());
	 * 
	 * 
	 * String XPATH_FOR_DELETE_ROUTING_SITENAME =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_DELETE_ROUTING_SITENAME.toString());
	 * sendKeys(XPATH_FOR_DELETE_ROUTING_SITENAME.trim(), routingName.trim(),
	 * driver);
	 * 
	 * String XPATH_FOR_DELETE_ROUTING_IDENTIFIER =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_DELETE_ROUTING_IDENTIFIER.toString());
	 * sendKeys(XPATH_FOR_DELETE_ROUTING_IDENTIFIER.trim(),
	 * routingIdentifier.trim(), driver);
	 * 
	 * String XPATH_FOR_DELETE_ROUTING_VERSION =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_DELETE_ROUTING_VERSION.toString());
	 * sendKeys(XPATH_FOR_DELETE_ROUTING_VERSION.trim(), routingVersion.trim(),
	 * driver);
	 * 
	 * String routingSub = "/html/body/div[4]/div[3]/button[1]"; String
	 * deletePop = "/html/body/div[4]/div[3]/button[1]";
	 * driver.findElement(By.xpath(routingSub)).click();
	 * logger.debug("button clicked"); By locator = By.xpath(routingSub); By
	 * locator1 = By.xpath(deletePop); if (click(locator, driver)) { if
	 * (click(locator1, driver)) { logger.debug("Deleted Successfully");
	 * logger.debug("***********************************"); return true; }
	 * 
	 * } return false;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @DataProvider(name = "routingenterinput") public Object[][]
	 * routingenterinputdata(Method m) {
	 * 
	 * return new Object[][] { new Object[] { "Y9X", "EXP11", "9",
	 * "yesEXP7SuccessRouting" } };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "routingenterinput") public boolean
	 * changeRouting(String routingName, String routingIdentifier, String
	 * routingVersion, String routingDescription) throws InterruptedException {
	 * 
	 * DriversUtility.setDriverMap("routingDriver", driver);
	 * DriversUtility.setDriverName("routingDriver", driver.getWindowHandle());
	 * 
	 * String XPATH_FOR_CHANGE_ROUTING_SITE_NAME =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_CHANGE_ROUTING_SITE_NAME.toString());
	 * sendKeys(XPATH_FOR_CHANGE_ROUTING_SITE_NAME.trim(), routingName.trim(),
	 * driver);
	 * 
	 * 
	 * String XPATH_FOR_CHANGE_ROUTING_IDENTIFIER =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_CHANGE_ROUTING_IDENTIFIER.toString());
	 * sendKeys(XPATH_FOR_CHANGE_ROUTING_IDENTIFIER.trim(),
	 * routingIdentifier.trim(), driver);
	 * 
	 * String XPATH_FOR_CHANGE_ROUTING_VERSION =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_CHANGE_ROUTING_VERSION.toString());
	 * sendKeys(XPATH_FOR_CHANGE_ROUTING_VERSION.trim(), routingVersion.trim(),
	 * driver);
	 * 
	 * String routingSub = "/html/body/div[4]/div[3]/button[1]";
	 * 
	 * driver.findElement(By.xpath(routingSub)).click();
	 * 
	 * String XPATH_FOR_CHANGE_ROUTING_DESC =
	 * commonInterface.getXPath("RoutingObject",
	 * EngineeringApi.XPATH_FOR_CHANGE_ROUTING_DESC.toString());
	 * sendKeys(XPATH_FOR_CHANGE_ROUTING_DESC.trim(), routingDescription.trim(),
	 * driver);
	 * 
	 * return true; }
	 * 
	 * 
	 * 
	 * public boolean changeRoutingPreviewBefore(String preview) {
	 * 
	 * try { Thread.sleep(20000); String subdriver = null; Set<String> handles =
	 * driver.getWindowHandles(); Iterator<String> iterator =
	 * handles.iterator(); while (iterator.hasNext()) { WebDriver dr = null;
	 * subdriver = iterator.next(); Log.debug(subdriver); dr =
	 * driver.switchTo().window(subdriver); try {
	 * Log.debug("K GOOD.............1"); String path =
	 * "/html/body/div[1]/div[3]/div/button[2]"; By locator1 = By.xpath(path);
	 * WebElement result = checkAndReturnElement(locator1, dr); result.click();
	 * 
	 * logger.debug(" YES updated successfully...........");
	 * 
	 * } catch (Exception exp) { Log.error("changeRoutingValues " + exp);
	 * 
	 * } } } catch (Exception eeee) { Log.error("changeRoutingValues ..." +
	 * eeee); } return true; }
	 * 
	 * 
	 * public WebDriver switchDriver(final WebDriver localDriver, final By
	 * locator) {
	 * 
	 * 
	 * Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
	 * .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
	 * .ignoring(StaleElementReferenceException.class); WebDriver lDriver =
	 * null; int tries = 0; boolean found = false; WebElement we = null; final
	 * long startTime = System.currentTimeMillis(); while
	 * ((System.currentTimeMillis() - startTime) < 91000) {
	 * Log.info("Searching for element. Try number " + (tries++)); try { we =
	 * (WebElement)
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); found
	 * = true; lDriver =
	 * localDriver.switchTo().frame(localDriver.findElement(locator)); break; }
	 * catch (StaleElementReferenceException e) { Log.info("Stale element: \n" +
	 * e.getMessage() + "\n"); return null; } catch (NoSuchElementException nse)
	 * { Log.info("No such element: \n" + nse.getMessage() + "\n"); return null;
	 * } } long endTime = System.currentTimeMillis(); long totalTime = endTime -
	 * startTime; if (found) { Log.info("Found element after waiting for " +
	 * totalTime + " mill."); } else { Log.info("Failed to find element after "
	 * + totalTime + " mill."); }
	 * 
	 * return lDriver; }
	 * 
	 * @DataProvider(name = "routingvalidateinput") public Object[][]
	 * routingvalidateinputdata(Method m) {
	 * 
	 * return new Object[][] { new Object[] { "Y9X", "EXP11", "9",
	 * "yesEXP7SuccessRouting" } };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "routingvalidateinput") public boolean
	 * validateRouting(String routingName, String routingIdentifier, String
	 * routingVersion, String routingDescription) {
	 * 
	 * try { Log.debug("validateRouting...   window title ::: " +
	 * driver.getTitle()); Thread.sleep(5000); } catch (Exception eee) {
	 * 
	 * }
	 * 
	 * WebDriver dr = null; String driverName = null; try {
	 * Log.debug("validateRouting..............2"); if
	 * (DriversUtility.getDriverMap("routingObjectMainDriver") != null) {
	 * Log.debug(" if condition Driver...."); driverName =
	 * DriversUtility.getDriverName("routingDriver"); Log.debug(" Driver 2:::  "
	 * + driverName); } dr = driver;
	 * 
	 * String XPath =
	 * "/html/body/div[@id=\"windowPane\"]/div[@id=\"contentPane\"]/div[@id=\"mainPane\"]/iframe";
	 * 
	 * 
	 * dr.switchTo().window(driverName);
	 * Log.debug("validate Routing after switching window title ::: " +
	 * dr.getTitle());
	 * 
	 * try { Set<String> sts = dr.getWindowHandles(); for (String s : sts) {
	 * Log.debug("window Name" + s); dr.switchTo().window(s); By locator =
	 * By.xpath(XPath); dr = switchDriver(dr, locator); if (dr != null) { break;
	 * } else { dr.switchTo().defaultContent(); } }
	 * 
	 * } catch (Exception error) { logger.error("driver error " +
	 * error.getMessage() + "  :::  " + error.getLocalizedMessage());
	 * 
	 * } Log.debug(" ITS.............."); String tablePath =
	 * "/html/body/div/div/div[@id=\"viewport\"]/div[@id=\"dataTable\"]/div[@class=\"tableRow\"]";
	 * 
	 * List<WebElement> listOfDivs = listOfWebElements(tablePath, dr);
	 * logger.debug(" SIZE ::::::::::::::::::::::::: " + listOfDivs.size());
	 * 
	 * int count = 0; for (WebElement ele : listOfDivs) {
	 * 
	 * WebElement identifierEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col2\"]")); WebElement
	 * descEle = ele.findElement(By.xpath("div[@class=\"tableCell col3\"]"));
	 * WebElement siteNameEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col4\"]")); WebElement
	 * versionEle = ele.findElement(By.xpath("div[@class=\"tableCell col5\"]"));
	 * String siteNameE = siteNameEle.getText(); String identifierE =
	 * identifierEle.getText(); String versionE = versionEle.getText(); String
	 * descE = descEle.getText();
	 * logger.debug("**********************************");
	 * logger.debug(siteNameE + "    :  " + routingName);
	 * logger.debug(identifierE + "    :  " + routingIdentifier);
	 * logger.debug(versionE + "    :  " + routingVersion); logger.debug(descE +
	 * "    :  " + routingDescription);
	 * 
	 * 
	 * if (routingName.equals(siteNameE) &&
	 * routingIdentifier.equals(identifierE) && routingVersion.equals(versionE)
	 * && routingDescription.equals(descE)) {
	 * 
	 * Log.debug("VALIDATION SUCCESS"); return true; } else { count++; } if
	 * (listOfDivs.size() == count) {
	 * 
	 * } } } catch (Exception exp) { Log.error("Exception...." + exp); return
	 * false; } return true; }
	 * 
	 * public boolean navigate(String navigationLinks) { String[] links =
	 * navigationLinks.split("\\|"); String path =
	 * "/html/body/div[1]/div[3]/div/button[2]";
	 * 
	 * try {
	 * 
	 * driver.findElement(By.xpath(path)).click();
	 * 
	 * } catch (Exception exp) { logger.error("ELEMENT ...  " + exp); } return
	 * true; }
	 * 
	 * public boolean clearPage() {
	 * 
	 * return false; }
	 */
}
