package com.hcl.selenium.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.selenium.common.formpages.ExecuteResultTestCasesService;
import com.hcl.selenium.common.formpages.ResultForm;
import com.hcl.selenium.common.formpages.Results;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;
import com.mongodb.MongoClient;

@Configuration
// @EnableAutoConfiguration
// @EntityScan("com.hcl")
public class DbTemplateCfg {

	public @Bean MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("localhost"), "netlinkaut");
		return mongoTemplate;

	}

	public @Bean GetDbXpathsAndElemetsDao getDbXpathsAndElemetsService() throws Exception {

		return new GetDbXpathsAndElemetsDao();

	}

	public @Bean Results results() throws Exception {

		return new Results();

	}

	public @Bean TestCasesFormSubmit testCasesFormSubmit() throws Exception {

		return new TestCasesFormSubmit();

	}
	
	
	public @Bean ExecuteResultTestCasesService resultService() throws Exception {

		return new ExecuteResultTestCasesService();

	}
	
	
	public @Bean ResultForm resultForm() throws Exception {

		return new ResultForm();

	}
}
