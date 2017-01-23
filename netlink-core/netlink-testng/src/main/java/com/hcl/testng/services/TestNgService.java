package com.hcl.testng.services;

import java.util.List;
import java.util.Map;

import com.hcl.selenium.common.formpages.TestCasesForm;

public interface TestNgService {
	//public boolean startSuite(TestSuites testSuite,String suiteid,String uid,Map<String, String> mapparams);
	public boolean startSuite(List<TestCasesForm> list, String suiteid, String uid, Map<String, String> mapparams,String driverPath);
}
