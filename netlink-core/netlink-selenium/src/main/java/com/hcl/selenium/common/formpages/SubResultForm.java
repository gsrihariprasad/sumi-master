package com.hcl.selenium.common.formpages;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SubResultForm{
	
	private String methodName;
	private int status;
	private String Exception;
	private String className;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
	public String getException() {
		return Exception;
	}
	public void setException(String exception) {
		Exception = exception;
	}
	
}
