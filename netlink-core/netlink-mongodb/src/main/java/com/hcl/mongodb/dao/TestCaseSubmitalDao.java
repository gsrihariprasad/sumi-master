package com.hcl.mongodb.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.selenium.common.formpages.ExecuteResultTestCasesService;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;



@Service("testCaseSubmitalDao")
public class TestCaseSubmitalDao {
	
	private static final Logger log = LoggerFactory.getLogger(TestCaseSubmitalDao.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	public boolean saveSubmitalTestCases(TestCasesFormSubmit testCasesFormSubmit) {
		
		
		mongoTemplate.save(testCasesFormSubmit);
		return true;
	}
	
/*public boolean getSubmitalTestCases() {
	
	TestCasesFormSubmit testCasesFormSubmit;
	
	ArrayList<TestCasesFormSubmit> arrayList=(ArrayList) mongoTemplate.findAll(TestCasesFormSubmit.class);
	//testCasesFormSubmit = mongoTemplate.findOne(query(where(new DbPageObjects().getPageName()).is(pageName).and("pageClass").is(classwithpackage)),DbPageObjects.class);
		for(TestCasesFormSubmit testCasesFormSubmits:arrayList){
	        execute(testCasesFormSubmits); 
	        }
	return true;
	}

*/

}
