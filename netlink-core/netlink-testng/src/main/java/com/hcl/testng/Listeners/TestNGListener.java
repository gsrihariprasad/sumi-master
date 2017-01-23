package com.hcl.testng.Listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.hcl.mongodb.DaoServices.ResultSeleniumDao;

public class TestNGListener extends TestListenerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TestNGListener.class);
	private List<ITestContext> m_testContexts = Collections.synchronizedList(new ArrayList<ITestContext>());

	public List<ITestContext> getM_testContexts() {
		return m_testContexts;
	}

	public void setM_testContexts(List<ITestContext> m_testContexts) {
		this.m_testContexts = m_testContexts;
	}
	 @Override
	  public void onFinish(ITestContext testContext) {
		 
		 ResultSeleniumDao.saveResults(testContext);
		 logger.info("  onFinish......"+testContext.getPassedTests().getAllResults().toString());
	  }
	@Override
	public void onTestStart(ITestResult tr) {
		logger.info("Test Started.......................");

	}

	/*@Override
	public void onStart(ITestContext testContext) {

		logger.info("Test Started.. onStart  .....................");

		m_testContexts.add(testContext);
	}*/

	@Override
	public void onTestSuccess(ITestResult tr) {

		logger.info("Test  Name::'" + tr.getName() + "' PASSED");

		// This will print the class name in which the method is present
		logger.info(" Test Class ::" + tr.getTestClass());

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		logger.info("Priority of this method is ::" + tr.getMethod().getPriority());

	}

	@Override
	public void onTestFailure(ITestResult tr) {

		logger.info("Test '" + tr.getName() + "' FAILED");
		logger.info("Priority of this method is " + tr.getMethod().getPriority());
		logger.info(".....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		logger.info(".....");
	}

	private void log(String methodName) {
		logger.info(methodName);
	}

	private void log(IClass testClass) {
		logger.info(""+testClass);
	}
}