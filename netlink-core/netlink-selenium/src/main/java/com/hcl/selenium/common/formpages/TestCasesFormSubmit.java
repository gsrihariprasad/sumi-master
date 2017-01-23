package com.hcl.selenium.common.formpages;

import java.io.Serializable;
import java.time.Instant;
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

@Document(collection = "testCasesFormSubmit")
@Service("testCasesFormSubmit")
public class TestCasesFormSubmit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Indexed(unique = true)

	private String groupName;

	@Id
	private String id;

	@LastModifiedBy
	protected String lastModifiedBy;

	@LastModifiedDate
	protected Date lastModifiedDate;

	@Version
	protected Long version;

	@CreatedBy
	private String createdBy;
     //2017-01-17T00:36:00.000Z
	private Instant timeToExecute;
	private List<TestCasesForm> testCasesFormlist;
	private String  status;
	
	private String driverPath;

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getTimeToExecute() {
		return timeToExecute;
	}

	public void setTimeToExecute(Instant timeToExecute) {
		this.timeToExecute = timeToExecute;
	}

	

	public String getId() {
		return id;
	}

	public List<TestCasesForm> getTestCasesFormlist() {
		return testCasesFormlist;
	}

	public void setTestCasesFormlist(List<TestCasesForm> testCasesFormlist) {
		this.testCasesFormlist = testCasesFormlist;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
