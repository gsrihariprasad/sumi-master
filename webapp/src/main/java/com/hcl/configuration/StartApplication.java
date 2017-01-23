package com.hcl.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author srihari
 * @ComponentScan tells Spring to look for other components, configurations, and
 * services in the the hello package, allowing it to find the controllers.
 *                
 * 
 */
@SpringBootApplication(scanBasePackages={"com.hcl"})
@EnableAutoConfiguration
@ComponentScan({ "com.hcl"})
public class StartApplication {
	Logger logger = LoggerFactory.getLogger(StartApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
	
}
