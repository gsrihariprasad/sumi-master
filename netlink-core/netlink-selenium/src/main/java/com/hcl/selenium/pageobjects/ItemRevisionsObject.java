package com.hcl.selenium.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;
import com.hcl.xpathApi.ENGINEERING_API;

public class ItemRevisionsObject implements PageObjectInterface {
	public static final String LOCATOR_PREFIX = "ItemRevisionsObject.";
	static boolean check = false;
	static String parentWindowHandler = null;

	private static final Logger logger = LoggerFactory.getLogger(ItemRevisionsObject.class);

	public void createItemRevisionButtonclick(WebDriver driver) {

		String XPATH_FOR_CREATE_ROUTING_BUTTON = null;
		if (check) {
			XPATH_FOR_CREATE_ROUTING_BUTTON = GetDbXpathsAndElemetsDao.getXPath("RoutingObject",
					ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_BUTTON.toString(),
					"com.hcl.selenium.pageobjects.RoutingObject");
			int num = 0;
			while (!clickAndWait(XPATH_FOR_CREATE_ROUTING_BUTTON.trim(), 1, driver)) {
				++num;
				logger.error(num + " attempeting to find sitecreatebuttonclick " + XPATH_FOR_CREATE_ROUTING_BUTTON);
			}
		}
	}

	@Test
	@Parameters({ "createItemRevision_SitName", "createItemRevision_ItemName", "createItemRevision_ItemRevionName",
			"createItemRevision_ItemDescrption", "driverName" })
	public void createItemRevision(final String createItemRevision_SitName, final String createItemRevision_ItemName,
			final String createItemRevision_ItemRevionName, final String createItemRevision_ItemDescrption,
			final String driverName) throws InterruptedException {

		WebDriver driver = DriversUtility.getDriverMap(driverName);
		check = true;
		DriversUtility.setDriverMap("ITEMREVISIONSOBJECTITEMREVISIONDRIVER", driver);
		DriversUtility.setDriverName("ITEMREVISIONSOBJECTITEMREVISIONDRIVER", driver.getWindowHandle());
		String siteName = createItemRevision_SitName;
		String itemName = createItemRevision_ItemName;
		String itemRevisionName = createItemRevision_ItemRevionName;
		String itemDescription = createItemRevision_ItemDescrption;

		String xPathSiteName = GetDbXpathsAndElemetsDao.getXPath("ItemRevisionsObject",
				ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_SITENAME.toString(),
				"com.hcl.selenium.pageobjects.ItemRevisionsObject");
		sendKeys(xPathSiteName.trim(), siteName.trim(), driver);

		String xPathItemName = GetDbXpathsAndElemetsDao.getXPath("ItemRevisionsObject",
				ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMNAME.toString(),
				"com.hcl.selenium.pageobjects.ItemRevisionsObject");
		sendKeys(xPathItemName.trim(), itemName.trim(), driver);
		String xPathItemRevisionName = GetDbXpathsAndElemetsDao.getXPath("ItemRevisionsObject",
				ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMREVISIONNAME.toString(),
				"com.hcl.selenium.pageobjects.ItemRevisionsObject");
		sendKeys(xPathItemRevisionName.trim(), itemRevisionName.trim(), driver);
		String xPathItemDesc = GetDbXpathsAndElemetsDao.getXPath("ItemRevisionsObject",
				ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMDESC.toString(),
				"com.hcl.selenium.pageobjects.ItemRevisionsObject");
		sendKeys(xPathItemDesc.trim(), itemDescription.trim(), driver);

		String itemReviewSub = "/html/body/div[6]/div[3]/button[1]";
		By locator = By.xpath(itemReviewSub);
		click(locator, driver);
		createItemRevisionPreviewBefore(driver);
	}

	public boolean createItemRevisionPreviewBefore(WebDriver driver) {

		try {
			Thread.sleep(20000);
			String subdriver = null;
			Set<String> handles = driver.getWindowHandles(); // get all window
			// handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				WebDriver dr = null;
				subdriver = iterator.next();
				Log.debug(subdriver);
				dr = driver.switchTo().window(subdriver);
				try {
					Log.debug("K GOOD.............1");
					String path = "/html/body/div[1]/div[3]/div/button[2]";
					By locator1 = By.xpath(path);
					WebElement result = checkAndReturnElement(locator1, dr);
					result.click();
					/*
					 * if (result) { WebDriverWait wait = new WebDriverWait(dr,
					 * 15000); Log.debug("LETS CLICK>>>>>>>>>>>>>>>>>");
					 * wait.until(ExpectedConditions.elementToBeClickable(
					 * locator1)).click();
					 * 
					 * }
					 */
					// if (click(locator1, dr))
					// driver.findElement(locator1).click();
					// break;

				} catch (Exception exp) {
					Log.error("enterItemRevisionValues " + exp);

				}
			}
		} catch (Exception eeee) {
			Log.error("enterItemRevisionValues ..." + eeee);
		}
		return true;
	}

	// Here pass the driver and frame location(xpath)
	/*
	 * public WebDriver switchDriver(final WebDriver localDriver, final By
	 * locator) {
	 * 
	 * // By locator = By.xpath(XPath); Wait<WebDriver> wait = new
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
	 * public boolean validateItemRevision(String validationElements) {
	 * JSONObject jsonObj = new JSONObject(validationElements); try {
	 * Log.debug("validateItemRevision...  "); Thread.sleep(5000); } catch
	 * (Exception eee) {
	 * 
	 * } WebDriver dr1 = null; WebDriver dr = null; String driverName = null;
	 * try { Log.debug("validateItemRevision..............2"); if
	 * (DriversUtility.getDriverMap("itemRevisionObjectMainDriver") != null) {
	 * Log.debug(" if condition Driver...."); driverName =
	 * DriversUtility.getDriverName("itemRevisionDriver"); }
	 * 
	 * dr = driver;
	 * 
	 * String XPath =
	 * "/html/body/div[@id=\"windowPane\"]/div[@id=\"contentPane\"]/div[@id=\"mainPane\"]/iframe";
	 * 
	 * Log.debug("validate Item revision  window title ::: " + dr.getTitle());
	 * 
	 * dr.switchTo().window(driverName);
	 * Log.debug("validate Item revision after switching window title ::: " +
	 * dr.getTitle());
	 * 
	 * try { Set<String> sts = dr.getWindowHandles(); for (String s : sts) {
	 * Log.debug("window Name" + s); dr.switchTo().window(s); By locator =
	 * By.xpath(XPath); dr = switchDriver(dr, locator); if (dr != null) { break;
	 * } else { dr.switchTo().defaultContent(); } }
	 * 
	 * } catch (Exception error) { System.out.println("driver error " +
	 * error.getMessage() + "  :::  " + error.getLocalizedMessage());
	 * 
	 * } Log.debug(" ITS.............."); String tablePath =
	 * "/html/body/div/div/div[@id=\"viewport\"]/div[@id=\"dataTable\"]/div[@class=\"tableRow\"]";
	 * List<WebElement> listOfDivs = null;
	 * 
	 * List<WebElement> listOfDivs = listOfWebElements(tablePath, dr);
	 * 
	 * Log.debug(" SIZE ::::::::::::::::::::::::: " + listOfDivs.size()); String
	 * siteName = jsonObj.getString("siteName"); String itemName =
	 * jsonObj.getString("itemName"); String itemRevisionName =
	 * jsonObj.getString("itemRevisionName"); String itemDescription =
	 * jsonObj.getString("itemDescription"); int count = 0; for (WebElement ele
	 * : listOfDivs) {
	 * 
	 * WebElement siteNameEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col2\"]")); WebElement
	 * itemNameEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col2\"]")); WebElement
	 * itemRevisionNameEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col2\"]")); WebElement
	 * itemDescEle =
	 * ele.findElement(By.xpath("div[@class=\"tableCell col3\"]")); String
	 * siteNameE = siteNameEle.getText(); String ItemNameE =
	 * itemNameEle.getText(); String itemRevisionNameE =
	 * itemRevisionNameEle.getText(); String itemDescE = itemDescEle.getText();
	 * 
	 * System.out.println( siteNameE + "    :  " + ItemNameE + "    :  " +
	 * itemRevisionNameE + "    :  " + itemDescE);
	 * 
	 * if (siteName.equals(siteNameE) && itemName.equals(ItemNameE) &&
	 * itemRevisionName.equals(itemRevisionNameE) &&
	 * itemDescription.equals(itemDescE)) {
	 * FunctionalResultUtility.setFunctionalResult("validation success");
	 * Log.debug("VALIDATION SUCCESS"); return true; } else { count++; } if
	 * (listOfDivs.size() == count) { FunctionalResultUtility.
	 * setFunctionalResult("Validation Failed ( Total Records " + count + ")");
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
	 * } catch (Exception exp) { System.out.println("ELEMENT ...  " + exp); }
	 * return true; }
	 */

	public boolean clearPage() {

		return false;
	}
}

/*
 * public class ItemRevisionsObject extends PageObject { public static final
 * String LOCATOR_PREFIX = "ItemRevisionsObject.";
 * 
 * public ItemRevisionsObject(WebDriver driver) { super(driver); // getDriver();
 * 
 * }
 * 
 * static String parentWindowHandler = null;
 * 
 * public boolean enterItemRevisionValues(String itemRevisionValues) throws
 * InterruptedException { JSONObject jsonObj = new
 * JSONObject(itemRevisionValues);
 * DriversUtility.setDriverMap("itemRevisionDriver", driver); String siteName =
 * jsonObj.getString("siteName"); String itemName =
 * jsonObj.getString("itemName"); String itemRevisionName =
 * jsonObj.getString("itemRevisionName"); String itemDescription =
 * jsonObj.getString("itemDescription"); String xPathSiteName =
 * PageMaster.getElementLocator(LOCATOR_PREFIX + "enterSiteName");
 * driver.findElement(By.xpath(xPathSiteName)).sendKeys(sitName.trim()); String
 * xPathItemName = PageMaster.getElementLocator(LOCATOR_PREFIX +
 * "enterItemName");
 * driver.findElement(By.xpath(xPathItemName)).sendKeys(itemName.trim()); String
 * xPathItemRevisionName = PageMaster.getElementLocator(LOCATOR_PREFIX +
 * "enterItemRevisionName");
 * driver.findElement(By.xpath(xPathItemRevisionName)).sendKeys(itemRevisionName
 * ); String xPathItemDesc = PageMaster.getElementLocator(LOCATOR_PREFIX +
 * "enterItemDescription");
 * driver.findElement(By.xpath(xPathItemDesc)).sendKeys(itemDescription);
 * 
 * String xpathInitialReleaseDropDown =
 * PageMaster.getElementLocator(LOCATOR_PREFIX + "enterItemInitialRelease");
 * driver.findElement(By.xpath(xpathInitialReleaseDropDown)).sendKeys("No");
 * //Select dropdown = new Select(driver.findElement(By.xpath(
 * "/html/body/div[6]/div[2]/div[2]/div[7]/div[1]/div[1]/table/tbody/tr/td/input"
 * ); //dropdown.selectByValue(" "); //dropdown.selectByVisibleText("No");
 * //dropdown.selectByVisibleText("Yes");
 * //dropdown.selectByVisibleText("Yes, auto sync");
 * 
 * String itemSub = "/html/body/div[5]/div[3]/button[1]";
 * driver.findElement(By.xpath(itemSub)).click(); String subdriver = null;
 * Thread.sleep(10000); Set<String> handles = driver.getWindowHandles(); // get
 * all window // handles Iterator<String> iterator = handles.iterator(); try {
 * while (iterator.hasNext()) { WebDriver dr = null; subdriver =
 * iterator.next(); Log.debug(subdriver); dr =
 * driver.switchTo().window(subdriver); try { Log.debug("K GOOD.............1");
 * String path = "/html/body/div[1]/div[3]/div/button[2]";
 * dr.findElement(By.xpath(path)).click(); Log.debug("K GOOD.............2");
 * 
 * } catch (Exception exp) {
 * Log.debug(" NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
 * 
 * } } } catch (Exception eeee) {
 * 
 * }
 * 
 * return true; }
 * 
 * public boolean validateItem(String validationElements) { JSONObject jsonObj =
 * new JSONObject(validationElements); try { Thread.sleep(1500); } catch
 * (Exception eee) {
 * 
 * } WebDriver dr = null; try { // siteObjectMainDriver if
 * (DriversUtility.getDriverMap("itemRevisionObjectMainDriver") != null) dr =
 * DriversUtility.getDriverMap("itemRevisionObjectMainDriver"); else dr =
 * driver; dr.switchTo().defaultContent();
 * 
 * // dr=DriversUtility.getDriverMap("siteObjectMainDriver"); String itemName =
 * jsonObj.getString("itemName");
 * 
 * String sitName = jsonObj.getString("sitName"); String itemDescription =
 * jsonObj.getString("itemDescription"); String path =
 * "/html/body/div[@id=\"windowPane\"]/div[@id=\"contentPane\"]/div[@id=\"mainPane\"]/iframe";
 * try { WebDriverWait wait = new WebDriverWait(dr, 40);//wait for 40 sec.
 * //WebElement element =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
 * dr.switchTo().frame(dr.findElement(By.xpath(path))); //dr =
 * dr.switchTo().frame(dr.findElement(By.xpath(path))); } catch (Exception
 * error) { System.out.println("driver error " + error.getMessage() + "  :::  "
 * + error.getLocalizedMessage()); Thread.sleep(1000); dr =
 * dr.switchTo().frame(driver.findElement(By.xpath(path))); }
 * Log.debug(" ITS.............."); String tablePath =
 * "/html/body/div/div/div[@id=\"viewport\"]/div[@id=\"dataTable\"]/div[@class=\"tableRow\"]";
 * List<WebElement> listOfDivs = dr.findElements(By.xpath(tablePath));
 * Log.debug(" SIZE ::::::::::::::::::::::::: " + listOfDivs.size()); for
 * (WebElement ele : listOfDivs) {
 * 
 * WebElement nameEle =
 * ele.findElement(By.xpath("div[@class=\"tableCell col2\"]")); WebElement
 * descEle = ele.findElement(By.xpath("div[@class=\"tableCell col3\"]")); String
 * nameE = nameEle.getText(); String descE = descEle.getText();
 * 
 * System.out.println(nameE + "    :  " + descE);
 * 
 * if (itemName.equals(nameE) && itemDescription.equals(descE)) {
 * Log.debug("SUCESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"); return true; }
 * 
 * } } catch (Exception exp) { Log.error("Exception...." + exp); return false; }
 * return true; }
 * 
 * public boolean navigate(String navigationLinks) { String[] links =
 * navigationLinks.split("\\|"); String path =
 * "/html/body/div[1]/div[3]/div/button[2]";
 * 
 * try {
 * 
 * driver.findElement(By.xpath(path)).click();
 * 
 * } catch (Exception exp) { System.out.println("ELEMENT ...  " + exp); } return
 * true; }
 * 
 * 
 * public boolean clearPage() {
 * 
 * return false; } }
 */
