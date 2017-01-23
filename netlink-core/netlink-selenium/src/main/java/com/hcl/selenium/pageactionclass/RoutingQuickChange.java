package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class RoutingQuickChange  implements InputDataPageActionClassInterface{
	@Indexed(unique = true) 
	private String RoutingQuickChange_RoutingName;
	@Indexed(unique = true) 
	private String RoutingQuickChange_RoutingIdentifier;
	@Indexed(unique = true) 
	private String RoutingQuickChange_RoutingVersion;
	@Indexed(unique = true) 
	private String RoutingQuickChange_RoutingDescription;
	
	public String getRoutingQuickChange_RoutingName() {
		return RoutingQuickChange_RoutingName;
	}
	public void setRoutingQuickChange_RoutingName(String routingQuickChange_RoutingName) {
		RoutingQuickChange_RoutingName = routingQuickChange_RoutingName;
	}
	public String getRoutingQuickChange_RoutingIdentifier() {
		return RoutingQuickChange_RoutingIdentifier;
	}
	public void setRoutingQuickChange_RoutingIdentifier(String routingQuickChange_RoutingIdentifier) {
		RoutingQuickChange_RoutingIdentifier = routingQuickChange_RoutingIdentifier;
	}
	public String getRoutingQuickChange_RoutingVersion() {
		return RoutingQuickChange_RoutingVersion;
	}
	public void setRoutingQuickChange_RoutingVersion(String routingQuickChange_RoutingVersion) {
		RoutingQuickChange_RoutingVersion = routingQuickChange_RoutingVersion;
	}
	public String getRoutingQuickChange_RoutingDescription() {
		return RoutingQuickChange_RoutingDescription;
	}
	public void setRoutingQuickChange_RoutingDescription(String routingQuickChange_RoutingDescription) {
		RoutingQuickChange_RoutingDescription = routingQuickChange_RoutingDescription;
	}
	
	
}
