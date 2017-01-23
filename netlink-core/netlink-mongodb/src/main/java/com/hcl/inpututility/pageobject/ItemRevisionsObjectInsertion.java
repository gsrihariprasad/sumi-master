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
import com.hcl.selenium.pageactionclass.CreateItemRevision;
import com.hcl.xpathApi.ENGINEERING_API;

@Service("itemRevisionsObjectInsertion")
public class ItemRevisionsObjectInsertion {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	DbPageObjects dbPageObjects;

	public void add(DbPageObjects page) {

		mongoTemplate.insert(page);

	}

	public static Date getDate() {
		try {
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
			return ft.parse(ft.format(dNow));
		} catch (Exception eee) {

		}
		return null;
	}

	public void itemRevisionsObjectInsertion() {

		dbPageObjects.setPageId("4");
		dbPageObjects.setPageClass("com.hcl.selenium.pageobjects.ItemRevisionsObject");
		dbPageObjects.setPageName("ItemRevisionsObject");
		dbPageObjects.setLastModifiedBy("g srihari");

		Clock clock = Clock.system(ZoneId.systemDefault());
		Instant timestamp = clock.instant();
		dbPageObjects.setLastModifiedDate(getDate());
		dbPageObjects.setCreatedBy("G SRIHARI");
		// ==== actions
		List<PageActions> listactions = new ArrayList();
		PageActions actions = new PageActions();
		actions.setPageActionName("createItemRevision");
		actions.setPageActionClassName("CreateItemRevision");
		actions.setPageActionClassFullName("com.hcl.selenium.pageactionclass.CreateItemRevision");
		CreateItemRevision base = new CreateItemRevision();
		base.setCreateItemRevision_ItemName("YYZ");
		base.setCreateItemRevision_SitName("YYZ");
		base.setCreateItemRevision_ItemDescrption("ItemRevsions Description");
		actions.setInputDataPageActionClassInterface(base);
		listactions.add(actions);

		dbPageObjects.setPageActions(listactions);

/*ItemRevisionsObject	create		/html/body/div[1]/div[3]/div/button[11]
ItemRevisionsObject	enterSiteName		/html/body/div[6]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input
ItemRevisionsObject	enterItemName		/html/body/div[6]/div[2]/div[2]/div[4]/div/div/table/tbody/tr/td/input
ItemRevisionsObject	enterItemRevisionName		/html/body/div[6]/div[2]/div[2]/div[5]/div/div/table/tbody/tr/td[1]/input
ItemRevisionsObject	enterItemDescription		/html/body/div[6]/div[2]/div[2]/div[6]/div/input
*/
		List<PageXpaths> listaPageXpaths = new ArrayList();
		PageXpaths xpaths = new PageXpaths();
		xpaths.setPageElement(ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_SITENAME.toString());
		xpaths.setPageElementXPath("/html/body/div[6]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input");
		listaPageXpaths.add(xpaths);

		PageXpaths xpaths1 = new PageXpaths();
		xpaths1.setPageElement(ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMNAME.toString());
		xpaths1.setPageElementXPath("/html/body/div[6]/div[2]/div[2]/div[4]/div/div/table/tbody/tr/td/input");

		listaPageXpaths.add(xpaths1);

		PageXpaths xpaths2 = new PageXpaths();
		xpaths2.setPageElement(ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMREVISIONNAME.toString());
		xpaths2.setPageElementXPath("/html/body/div[6]/div[2]/div[2]/div[5]/div/div/table/tbody/tr/td[1]/input");

		listaPageXpaths.add(xpaths2);

		
		PageXpaths xpaths3 = new PageXpaths();
		xpaths3.setPageElement(ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_ITEMDESC.toString());
		xpaths3.setPageElementXPath("/html/body/div[6]/div[2]/div[2]/div[6]/div/input");

		listaPageXpaths.add(xpaths3);
		
		PageXpaths xpaths4 = new PageXpaths();
		xpaths4.setPageElement(ENGINEERING_API.XPATH_FOR_CREATEITEM_REVISION_BUTTON.toString());
		xpaths4.setPageElementXPath("/html/body/div[1]/div[3]/div/button[11]");

		listaPageXpaths.add(xpaths4);

		dbPageObjects.setPageXpaths(listaPageXpaths);
		add(dbPageObjects);

	}

}
