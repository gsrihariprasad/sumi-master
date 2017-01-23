package com.hcl.selenium.interfaceImpl;

import java.util.Arrays;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface SpringAnnotationAppConfigContextInterface {
	 static final Logger log = LoggerFactory.getLogger(SpringAnnotationAppConfigContextInterface.class);
	 
	static ApplicationContext getAnnotationConfig(Class registerclass) {
		ApplicationContext ctx = null;
		try {
			AnnotationConfigApplicationContext AContext = new AnnotationConfigApplicationContext();
			/*Stream<Class> stream = Arrays.stream(registerclass);
			stream.forEach(regclass -> {
				AContext.register(regclass);
			});*/
			AContext.register(registerclass);
			AContext.refresh();
			ctx = AContext;
		} catch (Exception execption) {
			log.error("SpringAnnotationAppConfigContextInterface errror :: "+execption);
		}
		return ctx;
	}
}
