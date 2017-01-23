package com.hcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;


@RestController
public class InputUtilityController {
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	LogintInsertionUtility logintInsertionUtility;
	@Autowired
	RoutingObjectInsertion routingObjectInsertion;
	@Autowired
	ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
	
	@RequestMapping(value = "/logininsert", method = RequestMethod.GET)
	public String paris(ModelMap map) {

		//siteObjectInsertion.SiteObject();
		logintInsertionUtility.loginPageObjects();
		return "paris";

	}
	@RequestMapping(value = "/sitecreateinsert", method = RequestMethod.GET)
	public String site(ModelMap map) {

		siteObjectInsertion.siteObjectss();
		//logintInsertionUtility.loginPageObjects();
		return "paris";

	}
	
	@RequestMapping(value = "/appinsert", method = RequestMethod.GET)
	public String app(ModelMap map) {

		applicationsCardsNavigationInsertion.appPageObjects();
		return "paris";

	}
	@RequestMapping(value = "/routinginsert", method = RequestMethod.GET)
	public String routinginsert(ModelMap map) {

		routingObjectInsertion.routingObject();
		return "paris";

	}
}
