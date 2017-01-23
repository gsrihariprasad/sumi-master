package com.hcl.controllers;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.hcl.mongodb.dao.EnvironmentInterface;
import com.hcl.selenium.common.formpages.AvailableTestCases;
import com.hcl.selenium.common.formpages.SeleniumEnvironment;
import com.hcl.services.EnvironmentService;
import com.hcl.services.PageObjectsServices;
import com.hcl.services.TestCaseSubmitalService;
@RestController
public class SuiteController {
	Logger logger = LoggerFactory.getLogger(SuiteController.class);
	
	@Autowired
	PageObjectsServices pageObjectsServices;
	@Autowired
	TestCaseSubmitalService testCaseSubmitalService;
	@Autowired
	EnvironmentInterface environmentInterface;
	
	@RequestMapping(value = "/testcasesubmitreq", method = RequestMethod.POST)
	@ResponseBody
	public LinkedList<AvailableTestCases> testcasesubmitreq(@RequestBody String testCasesFormSubmit, BindingResult result,
			SessionStatus status,ModelMap map) throws JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException { /* JsonObject */
		/* TestCasesFormSubmit */
		logger.info(" SuiteController testcasesubmitreq .. JSON String " + testCasesFormSubmit);
		//JSONObject json = new JSONObject(testCasesFormSubmit);
		
		  Gson googleJson = new Gson();
          LinkedList<AvailableTestCases> jsonObjList = googleJson.fromJson(testCasesFormSubmit, LinkedList.class);
        
		return jsonObjList;

	}
	

	@RequestMapping(value = "/suiteformsubit", method = RequestMethod.POST)
	@ResponseBody
	public String suiteformsubit(@RequestBody String testCasesFormSubmit, BindingResult result,
			SessionStatus status) throws JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		logger.info(" SuiteController testCasesFormSubmit .. JSON String " + testCasesFormSubmit);
		JSONObject json = new JSONObject(testCasesFormSubmit);
		testCaseSubmitalService.getSaveExecuteSubmitalTestCases(json);
		return "OK Succ";

	}
	
	@RequestMapping(value = "/getEnvironment", method = RequestMethod.GET)
	@ResponseBody
	public List<SeleniumEnvironment> getEnvironment() throws JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		logger.info(" SuiteController testCasesFormSubmit .. JSON String ");
			
		return environmentInterface.getEnvironment();

	}
}
