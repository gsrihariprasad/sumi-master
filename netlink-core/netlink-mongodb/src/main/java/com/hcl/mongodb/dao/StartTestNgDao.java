package com.hcl.mongodb.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.hcl.selenium.common.formpages.TestCasesFormSubmit;
import com.hcl.utility.STATUS;

@Component("startTestNgDao")
public class StartTestNgDao {
	private static final Logger log = LoggerFactory.getLogger(StartTestNgDao.class);
	@Autowired
	private MongoTemplate mongoTemplate;

	public ArrayList<TestCasesFormSubmit> getSubmitalTestCases() {
		
		ArrayList<TestCasesFormSubmit> arrayList = null;

		try {
			log.info(" groupName :" + mongoTemplate.exists(query(where("status").is(STATUS.READY)),
					TestCasesFormSubmit.class, "testCasesFormSubmit"));
			arrayList = (ArrayList<TestCasesFormSubmit>) mongoTemplate.find(query(where("status").is(STATUS.READY)),
					TestCasesFormSubmit.class, "testCasesFormSubmit");
			log.info(" Result :: " + arrayList.toString());
			
		} catch (Exception exp) {
			log.error("StartTestNgDao getSubmitalTestCases  Exception " + exp);
		}

		return arrayList;
	}
	public  TestCasesFormSubmit getTestCases() {
		
		TestCasesFormSubmit arrayList = null;

		try {
			log.info(" groupName :" + mongoTemplate.exists(query(where("status").is(STATUS.READY)),
					TestCasesFormSubmit.class, "testCasesFormSubmit"));
			arrayList = (TestCasesFormSubmit) mongoTemplate.findOne(query(where("status").is(STATUS.READY)),
					TestCasesFormSubmit.class, "testCasesFormSubmit");
			log.info(" Result :: " + arrayList);
			
		} catch (Exception exp) {
			log.error("StartTestNgDao getTestCases Exception " + exp);
		}

		return arrayList;
	}
}
