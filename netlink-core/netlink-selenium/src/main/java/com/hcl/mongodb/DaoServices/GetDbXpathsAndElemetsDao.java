package com.hcl.mongodb.DaoServices;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.mongodb.pageobjects.PageXpaths;
import com.hcl.selenium.cfg.DbTemplateCfg;
import com.hcl.selenium.interfaceImpl.SpringAnnotationAppConfigContextInterface;

public class GetDbXpathsAndElemetsDao {
	private static final Logger logger = LoggerFactory.getLogger(GetDbXpathsAndElemetsDao.class);
	static DbPageObjects currentPage = null;
	private static HashMap<String, String> pageClasses = new HashMap<String, String>();
	private static HashMap<String, String> pageElementsXPath = new HashMap<String, String>();
	
	

	public static String getXPath(String pageName, String element, String classwithpackage) {

		try {
			if (pageElementsXPath.containsKey(pageName + "." + element))
				return pageElementsXPath.get(pageName + "." + element);
			else {
				getXpathsFromDb(pageName, classwithpackage, "");
				return pageElementsXPath.get(pageName + "." + element);
			}
		} catch (Exception exp) {
			logger.error("Exception Occured " + exp);
		}

		return null;
	}

	public static void getXpathsFromDb(String pageName, String classwithpackage, String elementsname) {
		currentPage=null;
		if (currentPage == null) {
/*
			AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext();
			ca.register(DbTemplateCfg.class);
			ca.refresh();
			ApplicationContext ctx = ca;*/
			
			Class regclass=DbTemplateCfg.class;
			
			ApplicationContext ctx = SpringAnnotationAppConfigContextInterface.getAnnotationConfig(regclass);

			

			try {

				MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

				logger.info("GetDbXpathsAndElemetsDao :::" + mongoTemplate);
				/*
				 * "pageName" : "Login", "pageClass" : *
				 * "com.hcl.netlink.objects.Login",
				 */

				currentPage = mongoTemplate.findOne(query(
						where(new DbPageObjects().getPageName()).is(pageName).and("pageClass").is(classwithpackage)),
						DbPageObjects.class);
				pageClasses.clear();
				pageElementsXPath.clear();
				// List<DbPageObjects> pages = (ArrayList)
				// mongoTemplate.findAll(DbPageObjects.class, "PageObjects");
			} catch (Exception exp) {
				logger.error(".......................EXCEPTION .... " + exp);
			}
		}
		DbPageObjects pageObjects = currentPage;
		List<PageXpaths> pageXpaths;
		if (pageObjects != null) {
			pageXpaths = pageObjects.getPageXpaths();
			pageClasses.put(pageObjects.getPageName(), pageObjects.getPageClass());

			for (PageXpaths xpath : pageXpaths) {
				if (xpath != null && !xpath.equals("")) {
					pageElementsXPath.put(pageObjects.getPageName() + "." + xpath.getPageElement(),
							xpath.getPageElementXPath());
				}
			}
		}

	}

}
