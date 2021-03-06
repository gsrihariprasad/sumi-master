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
import com.hcl.selenium.pageactionclass.ObjNavinagation;

@Service("objectNavinagationObjectInsertion")
public class ObjectNavinagationObjectInsertion {

	@Autowired
	DbPageObjects dbPageObjects;
	@Autowired
	MongoTemplate mongoTemplate;

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
	public void objPageObjects() {
		dbPageObjects.setPageId("ObjectNavinagationObject");
		dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.ObjectNavinagationObject");
		dbPageObjects.setPageName("ObjectNavinagationObject");
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
		actions.setPageActionClassName("ObjNavinagation");
		actions.setPageActionName("objNavinagation");
		actions.setPageActionClassName("ObjNavinagation");
		actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.ObjNavinagation");
		ObjNavinagation base=new  ObjNavinagation();
		base.setObjNavigation("Sites");		
		actions.setInputDataPageActionClassInterface(base);
		listactions.add(actions);

		dbPageObjects.setPageActions(listactions);

		// ==== xpaths

		List<PageXpaths> listaPageXpaths = new ArrayList();
		PageXpaths xpaths = new PageXpaths();
		xpaths.setPageElement("xpathForObjNavigation");
		xpaths.setPageElementXPath("/html/body/div[1]/div[3]/div/button[11]");
		listaPageXpaths.add(xpaths);
		dbPageObjects.setPageXpaths(listaPageXpaths);
		add(dbPageObjects);
	
	}
}
