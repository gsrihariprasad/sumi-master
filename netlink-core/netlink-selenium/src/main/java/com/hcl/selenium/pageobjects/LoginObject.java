package com.hcl.selenium.pageobjects;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;



public class LoginObject extends BasePageObject {
	Logger logger = LoggerFactory.getLogger(LoginObject.class);

	/*
	 * @Autowired
	 * 
	 * @Qualifier("commonInterface") public CommonInterface commonInterface;
	 */

	public LoginObject() {

	}

	public int retry;
	public static final String LOCATOR_PREFIX = "Login.";
	
	// WebDriver driver = new Browser("webdriver.chrome.driver", "d://chromedriver.exe", "http://localhost:39379/NetLink/");

	

	// WebDriver driver=Browser.getDriver();
	
	/*@DataProvider(name = "dp")
	public Object[][] userName(Method m) {

		Object[][] data = new Object[3][2];

		return new Object[][] { new Object[] { "PRASGSR", "shyam123" } };
	}*/
	
	

	@Test
	@Parameters({ "userName", "password", "driverName","driverPath"})
	public void loginInputs(String userName,String password,final String driverName,String driverPath) throws Exception {		
		
		WebDriver driver=null;
		
		
		try{
		driver =Browser.getNewWebDriver("webdriver.chrome.driver", "D:\\chromedriver.exe", "http://10.119.6.77:39379/NetLink/");
		
		//System.setProperty("webdriver.chrome.driver", "/Users/xxxxx/chromedriver");
		
		DriversUtility.setDriverMap(driverName, driver);
		//it.setAttribute("WebDriver", driver);
		}catch(Exception exp){
			
		}
		
		
		
		
		logger.debug("Entered Login  login()   "+driverPath);

		String userNameXpath = null;
		String passwordXpath;
		String signIn;

		try {
			Thread.sleep(1000);
			userNameXpath = GetDbXpathsAndElemetsDao.getXPath("LoginObject", "username","com.hcl.selenium.pageobjects.LoginObject");
		} catch (Exception ex) {
			logger.error("Login Exception Occured : " + ex);

		}
		WebElement element = null;

		try {
			element = driver.findElement(By.xpath(userNameXpath));

		} catch (Exception exp) {
			logger.error("EXception eee" + exp);
		}
		element.sendKeys(userName); // send also a "\n"
		passwordXpath =GetDbXpathsAndElemetsDao.getXPath("LoginObject", "password","com.hcl.selenium.pageobjects.LoginObject");
		// driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password); com.hcl.netlink.objects.Login
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);

		signIn = GetDbXpathsAndElemetsDao.getXPath("LoginObject", "signIn","com.hcl.selenium.pageobjects.LoginObject");
		// clickAndWait("//*[@id=\"frmLoginData\"]/div/div[2]/button", 3,
		// driver);

		clickAndWait(signIn, 3, driver);
		logger.debug("completed Login  login()");
	}

	@DataProvider(name = "login8")
	public Object[][] createData(Method m) {
		logger.info(m.getName()); // print test method name
		return new Object[][] { new Object[] { "login8  srsrsr" } };
	}

	@Test(dataProvider = "login8")
	public void test1(String s) {

		logger.info("**************************" + s);

	}

	
	
	
	//@BeforeSuite
	public ITestContext getdriver(ITestContext it){
		
		//String drivertype=it.getAttribute("drivertype").toString();
		//String driverpath=it.getAttribute("driverpath").toString();
		//String url=it.getAttribute("url").toString();
		//WebDriver driver =Browser.getNewWebDriver("webdriver.chrome.driver", "d://chromedriver.exe", "http://localhost:39379/NetLink/");
		//it.setAttribute("WebDriver", driver);
		logger.debug("Browser class executoed...");
		//System.setProperty(drivertype, driverpath);
		// driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.navigate().to(url);	
		//return it;
		return it;
	}
	
}
