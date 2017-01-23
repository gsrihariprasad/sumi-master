package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class CreateRouting implements InputDataPageActionClassInterface {
	
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
	private String CreateRouting_RoutingName;
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
		private String CreateRouting_RoutingIdentifier;
		
		//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
		private String CreateRouting_RoutingVersion;
		
		//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
		private String CreateRouting_RoutingDescription;
		
	
	public String getCreateRouting_RoutingName() {
		return CreateRouting_RoutingName;
	}

	public void setCreateRouting_RoutingName(String createRouting_RoutingName) {
		CreateRouting_RoutingName = createRouting_RoutingName;
	}

	public String getCreateRouting_RoutingIdentifier() {
		return CreateRouting_RoutingIdentifier;
	}

	public void setCreateRouting_RoutingIdentifier(String createRouting_RoutingIdentifier) {
		CreateRouting_RoutingIdentifier = createRouting_RoutingIdentifier;
	}

	public String getCreateRouting_RoutingVersion() {
		return CreateRouting_RoutingVersion;
	}

	public void setCreateRouting_RoutingVersion(String createRouting_RoutingVersion) {
		CreateRouting_RoutingVersion = createRouting_RoutingVersion;
	}

	public String getCreateRouting_RoutingDescription() {
		return CreateRouting_RoutingDescription;
	}

	public void setCreateRouting_RoutingDescription(String createRouting_RoutingDescription) {
		CreateRouting_RoutingDescription = createRouting_RoutingDescription;
	}

	
	
	

}
