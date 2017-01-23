package com.hcl.mongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("testNgReportDao")
public class TestNgReportDao {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public boolean saveReport(String suitename, String s){
		
		return true;
	}
}
