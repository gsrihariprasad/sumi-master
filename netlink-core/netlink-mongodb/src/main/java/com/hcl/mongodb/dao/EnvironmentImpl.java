package com.hcl.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.selenium.common.formpages.SeleniumEnvironment;



@Service("environmentInterface")
public class EnvironmentImpl implements EnvironmentInterface{

	@Autowired
	MongoTemplate mongoTemplate;
	Logger logger = LoggerFactory.getLogger(EnvironmentImpl.class);
	@Override
	public List<SeleniumEnvironment>  getEnvironment() {
		logger.info("EnvironmentImpl..");
		List<SeleniumEnvironment> pages = (ArrayList) mongoTemplate.findAll(SeleniumEnvironment.class, "SeleniumEnvironment");
		logger.info(""+pages.stream().count());
		return pages;
	}

	@Override
	public void setEnvironment(SeleniumEnvironment environment) {
		
		mongoTemplate.save(environment);
	}

	

}
