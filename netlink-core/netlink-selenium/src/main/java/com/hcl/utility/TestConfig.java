package com.hcl.utility;

public class TestConfig {
	
	public static long MIN_EXPLICIT_WAIT_TIME = 10;
	public static int NUM_RETRIES_FOR_FAILED_OPERATION = 3;
	public static int NUM_RETRIES_FOR_FAILED_TEST_CASES = 0;
	public static long RETRY_FAILED_OPERATION_INTERVAL = 3; 
	
	public boolean setMinExplicitWaitTime(long waitTime){
		MIN_EXPLICIT_WAIT_TIME = waitTime;
		return true;
	}
	
	public boolean setNumRetriesForFailedOperation(int retries){
		NUM_RETRIES_FOR_FAILED_OPERATION = retries;
		return true;
	}
	
	public boolean setNumRetriesForFailedTestCases(int retries){
		NUM_RETRIES_FOR_FAILED_TEST_CASES = retries;
		return true;
	}
	
	public boolean setRetryIntervalForFailedOperation(long retryInterval){
		RETRY_FAILED_OPERATION_INTERVAL = retryInterval;
		return true;
	}
	
	public boolean resetRetryIntervalForFailedOperation(){
		RETRY_FAILED_OPERATION_INTERVAL = 5;
		return true;
	}
}
