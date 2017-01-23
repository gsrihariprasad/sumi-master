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
import com.hcl.selenium.pageactionclass.CreatSite;

@Service("siteObjectInsertion")
public class SiteObjectInsertion {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	DbPageObjects dbPageObjects;
	public SiteObjectInsertion(){
		
	}
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
		public void siteObjectss(){
			
			dbPageObjects.setPageId("2");
			dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.SiteObject");
			dbPageObjects.setPageName("SiteObject");
			dbPageObjects.setLastModifiedBy("g srihari");
			
			Clock clock = Clock.system(ZoneId.systemDefault());
			Instant timestamp = clock.instant();
			dbPageObjects.setLastModifiedDate(getDate());
			dbPageObjects.setCreatedBy("G SRIHARI");
			//====  actions
			List<PageActions> listactions=new ArrayList();
			PageActions actions=new PageActions();
			actions.setPageActionName("creatSite");
			actions.setPageActionClassName("CreatSite");
			actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.CreatSite");
			CreatSite base=new  CreatSite();
			base.setCreateSite_SiteId("ZYZ");
			base.setCreateSite_SiteDesc(" Description from mongo  ");
			actions.setInputDataPageActionClassInterface(base);
			listactions.add(actions);
			
			dbPageObjects.setPageActions(listactions);			
			
			List<PageXpaths> listaPageXpaths=new ArrayList();
			PageXpaths xpaths=new PageXpaths();
			xpaths.setPageElement("xpathForCreateButton");
			xpaths.setPageElementXPath( "/html/body/div[1]/div[3]/div/button[11]");
			listaPageXpaths.add(xpaths);
			
			PageXpaths xpaths1=new PageXpaths();
			xpaths1.setPageElement("xPathForSiteName");
			xpaths1.setPageElementXPath( "/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input");
			
			listaPageXpaths.add(xpaths1);
			
			
			PageXpaths xpaths2=new PageXpaths();
			xpaths2.setPageElement("xPathForSiteDesc");
			xpaths2.setPageElementXPath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input");
			
			listaPageXpaths.add(xpaths2);
			
			

			PageXpaths xpaths3=new PageXpaths();
			xpaths3.setPageElement("xPathForsiteSub");
			xpaths3.setPageElementXPath("/html/body/div[5]/div[3]/button[1]");
			
			listaPageXpaths.add(xpaths3);
			
			dbPageObjects.setPageXpaths(listaPageXpaths);
			add(dbPageObjects);
			
		}
		
	
}
