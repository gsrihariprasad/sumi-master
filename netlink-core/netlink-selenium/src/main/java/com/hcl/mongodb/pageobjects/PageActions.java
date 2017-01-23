package com.hcl.mongodb.pageobjects;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hcl.selenium.pageactionclass.InputDataPageActionClassInterface;



@Document
public class PageActions {


	@Indexed(unique = true) 
	private String pageActionName;
	@Indexed(unique = true) 
	private String pageActionClassName;
	@Indexed(unique = true) 
	private String pageActionClassFullName;
	
	private String isItTestCase;
	
	public String getIsItTestCase() {
		return isItTestCase;
	}

	public void setIsItTestCase(String isItTestCase) {
		this.isItTestCase = isItTestCase;
	}
	   
	private InputDataPageActionClassInterface inputDataPageActionClassInterface; 
	
	private String xpathElements;
	private String xPath;
	
	public String getPageActionClassFullName() {
		return pageActionClassFullName;
	}

	public void setPageActionClassFullName(String pageActionClassFullName) {
		this.pageActionClassFullName = pageActionClassFullName;
	}


	    
	public InputDataPageActionClassInterface getInputDataPageActionClassInterface() {
		return inputDataPageActionClassInterface;
	}

	public void setInputDataPageActionClassInterface(InputDataPageActionClassInterface inputDataPageActionClassInterface) {
		this.inputDataPageActionClassInterface = inputDataPageActionClassInterface;
	}

	public String getPageActionClassName() {
		return pageActionClassName;
	}

	public void setPageActionClassName(String pageActionClassName) {
		this.pageActionClassName = pageActionClassName;
	}

	public String getXpathElements() {
		return xpathElements;
	}

	public void setXpathElements(String xpathElements) {
		this.xpathElements = xpathElements;
	}

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}

	
	public String getPageActionName() {
		return pageActionName;
	}

	public void setPageActionName(String pageActionName) {
		this.pageActionName = pageActionName;
	}

	

}
