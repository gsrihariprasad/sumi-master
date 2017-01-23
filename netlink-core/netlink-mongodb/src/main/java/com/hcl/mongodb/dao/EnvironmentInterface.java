package com.hcl.mongodb.dao;

import java.util.List;

import com.hcl.selenium.common.formpages.SeleniumEnvironment;



public interface EnvironmentInterface {

	public List<SeleniumEnvironment> getEnvironment();
	public void setEnvironment(SeleniumEnvironment environment);
}
