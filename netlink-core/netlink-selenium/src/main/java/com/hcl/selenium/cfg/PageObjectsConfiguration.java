package com.hcl.selenium.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.hcl.selenium.pageobjects.ApplicationCardsNavigationObject;
import com.hcl.selenium.pageobjects.BasePageObject;
import com.hcl.selenium.pageobjects.LoginObject;
import com.hcl.selenium.pageobjects.ObjectNavinagationObject;
import com.hcl.selenium.pageobjects.SiteObject;
import com.hcl.selenium.pageobjects.TabbedCardsNavigationObject;

@Configuration
//@EntityScan("com.hcl")
public class PageObjectsConfiguration {
	
/*@Scope("request")	
@Lazy
public @Bean Browser browser(){
		
		return new Browser();
	}*/
//@Scope("request")
@Lazy
public @Bean SiteObject siteObject(){
	
	return new SiteObject();
}
//@Scope("request")
@Lazy
public @Bean BasePageObject basePageObject(){
	return new BasePageObject();
}


//@Scope("request")
@Lazy
public @Bean ObjectNavinagationObject objectNavinagation(){
	
	return new ObjectNavinagationObject();
}

//@Scope("request")
@Lazy
public @Bean LoginObject login(){
	
	return new LoginObject();
}

//@Scope("request")
@Lazy
public @Bean ApplicationCardsNavigationObject applicationCardsNavigation(){
	
	return new ApplicationCardsNavigationObject();
}

//@Scope("request")
@Lazy
public @Bean TabbedCardsNavigationObject tabbedCardsNavigation(){
	
	return new TabbedCardsNavigationObject();
}
/*public @Bean TestDataForm demoform(){
	
	return new TestDataForm();
}
*/
}
