package com.hcl.selenium.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;
import com.hcl.utility.TestConfig;
import com.hcl.xpathApi.ENGINEERING_API;

public class EnterpriseItemsObject  implements PageObjectInterface {
	
	static boolean check = false;
	static String parentWindowHandler = null;	
	
	 final Logger logger = LoggerFactory.getLogger(EnterpriseItemsObject.class);

	static final int WAIT_TIME = 300;
	public void createEnterpriseItemsbuttonclick(WebDriver driver) {
		logger.debug("EnterpriseItemsObject EnterpriseItemsObjectcreate button clicked");
		String xpathForCreateButton = null;
		
		check=true;
		if (check) {
			xpathForCreateButton = GetDbXpathsAndElemetsDao.getXPath("EnterpriseItemsObject", ENGINEERING_API.XPATH_FOR_CREATE_ITEM_BUTTON_CLICK.toString(),
					"com.hcl.selenium.pageobjects.EnterpriseItemsObject");
			
			WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(createProxy(By.xpath(xpathForCreateButton), TestConfig.MIN_EXPLICIT_WAIT_TIME,driver)));
			int num = 0;
			while (!clickAndWait(xpathForCreateButton, 1, driver)) {
				++num;
				logger.error(num + " attempeting to find sitecreatebuttonclick " + xpathForCreateButton);
				 
			}
		}
	}
	
	@Test
	@Parameters({ "CreateEnterpriseItems_itemName", "CreateEnterpriseItems_itemDescription", "driverName" })
	public void createEnterpriseItems(String CreateEnterpriseItems_itemName,String CreateEnterpriseItems_itemDescription,String driverName ) throws InterruptedException {
		
		WebDriver driver = DriversUtility.getDriverMap(driverName);		
		DriversUtility.setDriverMap(driverName+"createEnterpriseItems", driver);
		DriversUtility.setDriverName(driverName+"createEnterpriseItems", driver.getWindowHandle());		
		createEnterpriseItemsbuttonclick(driver);
		/*String itemName =itemName1;
		String itemDescription = itemDescription1;*/
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		String xPathItemName =GetDbXpathsAndElemetsDao.getXPath("EnterpriseItemsObject", ENGINEERING_API.XPATH_FOR_CREATE_ITEM_NAME.toString(),"com.hcl.selenium.pageobjects.EnterpriseItemsObject"); 
		sendKeys(xPathItemName.trim(), CreateEnterpriseItems_itemName.trim(), driver);
		String xPathItemDesc =GetDbXpathsAndElemetsDao.getXPath("EnterpriseItemsObject", ENGINEERING_API.XPATH_FOR_CREATE_ITEM_DESC.toString(),"com.hcl.selenium.pageobjects.EnterpriseItemsObject"); 
		sendKeys(xPathItemDesc.trim(), CreateEnterpriseItems_itemDescription.trim(), driver);
		String itemSub = "/html/body/div[5]/div[3]/button[1]";
		By locator = By.xpath(itemSub);
		click(locator, driver);
		enterpriseItemPreviewBefore(driver);
	}

	public boolean enterpriseItemPreviewBefore(WebDriver driver) {

		

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
					logger.error("enterItemValues " + exp);

				}
			}
		} catch (Exception eeee) {
			logger.error("enterItemValues ..." + eeee);
		}
		return true;
	}

	// Here pass the driver and frame location(xpath)
	/*public WebDriver switchDriver(final WebDriver localDriver, final By locator) {

		// By locator = By.xpath(XPath);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		WebDriver lDriver = null;
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				lDriver = localDriver.switchTo().frame(localDriver.findElement(locator));
				break;
			} catch (StaleElementReferenceException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				logger.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			logger.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			logger.info("Failed to find element after " + totalTime + " mill.");
		}

		return lDriver;
	}
*/
	/*public boolean validateItem(String validationElements) {
		JSONObject jsonObj = new JSONObject(validationElements);
		try {
			logger.debug("validateItem...  ");
			Thread.sleep(5000);
		} catch (Exception eee) {

		}
		WebDriver dr1 = null;
		WebDriver dr = null;
		String driverName = null;
		try {
			logger.debug("validateItem..............2");
			if (DriversUtility.getDriverMap("itemObjectMainDriver") != null) {
				logger.debug(" if condition Driver....");
				driverName = DriversUtility.getDriverName("itemDriver");
			}

			dr = driver;

			String XPath = "/html/body/div[@id=\"windowPane\"]/div[@id=\"contentPane\"]/div[@id=\"mainPane\"]/iframe";

			logger.debug("validate Site  window title ::: " + dr.getTitle());

			dr.switchTo().window(driverName);
			logger.debug("validate Site after switching window title ::: " + dr.getTitle());

			try {
				Set<String> sts = dr.getWindowHandles();
				for (String s : sts) {
					logger.debug("window Name" + s);
					dr.switchTo().window(s);
					By locator = By.xpath(XPath);
					dr = switchDriver(dr, locator);
					if (dr != null) {
						break;
					} else {
						dr.switchTo().defaultContent();
					}
				}

			} catch (Exception error) {
				logger.error("driver error " + error.getMessage() + "  :::  " + error.getLocalizedMessage());

			}
			logger.debug(" ITS..............");
			String tablePath = "/html/body/div/div/div[@id=\"viewport\"]/div[@id=\"dataTable\"]/div[@class=\"tableRow\"]";

			List<WebElement> listOfDivs = listOfWebElements(tablePath, dr);
			List<WebElement> listOfDivs =null;
			logger.debug(" SIZE ::::::::::::::::::::::::: " + listOfDivs.size());
			String itemName = jsonObj.getString("itemName");
			String itemDescription = jsonObj.getString("itemDescription");
			int count = 0;
			for (WebElement ele : listOfDivs) {

				WebElement nameEle = ele.findElement(By.xpath("div[@class=\"tableCell col2\"]"));
				WebElement descEle = ele.findElement(By.xpath("div[@class=\"tableCell col3\"]"));
				String nameE = nameEle.getText();
				String descE = descEle.getText();

				logger.debug(nameE + "    :  " + descE);

				if (itemName.equals(nameE) && itemDescription.equals(descE)) {
					//FunctionalResultUtility.setFunctionalResult("validation success");
					logger.debug("VALIDATION SUCCESS");
					return true;
				} else {
					count++;
				}
				if (listOfDivs.size() == count) {
					//FunctionalResultUtility.setFunctionalResult("Validation Failed ( Total Records " + count + ")");
				}
			}
		} catch (Exception exp) {
			logger.error("Exception...." + exp);
			return false;
		}
		return true;
	}*/

	/*public boolean navigate(String navigationLinks) {
		String[] links = navigationLinks.split("\\|");
		String path = "/html/body/div[1]/div[3]/div/button[2]";

		try {

			driver.findElement(By.xpath(path)).click();

		} catch (Exception exp) {
			logger.debug("ELEMENT ...  " + exp);
		}
		return true;
	}*/

	public boolean clearPage() {

		return false;
	}
}