package com.hcl.inpututility.pageobject;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.mongodb.pageobjects.PageActions;
import com.hcl.mongodb.pageobjects.PageXpaths;
import com.hcl.selenium.pageactionclass.ChangeRouting;
import com.hcl.selenium.pageactionclass.CreateRouting;
import com.hcl.selenium.pageactionclass.DeleteRouting;
import com.hcl.selenium.pageactionclass.RoutingQuickChange;
import com.hcl.xpathApi.ENGINEERING_API;

@Service("routingObjectInsertion")
public class RoutingObjectInsertion {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	DbPageObjects dbPageObjects;
	public void add(DbPageObjects page) {

		mongoTemplate.insert(page);

	}
	public static Date getDate()  {
		try{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return ft.parse(ft.format(dNow));
		}catch(Exception eee){
			
		}
		return null;
	}
	public void routingObject() {
		
		dbPageObjects.setPageId("1");
		dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.RoutingObject");
		dbPageObjects.setPageName("RoutingObject");
		dbPageObjects.setLastModifiedBy("g srihari");
		Clock clock = Clock.system(ZoneId.systemDefault());
		Instant timestamp = clock.instant();
		dbPageObjects.setLastModifiedDate(getDate());
		dbPageObjects.setCreatedBy("G SRIHARI");
		// ==== actions
		List<PageActions> listactions = new ArrayList();
		
		PageActions actions = new PageActions();
		actions.setPageActionName("createRouting");
		actions.setPageActionClassName("CreateRouting");
		actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.CreateRouting");
		
		CreateRouting base = new CreateRouting();
		base.setCreateRouting_RoutingName("Y9X");
		base.setCreateRouting_RoutingDescription("yesSuccess");
		base.setCreateRouting_RoutingIdentifier("EXP11");
		base.setCreateRouting_RoutingVersion("9");
		
		actions.setInputDataPageActionClassInterface(base);
		listactions.add(actions);
		
		
		PageActions actions1 = new PageActions();
		actions1.setPageActionName("routingQuickChange");
		actions1.setPageActionClassName("RoutingQuickChange");
		actions1.setPageActionClassFullName("com.hcl.selenium.pageactionclass.RoutingQuickChange");
		
		RoutingQuickChange base1 = new RoutingQuickChange();
		base1.setRoutingQuickChange_RoutingName("Y9X");
		base1.setRoutingQuickChange_RoutingDescription("yesSuccess");
		base1.setRoutingQuickChange_RoutingIdentifier("EXP11");
		base1.setRoutingQuickChange_RoutingVersion("9");
		actions1.setInputDataPageActionClassInterface(base1);
		listactions.add(actions1);
		
		
		PageActions actions2 = new PageActions();
		actions2.setPageActionName("deleteRouting");
		actions2.setPageActionClassName("DeleteRouting");
		actions2.setPageActionClassFullName("com.hcl.selenium.pageactionclass.DeleteRouting");
	
		DeleteRouting base2 = new DeleteRouting();
		base2.setDeleteRouting_RoutingName("Y9X");
		base2.setDeleteRouting_RoutingIdentifier("EXP11");
		base2.setDeleteRouting_RoutingVersion("9");
		actions2.setInputDataPageActionClassInterface(base2);
		listactions.add(actions2);
		
		
		PageActions actions3 = new PageActions();
		actions3.setPageActionName("changeRouting");
		actions3.setPageActionClassName("ChangeRouting");
		actions3.setPageActionClassFullName("com.hcl.selenium.pageactionclass.ChangeRouting");
	
		ChangeRouting base3 = new ChangeRouting();
		base3.setChangeRouting_RoutingName("Y9X");
		base3.setChangeRouting_RoutingIdentifier("EXP11");
		base3.setChangeRouting_RoutingVersion("9");
		base3.setChangeRouting_RoutingDescription("yesSuccess changed");
		actions3.setInputDataPageActionClassInterface(base3);
		listactions.add(actions3);
		
		
		dbPageObjects.setPageActions(listactions);

		// ==== xpaths
		/*
		1 XPATH_FOR_CREATE_ROUTING_NAME		/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input
		2 XPATH_FOR_CREATE_ROUTING_IDENTIFIER		/html/body/div[5]/div[2]/div[2]/div[4]/div/input
		3 XPATH_FOR_CREATE_ROUTING_VERSION		/html/body/div[5]/div[2]/div[2]/div[5]/div/div/table/tbody/tr/td[1]/input
		4 XPATH_FOR_CREATE_ROUTING_DESC		/html/body/div[5]/div[2]/div[2]/div[6]/div/input
		
	    5 create	XPATH_FOR_CREATE_ROUTING_BUTTON		/html/body/div[1]/div[3]/div/button[11]
		
		6 XPATH_FOR_CHANGE_ROUTING_BUTTON		/html/body/div[1]/div[3]/div/button[12]
		7 XPATH_FOR_DELETE_ROUTING_BUTTON		/html/body/div[1]/div[3]/div/button[14]
		8 XPATH_FOR_QUICKCHANGE_ROUTING_BUTTON		/html/body/div[1]/div[3]/div/button[13]
		
		9 XPATH_FOR_CHANGE_ROUTING_SITE_NAME		/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
		10 XPATH_FOR_CHANGE_ROUTING_IDENTIFIER		/html/body/div[4]/div[2]/div[2]/div[2]/div/input
		11 XPATH_FOR_CHANGE_ROUTING_VERSION		/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input
		12 XPATH_FOR_CHANGE_ROUTING_DESC		/html/body/div/div[4]/div/div/div[2]/div/div/div/div/div/input
		
		13 XPATH_FOR_DELETE_ROUTING_SITENAME		/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
		14 XPATH_FOR_DELETE_ROUTING_IDENTIFIER		/html/body/div[4]/div[2]/div[2]/div[2]/div/input
		15 XPATH_FOR_DELETE_ROUTING_VERSION		/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input
		
		16 XPATH_FOR_QUICKCHANGE_ROUTING_NAME		/html/body/div[5]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input
		17 XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER		/html/body/div[5]/div[2]/div[2]/div[2]/div/input
		18 XPATH_FOR_QUICKCHANGE_ROUTING_VERSION		/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input
	*/
		List<PageXpaths> listaPageXpaths = new ArrayList();
		PageXpaths xpaths1 = new PageXpaths();
		xpaths1.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_NAME.toString());
		xpaths1.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input");
		listaPageXpaths.add(xpaths1);

		PageXpaths xpaths2 = new PageXpaths();
		xpaths2.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_IDENTIFIER.toString());
		xpaths2.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input");

		listaPageXpaths.add(xpaths2);

		PageXpaths xpaths3 = new PageXpaths();
		xpaths3.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_VERSION.toString());
		xpaths3.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[5]/div/div/table/tbody/tr/td[1]/input");

		listaPageXpaths.add(xpaths3);

		PageXpaths xpaths4 = new PageXpaths();
		xpaths4.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_DESC.toString());
		xpaths4.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[6]/div/input");

		listaPageXpaths.add(xpaths4);

		PageXpaths xpaths5 = new PageXpaths();
		xpaths5.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ROUTING_BUTTON.toString());
		xpaths5.setPageElementXPath("/html/body/div[1]/div[3]/div/button[11]");

		listaPageXpaths.add(xpaths5);
		
		PageXpaths xpaths6 = new PageXpaths();
		xpaths6.setPageElement(ENGINEERING_API.XPATH_FOR_CHANGE_ROUTING_BUTTON.toString());
		xpaths6.setPageElementXPath("/html/body/div[1]/div[3]/div/button[12]");

		listaPageXpaths.add(xpaths6);
		
		PageXpaths xpaths7 = new PageXpaths();
		xpaths7.setPageElement(ENGINEERING_API.XPATH_FOR_DELETE_ROUTING_BUTTON.toString());
		xpaths7.setPageElementXPath("/html/body/div[1]/div[3]/div/button[14]");

		listaPageXpaths.add(xpaths7);
		
		PageXpaths xpaths8 = new PageXpaths();
		xpaths8.setPageElement(ENGINEERING_API.XPATH_FOR_QUICKCHANGE_ROUTING_BUTTON.toString());
		xpaths8.setPageElementXPath("/html/body/div[1]/div[3]/div/button[13]");

		listaPageXpaths.add(xpaths8);
		
		PageXpaths xpaths9 = new PageXpaths();
		xpaths9.setPageElement(ENGINEERING_API.XPATH_FOR_CHANGE_ROUTING_SITE_NAME.toString());
		xpaths9.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths9);
		
		PageXpaths xpaths10 = new PageXpaths();
		xpaths10.setPageElement(ENGINEERING_API.XPATH_FOR_CHANGE_ROUTING_IDENTIFIER.toString());
		xpaths10.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div[2]/div/input");

		listaPageXpaths.add(xpaths10);
		
		PageXpaths xpaths11 = new PageXpaths();
		xpaths11.setPageElement(ENGINEERING_API.XPATH_FOR_CHANGE_ROUTING_VERSION.toString());
		xpaths11.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths11);
		
		PageXpaths xpaths12 = new PageXpaths();
		xpaths12.setPageElement(ENGINEERING_API.XPATH_FOR_CHANGE_ROUTING_DESC.toString());
		xpaths12.setPageElementXPath("/html/body/div/div[4]/div/div/div[2]/div/div/div/div/div/input");

		listaPageXpaths.add(xpaths12);
		
		PageXpaths xpaths13 = new PageXpaths();
		xpaths13.setPageElement(ENGINEERING_API.XPATH_FOR_DELETE_ROUTING_SITENAME.toString());
		xpaths13.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths13);
		
		PageXpaths xpaths14 = new PageXpaths();
		xpaths14.setPageElement(ENGINEERING_API.XPATH_FOR_DELETE_ROUTING_IDENTIFIER.toString());
		xpaths14.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div[2]/div/input");

		listaPageXpaths.add(xpaths14);
		
		PageXpaths xpaths15 = new PageXpaths();
		xpaths15.setPageElement(ENGINEERING_API.XPATH_FOR_DELETE_ROUTING_VERSION.toString());
		xpaths15.setPageElementXPath("/html/body/div[4]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths15);
		
		PageXpaths xpaths16 = new PageXpaths();
		xpaths16.setPageElement(ENGINEERING_API.XPATH_FOR_QUICKCHANGE_ROUTING_NAME.toString());
		xpaths16.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths16);
		
		PageXpaths xpaths17 = new PageXpaths();
		xpaths17.setPageElement(ENGINEERING_API.XPATH_FOR_QUICKCHANGE_ROUTING_IDENTIFIER.toString());
		xpaths17.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input");

		listaPageXpaths.add(xpaths17);
		
		PageXpaths xpaths18 = new PageXpaths();
		xpaths18.setPageElement(ENGINEERING_API.XPATH_FOR_QUICKCHANGE_ROUTING_VERSION.toString());
		xpaths18.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths18);
		
		dbPageObjects.setPageXpaths(listaPageXpaths);
		add(dbPageObjects);

	}

}
