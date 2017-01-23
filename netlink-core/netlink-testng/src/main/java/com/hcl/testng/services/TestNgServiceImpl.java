package com.hcl.testng.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.hcl.mongodb.DaoServices.ResultSeleniumDao;
import com.hcl.selenium.common.formpages.TestCasesForm;
import com.hcl.testng.Listeners.TestNGCustomReportListener;
import com.hcl.testng.Listeners.TestNGListener;
import com.hcl.utility.Log;
import com.hcl.utility.STATUS;

@Component(value = "testNgService")
public class TestNgServiceImpl implements TestNgService {


	
	@Autowired
	private ResultSeleniumDao resultSeleniumDao;
	@Autowired
	private TestNGListener listenerClass;
	private static final Logger logger = LoggerFactory.getLogger(TestNgServiceImpl.class);
	

	List<XmlClass> classes = new ArrayList<XmlClass>();

	public boolean  startSuite(List<TestCasesForm> list, String suiteid, String guid, Map<String, String> mapparams,String driverPath) {
		 TestNG testNG=new TestNG();
		 XmlSuite suite = new XmlSuite();
		try {
			TestNGListener testlistener = new TestNGListener();
			TestNGCustomReportListener testNGCustomReportListener = new TestNGCustomReportListener();
			suite.setName(guid);
			// suite.setParallel(XmlSuite.PARALLEL_NONE);
			XmlTest test = new XmlTest(suite);
			test.setName(guid);
			test.setPreserveOrder("true");
			resultSeleniumDao.updateStatus(guid, STATUS.INPROGRESS.toString());
			test.setParameters(mapparams);
			test.addParameter("userName", "PRASGSR");
			test.addParameter("password", "shyam123");
			test.addParameter("driverName", guid);
			test.addParameter("driverPath", driverPath);
			logger.info("*********** MAP  PARAMS **************** " + mapparams);

			list.stream().forEach(testCasesForm -> {
				List<XmlInclude> listLoginMethods = new ArrayList<XmlInclude>();
				listLoginMethods.add(new XmlInclude(testCasesForm.getPageActionName()));
				XmlClass login = new XmlClass(testCasesForm.getPageClassFullName().trim());
				login.setIncludedMethods(listLoginMethods);
				classes.add(login);

			});
			test.setXmlClasses(classes);			
			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			suites.add(suite);
			testNG.addListener(testNGCustomReportListener);
			testNG.addListener(testlistener);
			testNG.setOutputDirectory("D://Reports/guid");
			testNG.setXmlSuites(suites);
			logger.info("**********1" + testNG.getDefaultTestName());
             
			testNG.run();
			logger.info("***************************2");

		} catch (Exception exp) {
			Log.error(" TestNgServiceImpl  startSuite::  " + exp);
		}
		return false;
	}

	/*public boolean startSuite(TestSuites testSuite, String suiteid, String uid, Map<String, String> mapparams) {

		try {
			TestNGListener testlistener = new TestNGListener();
			TestNGCustomReportListener testNGCustomReportListener = new TestNGCustomReportListener();
			suite.setName(suiteid);
			XmlTest test = new XmlTest(suite);
			test.setName(uid);
			test.setPreserveOrder("true");			
			resultSeleniumDao.updateStatus(suiteid, uid, STATUS.INPROGRESS.toString());
			test.setParameters(mapparams);
			test.addParameter("userName", "PRASGSR");
			test.addParameter("password", "shyam123");
			logger.info("*********** MAP  PARAMS **************** " + mapparams);		

			LinkedList<TestSteps> tsteps = testSuite.getSteps();
			tsteps.stream().forEach(steps -> {

				List<XmlInclude> listLoginMethods = new ArrayList<XmlInclude>();
				steps.getTestStepsActions().stream().forEach(stepActions -> {
					listLoginMethods.add(new XmlInclude(stepActions.getActionName()));
					try {
						test.addParameter(stepActions.getActionName().toString(),
								stepActions.getNavigationdata().toString());
					} catch (Exception exp) {

						logger.error(" ERROR while adding params " + exp);
					}
					XmlClass login = new XmlClass(steps.getClassName());
					login.setIncludedMethods(listLoginMethods);
					classes.add(login);
				});
			});

			test.setXmlClasses(classes);

			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			suites.add(suite);

			testNG.addListener(testNGCustomReportListener);
			testNG.addListener(testlistener);
			testNG.setOutputDirectory("D://Reports/suiteid");
			testNG.setXmlSuites(suites);
			logger.info("***************************1" + testNG.getDefaultTestName());
			testNG.run();
			logger.info("***************************2");

		} catch (Exception exp) {
			Log.error(" TestNgServiceImpl  startSuite::  " + exp);
		}
		return false;
	}*/

}

