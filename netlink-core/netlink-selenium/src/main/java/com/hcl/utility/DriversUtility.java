package com.hcl.utility;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class DriversUtility {

	private static Map<String, WebDriver> driverMap = null;
	private static Map<String,String> driverName=null;

	public static String getDriverName(String driver) {
		return driverName.get(driver);
	}

	public static void setDriverName(String name,String n) {
				
		if (driverName == null)
			driverName = new LinkedHashMap<String, String>();

		driverName.put(name.trim(), n);
	}

	public static void setDriverMap(String driverName, WebDriver driver) {

		if (driverMap == null)
			driverMap = new LinkedHashMap<String, WebDriver>();

		driverMap.put(driverName.trim(), driver);

	}

	public static WebDriver getDriverMap(String driverName) {

		return driverMap.get(driverName);
	}

}
