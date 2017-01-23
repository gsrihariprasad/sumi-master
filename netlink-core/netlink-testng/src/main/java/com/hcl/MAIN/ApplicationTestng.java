package com.hcl.MAIN;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hcl.mongodb.dao.EnvironmentInterface;
import com.hcl.mongodb.repository.User;
import com.hcl.mongodb.repository.UserRepository;
import com.hcl.mongodb.repository.UserRole;
import com.hcl.selenium.common.formpages.SeleniumEnvironment;
import com.hcl.testng.services.GatewayService;
import com.hello.Application;


@SpringBootApplication(scanBasePackages = { "com" })
// @EnableAutoConfiguration
 @EnableScheduling
public class ApplicationTestng implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ApplicationTestng.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationTestng.class);
	}
	@Autowired
	private GatewayService gatewayService;
	@Autowired
	Application application;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EnvironmentInterface environmentImpl;
	@Autowired
	SeleniumEnvironment seleniumEnvironment;
	@Override
	public void run(String... args) throws Exception {
		//application.runstart();
		gatewayService.startTestSuiteExecution();
		
		
		//runuser();
		//runEnvironment();
	}
	
public void runEnvironment(){
	
	seleniumEnvironment.setUrl("http://localhost:39379/NetLink/");
	seleniumEnvironment.setEnvironment("USALIL2A");
	seleniumEnvironment.setDriverPath("d://chromedriver.exe");
	environmentImpl.setEnvironment(seleniumEnvironment);
}
	public void runuser(){
		User user=new User();
		user.setEmail("ss@gsrihari");
		user.setEnabled(1);
		user.setPassword("mypassword");
		user.setUserId((long) 1);
		user.setUserName("srihari");
		List<UserRole> list=new ArrayList<UserRole>();
		UserRole role=new UserRole();
		role.setRole("admin");
		role.setUserid((long) 1);
		role.setUserroleid((long) 1);
		list.add(role);
		user.setUserRoles(list);
		userRepository.save(user);	
		
		///
		User user1=new User();
		user1.setEmail("ss@gsrihari");
		user1.setEnabled(1);
		user1.setPassword("password123");
		user1.setUserId((long) 2);
		user1.setUserName("gshp");
		List<UserRole> list1=new ArrayList<UserRole>();
		UserRole role1=new UserRole();
		role1.setRole("admin");
		role1.setUserid((long) 2);
		role1.setUserroleid((long) 1);
		list1.add(role1);
		user1.setUserRoles(list1);
		userRepository.save(user1);	
	}
	
	/*  @Bean
		public CommandLineRunner demo(UserRepository userRepository) {
			return (args) -> {
				// save a couple of customers
				User user=new User();
				user.setEmail("ss@gsrihari");
				user.setEnabled(1);
				user.setPassword("mypassword");
				user.setUserId((long) 1);
				user.setUserName("srihari");
				List<UserRole> list=new ArrayList<UserRole>();
				UserRole role=new UserRole();
				role.setRole("admin");
				role.setUserid((long) 1);
				role.setUserroleid((long) 1);
				list.add(role);
				user.setUserRoles(list);
				userRepository.save(user);	
				
				///
				User user1=new User();
				user1.setEmail("ss@gsrihari");
				user1.setEnabled(1);
				user1.setPassword("password123");
				user1.setUserId((long) 2);
				user1.setUserName("gshp");
				List<UserRole> list1=new ArrayList<UserRole>();
				UserRole role1=new UserRole();
				role1.setRole("admin");
				role1.setUserid((long) 2);
				role1.setUserroleid((long) 1);
				list1.add(role1);
				user1.setUserRoles(list1);
				userRepository.save(user1);	
				
				
			};
		}
	*/
}
