package com.hcl.testng.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.EnterpriseObjectInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;

@Service("gatewayService")
public class GatewayService {

	@Autowired
	StartTestNgService startTestNgService;
	@Autowired
	RoutingObjectInsertion routingObjectInsertion;
	
	@Autowired
	LogintInsertionUtility logintInsertionUtility;
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
	@Autowired
	EnterpriseObjectInsertion enterpriseObjectInsertion;
	public void startTestSuiteExecution() throws InterruptedException{
		
		// TODO Auto-generated method stub
		
		/* logintInsertionUtility.loginPageObjects();
		 siteObjectInsertion.siteObjectss();
		 applicationsCardsNavigationInsertion.appPageObjects();
		
		 routingObjectInsertion.routingObject();
		siteCreateSuite.setTestSuite();*/
	//	enterpriseObjectInsertion.enterpriseObjectInsertion();
		startTestNgService.getSubmitalTestCases();
		//startTestNgService.getTestCases();
		
	}
}
