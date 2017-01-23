package com.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.ItemRevisionsObjectInsertion;
import com.hcl.inpututility.pageobject.LoginObjectInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.ObjectNavinagationObjectInsertion;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.inpututility.pageobject.TabbedCardsNavigationObjectInsertion;

//@SpringBootApplication(scanBasePackages={"com"})
//@EnableAutoConfiguration
//@EnableScheduling
@Service
public class Application {
	 private static final Logger log = LoggerFactory.getLogger(Application.class);
   
   @Autowired
	MongoTemplate mongoTemplate;
    @Autowired
    SiteObjectInsertion siteObjectInsertion;
    @Autowired
    LogintInsertionUtility logintInsertionUtility;

    
    @Autowired
    ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
    @Autowired
    LoginObjectInsertion loginObjectInsertion;
    @Autowired
    TabbedCardsNavigationObjectInsertion tabbedCardsNavigationObjectInsertion;
    
    @Autowired
    ObjectNavinagationObjectInsertion objectNavinagationObjectInsertion;
    @Autowired
    RoutingObjectInsertion routingObjectInsertion;
    @Autowired
    ItemRevisionsObjectInsertion itemRevisionsObjectInsertion;
	public void runstart() throws Exception {
		itemRevisionsObjectInsertion.itemRevisionsObjectInsertion();
		/*applicationsCardsNavigationInsertion.appPageObjects();
		loginObjectInsertion.loginObjectInsertion();
		objectNavinagationObjectInsertion.objPageObjects();
		tabbedCardsNavigationObjectInsertion.tabbedPageObjects();
		siteObjectInsertion.siteObjectss();*/
		//routingObjectInsertion.routingObject();
		//siteCreateSuite.setTestSuite();
	}
}
