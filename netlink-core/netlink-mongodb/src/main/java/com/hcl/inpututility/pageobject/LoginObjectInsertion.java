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
import com.hcl.selenium.pageactionclass.LoginInputs;

@Service("loginObjectInsertion")
public class LoginObjectInsertion {

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

	public void loginObjectInsertion() {
		
		dbPageObjects.setPageId("LoginObject");
		dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.LoginObject");
		dbPageObjects.setPageName("LoginObject");
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
		actions.setPageActionClassName("LoginInputs");
		actions.setPageActionName("loginInputs");
		actions.setPageActionClassName("LoginInputs");
		actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.LoginInputs");
		LoginInputs base=new  LoginInputs();
		base.setUserName("gprasad1");
		base.setPassword("shshs");
		actions.setInputDataPageActionClassInterface(base);
		listactions.add(actions);

		dbPageObjects.setPageActions(listactions);

		// ==== xpaths

		List<PageXpaths> listaPageXpaths=new ArrayList();
		PageXpaths xpaths=new PageXpaths();
		xpaths.setPageElement("username");
		xpaths.setPageElementXPath("//*[@id=\"user\"]");
		listaPageXpaths.add(xpaths);
		
		PageXpaths xpaths1=new PageXpaths();
		xpaths1.setPageElement("password");
		xpaths1.setPageElementXPath("//*[@id=\"password\"]");
		listaPageXpaths.add(xpaths1);
		
		PageXpaths xpaths2=new PageXpaths();
		xpaths2.setPageElement("signIn");
		xpaths2.setPageElementXPath("//*[@id=\"frmLoginData\"]/div/div[2]/button");
		listaPageXpaths.add(xpaths2);
		
		dbPageObjects.setPageXpaths(listaPageXpaths);
		add(dbPageObjects);
	}}