package com.hcl.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.hcl.selenium.common.formpages.AvailableTestCases;
import com.hcl.services.PageObjectsServices;

@RestController
public class SeleniumController {

	Logger logger = LoggerFactory.getLogger(SeleniumController.class);
	@Autowired
	PageObjectsServices pageObjectsServices;
	@RequestMapping(value = "/gettestcases", method = RequestMethod.GET)
	@ResponseBody
	public String gettestcases1(ModelMap map) throws JsonProcessingException {
		List<AvailableTestCases> list=pageObjectsServices.getAll();
		Gson gson=new Gson();
		 String jsonInString = gson.toJson(list);
		 
		 logger.info(" SeleniumController :::  jsonInString  ::  "+jsonInString);
		map.put("welcome", list);
		return "showtestcases";

	}

	
	@RequestMapping(value = "/testcasesubmit1", method = RequestMethod.GET)
	public String london11(ModelMap map) {

		map.put("welcome", getPossible());

		return "testcasesubmit";

	}

	public List<AvailableTestCases> getPossible() {

		List<AvailableTestCases> list = new ArrayList<AvailableTestCases>();

		/*
		 * String str[] = { "SiteObject", "WareHouseObject", "RoutingObject" };
		 * 
		 * for (String names : str) {
		 * 
		 * List<Object> lisinput = new ArrayList<Object>();
		 * 
		 * switch (names) {
		 * 
		 * case "SiteObject": TestCaseSubmital objects1 = new
		 * TestCaseSubmital();
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
		 * objects3.setPageInputs(lisinput); list.add(objects3); break; } }
		 */
		return list;

	}

}
