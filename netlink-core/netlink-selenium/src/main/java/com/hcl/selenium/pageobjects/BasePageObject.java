package com.hcl.selenium.pageobjects;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.hcl.utility.Log;
import com.hcl.utility.TestConfig;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

//@ContextConfiguration(classes=PageObjectsConfiguration.class)
public class BasePageObject {

	public static final int IMPLICIT_WAIT_TIME = 10;
	//protected WebDriver driver=null;		
	public BasePageObject(){		
	}
	
	
	
	
	public boolean setValue(String locator, String value ,WebDriver webdriver) {
		String xpath =locator; //PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;
		WebElement webElement = createProxy(By.xpath(xpath), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		return setValue(webElement, value,webdriver);
	}
	
	public boolean setValue(WebElement webElement, String value,WebDriver webdriver) {
		webElement = createProxy(webElement,webdriver);
		if (!isWebElementVisible(webElement,webdriver)) {
			// scroll to the element if it is not within the viewable area
			Log.debug("WebEmlement " + webElement
					+ "is not visible on the screen. Scrolling to it before setting value.");
			scrollAndWait(webElement, 1,webdriver);
		}
		if (webElement.getAttribute("readonly") != null) {
			((JavascriptExecutor) webdriver).executeScript("arguments[0].value=arguments[1]", webElement, value);
			return true;
		} else {
			webElement.clear();
			//copyToClipBoard(value);
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "v"), "");
			return true;
		}
	}
	public boolean copyToClipBoard(String value,WebDriver webdriver) {
		StringSelection ss = new StringSelection(value);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		return true;
	}
	public class PageObjectInitError extends RuntimeException {
		public PageObjectInitError(String message, Throwable t) {
			super(message, t);
		}
	}

	
	public boolean sendKeys(final String Stringlocator, final String value, final WebDriver localDriver) {

		By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			Log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				we.sendKeys(value.trim());
				break;
			} catch (StaleElementReferenceException e) {
				Log.info("Stale element: \n" + e.getMessage() + "\n");
				return false;
			} catch (NoSuchElementException nse) {
				Log.info("No such element: \n" + nse.getMessage() + "\n");
				return false;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			Log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			Log.info("Failed to find element after " + totalTime + " mill.");
		}

		return true;
	}

	public WebElement checkAndReturnElement(final By locator, final WebDriver localDriver) {
		Log.debug("Checking an eelment");
		// By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(15000, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			Log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				Log.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				Log.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			Log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			Log.info("Failed to find element after " + totalTime + " mill.");
		}

		return we;
	}

	public boolean click(final By locator, final WebDriver localDriver) {

		// By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			Log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				we.click();
				break;
			} catch (StaleElementReferenceException e) {
				Log.info("Stale element: \n" + e.getMessage() + "\n");
				return false;
			} catch (NoSuchElementException nse) {
				Log.info("No such element: \n" + nse.getMessage() + "\n");
				return false;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			Log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			Log.info("Failed to find element after " + totalTime + " mill.");
		}

		return true;
	}

	public List<WebElement> listOfWebElements(final String Stringlocator, final WebDriver localDriver) {

		By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		List<WebElement> elements = null;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			Log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				elements = we.findElements(locator);
				break;
			} catch (StaleElementReferenceException e) {
				Log.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				Log.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			Log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			Log.info("Failed to find element after " + totalTime + " mill.");
		}

		return elements;
	}

	public boolean moveAndWait(String locator, long timeout,WebDriver webdriver) {
		String xpath = null; // PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;
		WebElement webElement = createProxy(By.xpath(xpath), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		return moveAndWait(webElement, timeout,webdriver);
	}

	public boolean moveAndWait(WebElement webElement, long timeout,WebDriver webdriver) {
		webElement = createProxy(webElement,webdriver);

		int retry = 0;
		while (retry <= TestConfig.NUM_RETRIES_FOR_FAILED_OPERATION) {
			try {
				Log.debug("Retry attempt " + retry + ". Invoking move to element " + getElementLocator(webElement,webdriver));
				Actions actions = new Actions(webdriver);
				actions.moveToElement(webElement).perform();
				break;
			} catch (Exception e) {
				Log.error("Retry attempt " + retry + ". Exception invoking move to element"
						+ getElementLocator(webElement,webdriver), e);
				retry++;
				if (retry > TestConfig.NUM_RETRIES_FOR_FAILED_OPERATION)
					throw e; // exhausted all attempts, throw the except
				// perhaps the method failed because the web element is stale,
				// try finding it once more
				webElement = getElement(getElementLocator(webElement,webdriver), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
			}
		}
		pause(timeout);
		return true;
	}

	public WebElement getElement(String locator, long timeout,WebDriver webdriver) {
		String xpath = null;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;

		WebElement webElement = null;
		try {
			webElement = findElement(locator, timeout,webdriver);
		} catch (Exception e) {
			return null;
		}
		return createProxy(webElement,webdriver);
	}

	public boolean isWebElementVisible(WebElement we,WebDriver webdriver) {
		Dimension weD = we.getSize();
		Point weP = we.getLocation();

		long x = (Long) ((JavascriptExecutor) webdriver).executeScript("return document.documentElement.clientWidth");
		long y = (Long) ((JavascriptExecutor) webdriver).executeScript("return document.documentElement.clientHeight");

		int x2 = weD.getWidth() + weP.getX();
		int y2 = weD.getHeight() + weP.getY();

		return x2 <= x && y2 <= y;
	}

	public boolean scrollAndWait(WebElement webElement, long timeout,WebDriver webdriver) {
		webElement = createProxy(webElement,webdriver);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) webdriver).executeScript("window.scrollTo(" + webElement.getLocation().getX() + ","
				+ (webElement.getLocation().getY() - 100) + ");");
		pause(timeout);
		return true;
	}

	public boolean scrollAndWait(String locator, long timeout,WebDriver webdriver) {
		String xpath = null;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;
		WebElement webElement = createProxy(By.xpath(xpath), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		scrollAndWait(webElement, timeout,webdriver);
		return true;
	}

	public boolean clickAndWaitForElement(String clickLocator, String waitLocator, int retry, long timeout,WebDriver webdriver) {
		int retryCount = 0;
		while (retryCount <= retry) {
			clickAndWait(clickLocator, 0,webdriver);
			if (!waitForElement(waitLocator, timeout,webdriver)) {
				retry++;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean clickAndWait(String locator, long timeout,WebDriver webdriver) {
		String xpath = locator;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;

		WebElement webElement = createProxy(By.xpath(xpath), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		Log.debug("ITS Came here..........." + xpath);
		return clickAndWait(webElement, timeout,webdriver);
	}

	public boolean clickAndWait(WebElement webElement, long timeout,WebDriver webdriver) {
		webElement = createProxy(webElement,webdriver);
		if (webElement.getTagName().equals("input") && (webElement.getAttribute("type").equals("checkbox")
				|| webElement.getAttribute("type").equals("radio"))) {
			moveAndWait(webElement, 1,webdriver);
		}
		if (!isWebElementVisible(webElement,webdriver)) {
			// scroll to the element if it is not within the viewable area to be
			// click-able
			Log.debug("WebEmlement " + webElement + "is not visible on the screen. Scrolling to it before clicking.");
			scrollAndWait(webElement, 1,webdriver);
		}
		webElement.click();
		pause(timeout);
		return true;
	}

	public String getElementLocator(WebElement webElement,WebDriver webdriver) {
		String text = webElement.toString();
		return text.substring(text.indexOf("xpath: ") + 7, text.length() - 1);
	}

	public WebElement createProxy(WebElement webElement,WebDriver webdriver) {
		if (Enhancer.isEnhanced(webElement.getClass())) {
			return webElement;
		} else {
			String locator = getElementLocator(webElement,webdriver);
			return createProxy(By.xpath(locator), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		}
	}

	private static final CallbackFilter FINALIZE_FILTER = new CallbackFilter() {
		public int accept(Method method) {
			if (method.getName().equals("finalize") && method.getParameterTypes().length == 0
					&& method.getReturnType() == Void.TYPE) {
				return 0;
			}
			return 1;
		}
	};

	public WebElement findElement(String locator, long timeout,WebDriver webdriver) {
		String xpath = null;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;
		return findElement(By.xpath(xpath), timeout,webdriver);
	}

	public WebElement findElement(final By by, final long timeout,WebDriver webdriver) {
		long waitTime = TestConfig.MIN_EXPLICIT_WAIT_TIME;
		if (timeout > TestConfig.MIN_EXPLICIT_WAIT_TIME)
			waitTime = timeout;
		// first nullify the implicit wait
		webdriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webdriver).withTimeout(waitTime, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		try {
			WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			String totalTime = new Long(elapsedTime).toString();
			Log.debug("Took " + totalTime + "ms to find element " + by);
			return we;
		} catch (Exception e) {
			Log.error("Fail to find element " + by.toString(), e);
			throw e;
		} finally {
			webdriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		}
	}

	public boolean pause(long delay) {
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public WebElement createProxy(final By by, final long timeout, WebDriver webdriver) {
		
		return (WebElement) Enhancer.create(WebElement.class, new Class<?>[] { WebElement.class, Locatable.class },
				FINALIZE_FILTER, new Callback[] { NoOp.INSTANCE, new MethodInterceptor() {
					private WebElement webElement = null;

					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
							throws Throwable {
						// WebElement webElement = null;
						int retry = 0;
						while (retry <= TestConfig.NUM_RETRIES_FOR_FAILED_OPERATION) {
							try {
								long startTime = System.currentTimeMillis();
								 Log.debug("Retry attempt " + retry );
								// Invoking method " + method.getName() + " on
								// element " + by.toString());
								//webdriver=Browser.getDriver();
								if (webElement == null) {
									List<WebElement> webElements = webdriver.findElements(by);
									if (webElements.size() > 1) {
										Log.debug(
												"Multiple elements found using the same locator. Selecting only the visible element");
										for (WebElement we : webElements) {
											if (we.isDisplayed()) {
												webElement = we;
												break;
											}
										}
									} else {
										webElement = findElement(by, timeout,webdriver);
									}
								}
								Object ret = method.invoke(webElement, args);
								try {
									((JavascriptExecutor) webdriver).executeScript("$('#inforTooltip').remove()");
								} catch (Exception e) {
								}
								long endTime = System.currentTimeMillis();
								long elapsedTime = endTime - startTime;
								String totalTime = new Long(elapsedTime / 1000).toString();
								// Log.debug("Took " + totalTime + " to execute
								// method " + method.getName() + " on element "
								// + by.toString());
								return ret;
							} catch (Throwable e) {
								Log.error("Retry attempt " + retry + ". Exception invoking method " + method.getName()
										+ " on element " + by.toString(), e);
								retry++;
								if (retry > TestConfig.NUM_RETRIES_FOR_FAILED_OPERATION)
									throw e; // exhausted all attempts, throw
												// the exception
								webElement = null;
								pause(TestConfig.RETRY_FAILED_OPERATION_INTERVAL);
							}
						}
						return null;
					}
				} });
	}


	public boolean waitForElement(String locator, long timeout,WebDriver webdriver) {
		try {
			findElement(locator, timeout,webdriver);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
