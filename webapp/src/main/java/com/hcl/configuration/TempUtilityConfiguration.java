package com.hcl.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;


@Configuration
@EntityScan("com.inpututility.pageobject")
@ComponentScan("com.inpututility.pageobject")
public class TempUtilityConfiguration {

	public @Bean LogintInsertionUtility pageObjectInsertionUtility() {
		return new LogintInsertionUtility();
	}

	public @Bean SiteObjectInsertion siteObjectInsertion() {
		return new SiteObjectInsertion();
	}

	public @Bean ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion() {
		return new ApplicationsCardsNavigationInsertion();
	}
}
