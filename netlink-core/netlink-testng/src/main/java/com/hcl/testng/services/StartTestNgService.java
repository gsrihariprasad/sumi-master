package com.hcl.testng.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.mongodb.dao.StartTestNgDao;
import com.hcl.selenium.common.formpages.ExecuteResultTestCasesService;
import com.hcl.selenium.common.formpages.TestCasesForm;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;

@Service("startTestNgService")
public class StartTestNgService {

	private static final Logger log = LoggerFactory.getLogger(StartTestNgService.class);
	@Autowired
	private TestNgServiceImpl testNgService;
	@Autowired
	private ExecuteResultTestCasesService executeResultTestCasesService;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private SiteObjectInsertion siteObjectInsertion;
	@Autowired
	private LogintInsertionUtility logintInsertionUtility;
	
	@Autowired
	private RoutingObjectInsertion routingObjectInsertion;
	@Autowired
	private ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
	// private TestSuites suute;
	@Autowired
	StartTestNgDao startTestNgDao;
	String uid = null;

	public void execute(TestCasesFormSubmit testCasesFormSubmit1) throws InterruptedException {
		String groupName = testCasesFormSubmit1.getGroupName();
       String driverPath=testCasesFormSubmit1.getDriverPath();
		List<TestCasesForm> list = testCasesFormSubmit1.getTestCasesFormlist();
		Map<String, String> map = new HashMap<>();

		list.stream().forEach(tform -> {
			uid = tform.getPageActionName();
			JSONObject jsoninputs = new JSONObject(tform.getPageInputs().toString());
			Set<String> set = jsoninputs.keySet();
			log.info("set   :::  execute " + set.toString());
			set.stream().forEach(key -> {
				map.put(key, jsoninputs.get(key).toString());
			});
			log.info("map   :::  execute " + map.toString());
		});
		testNgService.startSuite(list, uid, groupName, map,driverPath);

	}

	// @Scheduled(fixedDelay = 100000)
	 @Scheduled(cron = "*/1000 * * * * ?")
	public boolean getSubmitalTestCases() {

		ArrayList<TestCasesFormSubmit> arrayList = startTestNgDao.getSubmitalTestCases();
		arrayList.parallelStream().forEach(testCasesFormSubmits -> {
			try {
				log.info(testCasesFormSubmits.getGroupName());				
				execute(testCasesFormSubmits);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return true;
	}
	 
	 
	 
	 
	//@Scheduled(cron = "*/1000 * * * * ?")
		public boolean getTestCases() {
          try{
			TestCasesFormSubmit testCasesFormSubmit = startTestNgDao.getTestCases();
			execute(testCasesFormSubmit);
          }catch(Exception exp){
        	  
          }
			return true;
		}

}
