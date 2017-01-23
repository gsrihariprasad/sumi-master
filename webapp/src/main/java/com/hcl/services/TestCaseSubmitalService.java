package com.hcl.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.dao.TestCaseSubmitalDao;
import com.hcl.selenium.common.formpages.TestCasesForm;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;
import com.hcl.utility.STATUS;

@Service("testCaseSubmitalService")
public class TestCaseSubmitalService {

	private static Logger logger = LoggerFactory.getLogger(TestCaseSubmitalService.class);
	@Autowired
	private TestCaseSubmitalDao testCaseSubmitalDao;

	/*
	 * @Autowired private TestCasesFormSubmit testCasesFormSubmit;
	 */

	public boolean getSaveExecuteSubmitalTestCases(JSONObject json)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		logger.info("jons ::::::::::::: :: " + json);

		List<TestCasesForm> testCasesFormlist = new ArrayList<TestCasesForm>();
		JSONArray jSONArray = json.getJSONArray("testcasesbindings");
		TestCasesFormSubmit testCasesFormSubmit = new TestCasesFormSubmit();

		testCasesFormSubmit.setGroupName(json.getString("groupName"));
		testCasesFormSubmit.setTimeToExecute(Instant.parse((String) json.get("executedaytime")));
         logger.info("  driver  NAME :"+json.getString("driverPath"));
         testCasesFormSubmit.setDriverPath(json.getString("driverPath"));
		logger.info(jSONArray.toString());
		// ex.oper(ex::add, 1, 2);

		for (int i = 0; i <= jSONArray.length() - 1; i++) {
			try {
				JSONObject objects = jSONArray.optJSONObject(i);
				TestCasesForm testCasesForm = getTestCases(objects);
				testCasesFormlist.add(testCasesForm);

			} catch (Exception exp) {
				logger.error("TestCaseSubmitalService  :: " + exp);
			}
		}
		testCasesFormSubmit.setTestCasesFormlist(testCasesFormlist);
		testCasesFormSubmit.setStatus(STATUS.READY.toString());
		testCaseSubmitalDao.saveSubmitalTestCases(testCasesFormSubmit);

		return true;
	}

	public static TestCasesForm getTestCases(JSONObject objects)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		TestCasesForm testCasesForm = new TestCasesForm();

		try {
			testCasesForm.setPageActionClassFullName(objects.getString("pageActionClassFullName"));
			// testCasesForm.setPageActionClassName(objects.getString("pageActionClassName"));
			testCasesForm.setPageActionName(objects.getString("pageActionName"));
			// testCasesForm.setPageName(objects.getString("pageName"));
			testCasesForm.setPageInputs(objects.get("pageInputs"));
			testCasesForm.setPageClassFullName(objects.getString("pageClassFullName"));

		} catch (Exception exp) {
			logger.error("ERROR TESTCASESubMit  " + exp);
		}
		return testCasesForm;
	}

	/*
	 * public void submitForm(JSONObject objects){ List<TestCasesForm>
	 * testCasesFormlist=new ArrayList();
	 * 
	 * TestCasesForm ttt=new TestCasesForm(); //JSONObject pageinputs =
	 * (JSONObject) objects.get("pageInputs"); String pageActionClassFullName =
	 * (String) objects.get(ttt.getPageActionClassFullName());
	 * 
	 * ttt.setPageActionClassFullName(pageActionClassFullName);
	 * //testCasesFormSubmit.setPageActionClassName(pageActionClassName);
	 * testCasesFormSubmit.setPageActionName(pageinputs.getString("pageName"));
	 * 
	 * Class<?> cclaass = Class.forName(pageActionClassFullName); Object
	 * objinstance = cclaass.newInstance(); logger.info(" TEST CASE CLASS :::  "
	 * + cclaass.getSimpleName()); InputDataPageActionClassInterface obj =
	 * (InputDataPageActionClassInterface) PageActionClassAPI
	 * .valueOf(cclaass.getSimpleName()).getObject(pageinputs, objinstance);
	 * testCasesFormSubmit.setPageInputs(obj); }
	 * 
	 * public void pageinputs(){
	 * 
	 * }
	 */
}
