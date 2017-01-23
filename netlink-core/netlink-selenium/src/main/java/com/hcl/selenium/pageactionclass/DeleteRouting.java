package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class DeleteRouting implements InputDataPageActionClassInterface{
	@Indexed(unique = true) 
	private String deleteRouting_RoutingName; 
	@Indexed(unique = true) 
	private String deleteRouting_RoutingIdentifier;
	@Indexed(unique = true) 
	private String deleteRouting_RoutingVersion;
	
	public String getDeleteRouting_RoutingName() {
		return deleteRouting_RoutingName;
	}
	public void setDeleteRouting_RoutingName(String deleteRouting_RoutingName) {
		this.deleteRouting_RoutingName = deleteRouting_RoutingName;
	}
	public String getDeleteRouting_RoutingIdentifier() {
		return deleteRouting_RoutingIdentifier;
	}
	public void setDeleteRouting_RoutingIdentifier(String deleteRouting_RoutingIdentifier) {
		this.deleteRouting_RoutingIdentifier = deleteRouting_RoutingIdentifier;
	}
	public String getDeleteRouting_RoutingVersion() {
		return deleteRouting_RoutingVersion;
	}
	public void setDeleteRouting_RoutingVersion(String deleteRouting_RoutingVersion) {
		this.deleteRouting_RoutingVersion = deleteRouting_RoutingVersion;
	}
	
}
