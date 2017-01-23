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

@Service
public class LogintInsertionUtility {
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
		
		public void loginPageObjects(){
			
			dbPageObjects.setPageId("3");
			dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.Login");
			dbPageObjects.setPageName("Login");
			dbPageObjects.setLastModifiedBy("g srihari");
			Clock clock = Clock.system(ZoneId.of("UTC+05:30"));
			Instant timestamp = clock.instant();
			dbPageObjects.setLastModifiedDate(getDate());
			dbPageObjects.setCreatedBy("G SRIHARI");
			List<PageActions> listactions=new ArrayList();
			PageActions actions=new PageActions();
			actions.setPageActionClassName("Login");
			actions.setPageActionName("login");
			listactions.add(actions);
			dbPageObjects.setPageActions(listactions);
			
			
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
		}
}
