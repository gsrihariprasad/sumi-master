package com.hcl.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.selenium.common.formpages.AvailableTestCases;
import com.hcl.services.PageObjectsServices;
import com.hcl.services.TestCaseSubmitalService;
@RestController
@ComponentScan("com.hcl")
public class Home {
	Logger logger = LoggerFactory.getLogger(Home.class);
	@Autowired
	DbPageObjects pageObjects;
	@Autowired
	PageObjectsServices pageObjectsServices;
	@Autowired
	TestCaseSubmitalService testCaseSubmitalService;
	
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	RoutingObjectInsertion routingObjectInsertion;
	@Autowired
	LogintInsertionUtility logintInsertionUtility;
	@Autowired
	ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;

	@RequestMapping("/")
	String index(Model model) {

		model.addAttribute("now", LocalDateTime.now());
		logger.info("   >>>>>>>>>>>  " );
		return "main";
	}
	/*@RequestMapping("/login")
	String login(Model model) {

		model.addAttribute("now", LocalDateTime.now());
		logger.info("   >>>>>>>>>>> LOGIN... " );
		return "Home";
	}*/

	/*@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap map) {

		List<AvailableTestCases> list = pageObjectsServices.getAll();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);

		logger.info(" HOME :::  jsonInString  ::  " + jsonInString);
		map.put("welcome", list);

		return "Home";

	}
*/

	@RequestMapping(value = "/draganddrop", method = RequestMethod.GET)
	public String draganddrop(ModelMap map) {

		
		return "DragDrop";

	}
	@RequestMapping(value = "/testForm", method = RequestMethod.GET)
	@ResponseBody
	public String testForm(ModelMap map) {

		List<AvailableTestCases> list = pageObjectsServices.getAll();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);

		logger.info("testcasesubmit ::  " + jsonInString);
		map.put("welcome", list);

		return jsonInString;

	}

	/*@RequestMapping(value = "/testcasesubmitreq", method = RequestMethod.GET)
	public String testcasesubmitreq(ModelMap map) {

		List<AvailableTestCases> list = pageObjectsServices.getAll();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);

		logger.info("testcasesubmit ::  " + jsonInString);
		map.put("welcome", list);

		return "testcasesubmit";

	}*/

	
	@RequestMapping(value = "/testcasesubmit", method = RequestMethod.GET)
	public String london(ModelMap map) {

		List<AvailableTestCases> list = pageObjectsServices.getAll();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);

		logger.info("testcasesubmit ::  " + jsonInString);
		map.put("welcome", list);

		return "testcasesubmit";

	}

	@RequestMapping(value = "/testcasesubmitrequest1", method = RequestMethod.POST)
	@ResponseBody
	public String testCaseSubmitRequest11111(@RequestBody AvailableTestCases testCaseSubmital, BindingResult result,
			SessionStatus status) throws JsonProcessingException {

		logger.info("HOME  testCaseSubmitRequest11111" + testCaseSubmital);
		ObjectMapper mapper = new ObjectMapper();
		String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testCaseSubmital);

		logger.info("LLLLLLLLLLLLL " + prettyStaff1);

		return "OK Success";

	}

	@RequestMapping(value = "/testcasesubmitrequest", method = RequestMethod.POST)
	@ResponseBody
	public String testCaseSubmitRequest(@RequestBody String testCasesFormSubmit, BindingResult result,
			SessionStatus status) throws JsonProcessingException, ClassNotFoundException, InstantiationException,
			IllegalAccessException { /* JsonObject */
		/* TestCasesFormSubmit */
		logger.info("testCasesFormSubmit .. JSON String " + testCasesFormSubmit);
		JSONObject json = new JSONObject(testCasesFormSubmit);
		testCaseSubmitalService.getSaveExecuteSubmitalTestCases(json);
		return "OK Succ";

	}

	@RequestMapping(value = "/pageobjects", method = RequestMethod.GET)
	public String pageobjects(ModelMap map) {

		// map.put("welcome", getPossible());

		return "PageObjects";

	}

	@RequestMapping(value = "/savepageobjects", method = RequestMethod.POST)
	@ResponseBody
	public String submitPageObjects(@RequestBody DbPageObjects testForm1, BindingResult result, SessionStatus status)
			throws JsonProcessingException {

		logger.info(">>>  " + testForm1);
		return "ssssss";
	}

	/*
	 * public void getSave() {
	 * 
	 * List<TestCaseSubmital> list = new ArrayList<TestCaseSubmital>();
	 * 
	 * List<Object> lisinput = new ArrayList<Object>();
	 * 
	 * TestCaseSubmital objects1 = new TestCaseSubmital();
	 * 
	 * objects1.setPageName("SiteObject"); CreatSite sitecreate = new
	 * CreatSite(); sitecreate.setSiteid("ytt");
	 * sitecreate.setSiteDesc("Site Desc"); lisinput.add(sitecreate);
	 * objects1.setPageInputs(lisinput); list.add(objects1);
	 * 
	 * TestCaseSubmital objects2 = new TestCaseSubmital();
	 * objects2.setPageName("WareHouseObject"); WareHouseCreate warehousecreate
	 * = new WareHouseCreate(); warehousecreate.setSiteid("YTY");
	 * warehousecreate.setWareDesc("Warehouse DESc");
	 * warehousecreate.setWarehouseid("WWW"); lisinput.add(warehousecreate);
	 * objects2.setPageInputs(lisinput); list.add(objects2);
	 * 
	 * TestCaseSubmital objects3 = new TestCaseSubmital();
	 * objects3.setPageName("RoutingObject"); RoutingCreate routingcreate = new
	 * RoutingCreate();
	 * 
	 * routingcreate.setRouteDesc("routing Desc");
	 * routingcreate.setRouteid("POI"); lisinput.add(routingcreate);
	 * objects3.setPageInputs(lisinput); list.add(objects3);
	 * 
	 * // testCaseSerivceImpl.addTestCaseSerivceImpl(list);
	 * 
	 * }
	 */

	public List<AvailableTestCases> getPossible1() {

		List<AvailableTestCases> list = new ArrayList<AvailableTestCases>();

		return list;
	}

	/*
	 * public List<TestCaseSubmital> getPossible() {
	 * 
	 * List<TestCaseSubmital> list = new ArrayList<TestCaseSubmital>();
	 * 
	 * String str[] = { "SiteObject", "WareHouseObject", "RoutingObject" };
	 * 
	 * for (String names : str) {
	 * 
	 * List<Object> lisinput = new ArrayList<Object>();
	 * 
	 * switch (names) {
	 * 
	 * case "SiteObject": TestCaseSubmital objects1 = new TestCaseSubmital();
	 * 
	 * objects1.setPageName(names); CreatSite sitecreate = new CreatSite();
	 * sitecreate.setSiteid("ytt"); sitecreate.setSiteDesc("Site Desc");
	 * lisinput.add(sitecreate); objects1.setPageInputs(lisinput);
	 * list.add(objects1); break; case "WareHouseObject": TestCaseSubmital
	 * objects2 = new TestCaseSubmital(); objects2.setPageName(names);
	 * WareHouseCreate warehousecreate = new WareHouseCreate();
	 * warehousecreate.setSiteid("YTY");
	 * warehousecreate.setWareDesc("Warehouse DESc");
	 * warehousecreate.setWarehouseid("WWW"); lisinput.add(warehousecreate);
	 * objects2.setPageInputs(lisinput); list.add(objects2); break; case
	 * "RoutingObject": TestCaseSubmital objects3 = new TestCaseSubmital();
	 * objects3.setPageName(names); RoutingCreate routingcreate = new
	 * RoutingCreate();
	 * 
	 * routingcreate.setRouteDesc("routing Desc");
	 * routingcreate.setRouteid("POI"); lisinput.add(routingcreate);
	 * objects3.setPageInputs(lisinput); list.add(objects3); break; } } return
	 * list;
	 * 
	 * }
	 */
	public void waste() {

		String ss = "{\"[{\"groupName\":\"MY HOOOME\",\"id\":null,\"pageActionClassFullName\":\"com.hcl.selenium.pageactionclass.CreatSite\",\"pageActionClassName\":null,\"pageActionName\":\"creatSite\",\"pageInputs\":{\"siteDesc\":\" Description from mongo  \",\"siteid\":\"ZYZ\"},\"pageName\":\"creatSite\"},{\"groupName\":\"MY HOOOME\",\"id\":null,\"pageActionClassFullName\":\"com.hcl.selenium.pageactionclass.CreateRouting\",\"pageActionClassName\":null,\"pageActionName\":\"createRouting\",\"pageInputs\":{\"routingDescription\":\"yesSuccess\",\"routingIdentifier\":\"EXP11\",\"routingName\":\"Y9X\",\"routingVersion\":\"9\"},\"pageName\":\"createRouting\"}]\"}";
	}

	/*
	 * @RequestMapping(value = "/test", method = RequestMethod.GET) public
	 * String testxyzy(ModelMap map) { map.put("welcome", getPossible()); return
	 * "dindex"; }
	 * 
	 * @RequestMapping(value = "/xyz", method = RequestMethod.GET) public String
	 * xyzy(ModelMap map) {
	 * 
	 * map.put("welcome", getPossible()); return "demo3"; }
	 * 
	 * @RequestMapping(value = "/xdemo5", method = RequestMethod.GET) public
	 * String xdemo5(ModelMap map) {
	 * 
	 * map.put("welcome", getPossible());
	 * 
	 * return "demo5";
	 * 
	 * }
	 */
}
