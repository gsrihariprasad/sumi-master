package com.hcl.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.mongodb.pageobjects.PageActions;
import com.hcl.selenium.common.formpages.AvailableTestCases;

@Service("pageObjectsServices")
public class PageObjectsServices {
	private static final Logger logger = LoggerFactory.getLogger(PageObjectsServices.class);
	@Autowired
	MongoTemplate mongoTemplate;
	List<PageActions> dbActions = null;

	/*
	 * public static void iteratejson(String jsonInString, Gson gson){
	 * System.out.println(jsonInString); JsonParser jsonParser = new
	 * JsonParser(); JsonElement element = jsonParser.parse(jsonInString);
	 * 
	 * 
	 * Map<String, Object> map = gson.fromJson(jsonInString, new
	 * TypeToken<Map<String, Object>>(){}.getType()); map.forEach((x,y)->
	 * System.out.println("key : " + x + " , value : " + y)); }
	 */

	public List<AvailableTestCases> getAll() {

		
		List<DbPageObjects> dbPages = mongoTemplate.findAll(DbPageObjects.class);

		Gson gson = new Gson();
		String jsonInString = gson.toJson(dbPages);

		List<AvailableTestCases> list = new ArrayList<AvailableTestCases>();
		
		dbPages.stream().forEach(dpages->{
			
			dpages.getPageActions().stream().forEach(paction->{
				
				AvailableTestCases availableTestCases=new AvailableTestCases();
				availableTestCases.setPageClassFullName(dpages.getPageClass());
				if (paction.getInputDataPageActionClassInterface() != null) {
					//availableTestCases.setPageActionClassFullName(paction.getPageActionClassFullName());
					availableTestCases.setPageName(paction.getPageActionName());
					availableTestCases.setPageActionName(paction.getPageActionName());
					availableTestCases.setPageInputs(paction.getInputDataPageActionClassInterface());					
					list.add(availableTestCases);
				}
			});
		});
		
		/*for (DbPageObjects d : dbPages) {
			List<PageActions> pageActions = d.getPageActions();
			for (PageActions pageaction : pageActions) {			
				AvailableTestCases availableTestCases=new AvailableTestCases();
				if (pageaction.getInputDataPageActionClassInterface() != null) {
					availableTestCases.setPageActionClassFullName(pageaction.getPageActionClassFullName());
					availableTestCases.setPageName(pageaction.getPageActionName());
					availableTestCases.setPageActionName(pageaction.getPageActionName());
					availableTestCases.setPageInputs(pageaction.getInputDataPageActionClassInterface());					
					list.add(availableTestCases);
				}
				
			}
		}*/

		return list;
	}

}
