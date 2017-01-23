package com.hcl.inpututility.pageobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.mongodb.pageobjects.PageActions;
import com.hcl.mongodb.pageobjects.PageXpaths;
import com.hcl.selenium.pageactionclass.AppCardsNavigation;

@Service("applicationsCardsNavigationInsertion")
public class ApplicationsCardsNavigationInsertion {
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

	public void appPageObjects() {
		
		dbPageObjects.setPageId("ApplicationCardsNavigationObject");
		dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.ApplicationCardsNavigationObject");
		dbPageObjects.setPageName("ApplicationCardsNavigation");
		dbPageObjects.setLastModifiedBy("g srihari");

		
		dbPageObjects.setLastModifiedDate( getDate());
		dbPageObjects.setCreatedBy("G SRIHARI");
		// page.setLastModifiedDate(new Date());
		//actions.setPageActionName("creatSite");
		//actions.setPageActionClassName("CreatSite");
		//actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.CreatSite");
		// ==== actions
		List<PageActions> listactions = new ArrayList();
		PageActions actions = new PageActions();
		actions.setPageActionClassName("ApplicationCardsNavigationObject");
		actions.setPageActionName("appCardsNavigation");
		actions.setPageActionClassName("AppCardsNavigation");
		actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.AppCardsNavigation");
		AppCardsNavigation base=new  AppCardsNavigation();
		base.setAppNavigation("Engineering");		
		actions.setInputDataPageActionClassInterface(base);
		listactions.add(actions);

		dbPageObjects.setPageActions(listactions);

		// ==== xpaths

		List<PageXpaths> listaPageXpaths = new ArrayList();
		PageXpaths xpaths = new PageXpaths();
		xpaths.setPageElement("xpathForAppNavigation");
		xpaths.setPageElementXPath("/html/body/div[1]/div[3]/div/button[11]");
		listaPageXpaths.add(xpaths);
		dbPageObjects.setPageXpaths(listaPageXpaths);
		add(dbPageObjects);
	}
}
