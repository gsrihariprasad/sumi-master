package com.hcl.selenium.common.formpages;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Service("resultForm")
@Document(collection = "ResultForm")
public class ResultForm {

	@Id
	private String id;

	private String groupName;
	private String suiteName;
	private Instant startDate;
	private Instant endDate;
	private List<SubResultForm> subResultForm;

	public List<SubResultForm> getSubResultForm() {
		return subResultForm;
	}

	public void setSubResultForm(List<SubResultForm> subResultForm) {
		this.subResultForm = subResultForm;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

}
