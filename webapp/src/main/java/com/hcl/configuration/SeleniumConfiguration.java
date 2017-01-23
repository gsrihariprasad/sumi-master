package com.hcl.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.mongodb.pageobjects.DbPageObjects;




/**
 * 
 * @author G Srihari
 * 
 * @Configuration tags the class as a source of bean definitions for the
 *                application context.
 * @EnableAutoConfiguration tells Spring Boot to start adding beans based on
 *                          classpath settings, other beans, and various
 *                          property settings.
  
 */
@Configuration
@EnableAutoConfiguration
public class SeleniumConfiguration {

	@Bean
	public DbPageObjects pageObjects() {

		return new DbPageObjects();
	}
	
	/*@Bean
	public TestNgServiceImpl testNgServiceImpl() {

		return new TestNgServiceImpl();
	}*/
}
