package com.hcl.selenium.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.utility.LocalDateTimeUtility;

@Configuration
//@EntityScan("com.hcl")
public class SeleniumCfg {

	
	
	public @Bean LocalDateTimeUtility localDateTimeUtility(){
		
		return new LocalDateTimeUtility();
	}
	
}
