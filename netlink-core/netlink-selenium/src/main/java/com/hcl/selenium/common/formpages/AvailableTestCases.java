package com.hcl.selenium.common.formpages;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.hcl.selenium.pageactionclass.InputDataPageActionClassInterface;

@Document
@Service("availableTestCases")
public class AvailableTestCases {
	
		
	@Indexed(unique = true) 
	private String groupName;
	@Id
	private String id;	
	private String pageClassFullName;
	private String pageName;	
	@Indexed(unique = true)
	private String pageActionClassName;
	@Indexed(unique = true)
	private String pageActionClassFullName;
	@Indexed
	private InputDataPageActionClassInterface pageInputs;
	

	public String getPageClassFullName() {
		return pageClassFullName;
	}

	public void setPageClassFullName(String pageClassFullName) {
		this.pageClassFullName = pageClassFullName;
	}

	public InputDataPageActionClassInterface getPageInputs() {
		return pageInputs;
	}

	public void setPageInputs(InputDataPageActionClassInterface pageInputs) {
		this.pageInputs = pageInputs;
	}

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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

	/*public String getTestsuitename() {
		return testsuitename;
	}

	public void setTestsuitename(String testsuitename) {
		this.testsuitename = testsuitename;
	}*/

	
}
