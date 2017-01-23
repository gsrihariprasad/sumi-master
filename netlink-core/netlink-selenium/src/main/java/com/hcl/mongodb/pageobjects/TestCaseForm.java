package com.hcl.mongodb.pageobjects;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document//(collection = "TestCaseForm")
public class TestCaseForm {
	
	@Id	
    private String pageId;
  
	private String pageName;
    @Indexed
   	private String testCase;
    
    private String name;
    
    
    List<TestCaseFormInputData> testCaseFormInputData;
 
	  public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	   
	    
		public List<TestCaseFormInputData> getTestCaseFormInputData() {
			return testCaseFormInputData;
		}
		public void setTestCaseFormInputData(List<TestCaseFormInputData> testCaseFormInputData) {
			this.testCaseFormInputData = testCaseFormInputData;
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
		public String getTestCase() {
			return testCase;
		}
		public void setTestCase(String testCase) {
			this.testCase = testCase;
		}
		
		
}
