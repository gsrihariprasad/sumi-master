package com.hcl.selenium.common.formpages;

import org.springframework.data.mongodb.core.index.Indexed;

import com.hcl.selenium.pageactionclass.InputDataPageActionClassInterface;

public class TestCasesForm {
private String pageName;
	
	@Indexed
	//@JsonView(View.InputDataPageActionClassInterface.class)
	private String pageActionClassName;
	
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed
	private String pageActionClassFullName;
	
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed
	Object pageInputs;
	@Indexed
	private String pageActionName;
	@Indexed
	private String pageClassFullName;
	
public String getPageClassFullName() {
		return pageClassFullName;
	}
	public void setPageClassFullName(String pageClassFullName) {
		this.pageClassFullName = pageClassFullName;
	}
public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageActionClassName() {
		return pageActionClassName;
	}
	public void setPageActionClassName(String pageActionClassName) {
		this.pageActionClassName = pageActionClassName;
	}
	public String getPageActionClassFullName() {
		return pageActionClassFullName;
	}
	public void setPageActionClassFullName(String pageActionClassFullName) {
		this.pageActionClassFullName = pageActionClassFullName;
	}
	public Object getPageInputs() {
		return pageInputs;
	}
	public void setPageInputs(Object object) {
		this.pageInputs = object;
	}
	public String getPageActionName() {
		return pageActionName;
	}
	public void setPageActionName(String pageActionName) {
		this.pageActionName = pageActionName;
	}

}
