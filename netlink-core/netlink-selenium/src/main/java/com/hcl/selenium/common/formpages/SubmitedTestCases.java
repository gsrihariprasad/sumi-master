package com.hcl.selenium.common.formpages;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

import com.hcl.selenium.pageactionclass.InputDataPageActionClassInterface;

public class SubmitedTestCases {
	
	private String pageName;	
	@Indexed(unique = true)
	private String pageActionClassName;
	@Indexed(unique = true)
	private String pageActionClassFullName;
	@Indexed
	private List<InputDataPageActionClassInterface> pageInputs;
	@LastModifiedBy
	protected String lastModifiedBy;
	@LastModifiedDate
	protected Date lastModifiedDate;
	@Version
	protected Long version;
	@CreatedBy
	private String createdBy;
	@Indexed(unique = true)
	private String pageActionName;

	public List<InputDataPageActionClassInterface> getPageInputs() {
		return pageInputs;
	}

	public void setPageInputs(List<InputDataPageActionClassInterface> pageInputs) {
		this.pageInputs = pageInputs;
	}

	public String getPageActionName() {
		return pageActionName;
	}

	public void setPageActionName(String pageActionName) {
		this.pageActionName = pageActionName;
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
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
