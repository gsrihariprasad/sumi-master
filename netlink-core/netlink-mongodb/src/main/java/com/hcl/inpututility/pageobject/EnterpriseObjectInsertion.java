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
import com.hcl.selenium.pageactionclass.CreateEnterpriseItems;
import com.hcl.xpathApi.ENGINEERING_API;

@Service("enterpriseObjectInsertion")
public class EnterpriseObjectInsertion {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	DbPageObjects dbPageObjects;
	public EnterpriseObjectInsertion(){
		
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
		public void enterpriseObjectInsertion(){
			
			dbPageObjects.setPageId("3");
			dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.EnterpriseItemsObject");
			dbPageObjects.setPageName("EnterpriseItemsObject");
			dbPageObjects.setLastModifiedBy("g srihari");
			
			Clock clock = Clock.system(ZoneId.systemDefault());
			Instant timestamp = clock.instant();
			dbPageObjects.setLastModifiedDate(getDate());
			dbPageObjects.setCreatedBy("G SRIHARI");
			//====  actions
			List<PageActions> listactions=new ArrayList();
			PageActions actions=new PageActions();
			actions.setPageActionName("createEnterpriseItems");
			actions.setPageActionClassName("CreateEnterpriseItems");
			actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.CreateEnterpriseItems");
			CreateEnterpriseItems base=new  CreateEnterpriseItems();
			base.setCreateEnterpriseItems_itemName("YY3");
			base.setCreateEnterpriseItems_itemDescription("EnterpriseItem Description");
			actions.setInputDataPageActionClassInterface(base);
			listactions.add(actions);
			
			dbPageObjects.setPageActions(listactions);			
			
			List<PageXpaths> listaPageXpaths=new ArrayList();
			PageXpaths xpaths=new PageXpaths();
			xpaths.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ITEM_NAME.toString());
			xpaths.setPageElementXPath( "/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td/input");
			listaPageXpaths.add(xpaths);
			
			PageXpaths xpaths1=new PageXpaths();
			xpaths1.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ITEM_DESC.toString());
			xpaths1.setPageElementXPath( "/html/body/div[5]/div[2]/div[2]/div[4]/div/input");
			
			listaPageXpaths.add(xpaths1);
			
			
			PageXpaths xpaths2=new PageXpaths();
			xpaths2.setPageElement(ENGINEERING_API.XPATH_FOR_CREATE_ITEM_BUTTON_CLICK.toString());
			xpaths2.setPageElementXPath("/html/body/div[1]/div[3]/div/button[11]");
			
			listaPageXpaths.add(xpaths2);
			
			

			/*PageXpaths xpaths3=new PageXpaths();
			xpaths3.setPageElement("xPathForsiteSub");
			xpaths3.setPageElementXPath("/html/body/div[5]/div[3]/button[1]");
			
			listaPageXpaths.add(xpaths3);*/
			
			dbPageObjects.setPageXpaths(listaPageXpaths);
			add(dbPageObjects);
			
		}
		
	
}
