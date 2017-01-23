package com.hcl.testng.cfg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.testng.Listeners.TestNGListener;
import com.hcl.testng.services.TestNgServiceImpl;
import org.testng.TestNG;
@Configuration
@EnableAutoConfiguration
public class TestNgConfiguration {

	
	
	@Bean
	public TestNGListener listenerClass() {

		return new TestNGListener();
	}
	@Bean
	public TestNG testNG() {

		return new TestNG();
	}
	
	@Bean
	public TestNgServiceImpl testNgService() {

		return new TestNgServiceImpl();
	}
}
