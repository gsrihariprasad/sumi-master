package com.hcl.mongodb.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.selenium.common.formpages.TestCasesFormSubmit;

@Service("suitRequestValidationDao")
public class SuitRequestValidationDao {
	@Autowired
	MongoTemplate mongoTemplate;
	String gname;
	public boolean checkGroupName(String name){
		
		Logger logger = LoggerFactory.getLogger(SuitRequestValidationDao.class);
		
		this.gname=name.replace("{", "").replace("}", "").trim();
	
		logger.info(" groupName :"+gname+"  Result : "+  mongoTemplate.exists(query(where("groupName").is(gname)),TestCasesFormSubmit.class,"testCasesFormSubmit"));
		boolean results=mongoTemplate.exists(query(where("groupName").is(gname)),TestCasesFormSubmit.class);
		logger.info(" Result :: "+results);
		
		return results;
	}
}
