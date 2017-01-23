package com.hcl.selenium.common.formpages;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Document(collection="SeleniumEnvironment")
@Service("seleniumEnvironment")
public class SeleniumEnvironment {
	
	@Id
	private String id;
	private String url;
	private String environment;
	private String driverPath;
	
	public String getDriverPath() {
		return driverPath;
	}
	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	

}
