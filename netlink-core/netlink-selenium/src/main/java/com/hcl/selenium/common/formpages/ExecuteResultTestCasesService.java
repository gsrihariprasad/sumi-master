package com.hcl.selenium.common.formpages;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hcl.selenium.cfg.DbTemplateCfg;

public class ExecuteResultTestCasesService {
	/*public void get() {
		
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext();
		//ca.register(Exxx.class);
		ca.register(DbTemplateCfg.class);
		ca.refresh();
		ApplicationContext ctx = ca;

		try {

			MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
			System.out.println("lllllllllll :::" + mongoTemplate);
			
			 * "pageName" : "Login", "pageClass" : *
			 * "com.hcl.netlink.objects.Login",
			 

			
			 * currentPage = mongoTemplate.findOne(query( where(new
			 * DbPageObjects().getPageName()).is(pageName).and("pageClass").is(
			 * classwithpackage)), DbPageObjects.class);
			 
		} catch (Exception exp) {

		}
	}*/
}