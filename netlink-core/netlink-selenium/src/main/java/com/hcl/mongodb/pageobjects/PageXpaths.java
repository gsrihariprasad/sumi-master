package com.hcl.mongodb.pageobjects;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PageXpaths {

	private String key;
	@Indexed(unique = true) 
	private String pageElement;
	
	private String pageElementXPath;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPageElement() {
		return pageElement;
	}

	public void setPageElement(String pageElement) {
		this.pageElement = pageElement;
	}

	public String getPageElementXPath() {
		return pageElementXPath;
	}

	public void setPageElementXPath(String pageElementXPath) {
		this.pageElementXPath = pageElementXPath;
	}

}
