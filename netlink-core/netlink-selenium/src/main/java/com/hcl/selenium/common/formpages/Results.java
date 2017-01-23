package com.hcl.selenium.common.formpages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Results {
	@Autowired
	private TestCasesFormSubmit testCasesFormSubmit;

	private String results;	

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

}
