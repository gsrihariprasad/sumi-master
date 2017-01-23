package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class ChangeRouting implements InputDataPageActionClassInterface{

	
	private static final long serialVersionUID = 1L;
	@Indexed(unique = true) 
	private String changeRouting_RoutingIdentifier;
	@Indexed(unique = true) 
	private String  changeRouting_RoutingVersion;	
	@Indexed(unique = true) 
	private String changeRouting_RoutingDescription;
	@Indexed(unique = true) 
	private String changeRouting_RoutingName;	
	
	public String getChangeRouting_RoutingName() {
		return changeRouting_RoutingName;
	}
	public void setChangeRouting_RoutingName(String changeRouting_RoutingName) {
		this.changeRouting_RoutingName = changeRouting_RoutingName;
	}
	public String getChangeRouting_RoutingIdentifier() {
		return changeRouting_RoutingIdentifier;
	}
	public void setChangeRouting_RoutingIdentifier(String changeRouting_RoutingIdentifier) {
		this.changeRouting_RoutingIdentifier = changeRouting_RoutingIdentifier;
	}
	public String getChangeRouting_RoutingVersion() {
		return changeRouting_RoutingVersion;
	}
	public void setChangeRouting_RoutingVersion(String changeRouting_RoutingVersion) {
		this.changeRouting_RoutingVersion = changeRouting_RoutingVersion;
	}
	public String getChangeRouting_RoutingDescription() {
		return changeRouting_RoutingDescription;
	}
	public void setChangeRouting_RoutingDescription(String changeRouting_RoutingDescription) {
		this.changeRouting_RoutingDescription = changeRouting_RoutingDescription;
	}
	
	
	
	
}
