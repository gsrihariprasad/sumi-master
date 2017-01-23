package com.hcl.mongodb.pageobjects;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PageObjects")
public class DbPageObjects {

	@Id
	private String pageId;
	@Indexed
	private String pageName;
	@Indexed
	private String pageClass;
	@Indexed
	private List<PageActions> pageActions;
	@Indexed
	private List<PageXpaths> pageXpaths;

	@LastModifiedBy
	protected String lastModifiedBy;

	@LastModifiedDate
	protected Date lastModifiedDate;
	@Version
	protected Long version;

	@CreatedBy
	private String createdBy;

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageClass() {
		return pageClass;
	}

	public void setPageClass(String pageClass) {
		this.pageClass = pageClass;
	}

	public List<PageActions> getPageActions() {
		return pageActions;
	}

	public void setPageActions(List<PageActions> pageActions) {
		this.pageActions = pageActions;
	}

	public List<PageXpaths> getPageXpaths() {
		return pageXpaths;
	}

	public void setPageXpaths(List<PageXpaths> pageXpaths) {
		this.pageXpaths = pageXpaths;
	}

}
