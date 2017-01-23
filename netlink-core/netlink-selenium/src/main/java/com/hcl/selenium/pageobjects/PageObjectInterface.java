package com.hcl.selenium.pageobjects;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.hcl.utility.TestConfig;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public interface PageObjectInterface {
	static final int IMPLICIT_WAIT_TIME = 10;
	 final Logger log = LoggerFactory.getLogger(PageObjectInterface.class);
	default  boolean clickAndWait(String locator, long timeout,WebDriver webdriver) {
		String xpath = locator;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;

		WebElement webElement = createProxy(By.xpath(xpath), TestConfig.MIN_EXPLICIT_WAIT_TIME,webdriver);
		log.debug("ITS Came here..........." + xpath);
		webElement.click();
		pause(timeout);
		return true;
	}
	
	default boolean pause(long delay) {
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
		
	default boolean sendKeys(final String Stringlocator, final String value, final WebDriver localDriver) {

		By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				we.sendKeys(value.trim());
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Stale element: \n" + e.getMessage() + "\n");
				return false;
			} catch (NoSuchElementException nse) {
				log.info("No such element: \n" + nse.getMessage() + "\n");
				return false;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			log.info("Failed to find element after " + totalTime + " mill.");
		}

		return true;
	}
	default List<WebElement> listOfWebElements(final String Stringlocator, final WebDriver localDriver) {

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
			log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				elements = we.findElements(locator);
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				log.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			log.info("Failed to find element after " + totalTime + " mill.");
		}

		return elements;
	}

	default boolean click(final By locator, final WebDriver localDriver) {

		// By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				we.click();
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Stale element: \n" + e.getMessage() + "\n");
				return false;
			} catch (NoSuchElementException nse) {
				log.info("No such element: \n" + nse.getMessage() + "\n");
				return false;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			log.info("Failed to find element after " + totalTime + " mill.");
		}

		return true;
	}
	default WebElement checkAndReturnElement(final By locator, final WebDriver localDriver) {
		log.debug("Checking an eelment");
		// By locator = By.xpath(Stringlocator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(15000, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				log.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			log.info("Failed to find element after " + totalTime + " mill.");
		}

		return we;
	}
	default WebElement findElement(String locator, long timeout,WebDriver webdriver) {
		String xpath = null;// PageMaster.getElementLocator(locator);
		if (xpath == null)
			xpath = locator;
		return findElement(By.xpath(xpath), timeout,webdriver);
	}

	
	default WebElement findElement(final By by, final long timeout,WebDriver webdriver) {
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
			log.debug("Took " + totalTime + "ms to find element " + by);
			return we;
		} catch (Exception e) {
			log.error("Fail to find element " + by.toString(), e);
			throw e;
		} finally {
			webdriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		}
	}

default WebElement createProxy(final By by, final long timeout, WebDriver webdriver) {
		
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
								 log.debug("Retry attempt " + retry );
								// Invoking method " + method.getName() + " on
								// element " + by.toString());
								//webdriver=Browser.getDriver();
								if (webElement == null) {
									List<WebElement> webElements = webdriver.findElements(by);
									if (webElements.size() > 1) {
										log.debug(
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
								log.error("Retry attempt " + retry + ". Exception invoking method " + method.getName()
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

static final CallbackFilter FINALIZE_FILTER = new CallbackFilter() {
	public int accept(Method method) {
		if (method.getName().equals("finalize") && method.getParameterTypes().length == 0
				&& method.getReturnType() == Void.TYPE) {
			return 0;
		}
		return 1;
	}
};

}
