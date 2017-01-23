package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class RoutingCreate {
	
	@Indexed(unique = true) 
	private String RoutingCreate_RouteId;
	@Indexed(unique = true) 
	private String RoutingCreate_RouteDesc;
	public String getRoutingCreate_RouteId() {
		return RoutingCreate_RouteId;
	}
	public void setRoutingCreate_RouteId(String routingCreate_RouteId) {
		RoutingCreate_RouteId = routingCreate_RouteId;
	}
	public String getRoutingCreate_RouteDesc() {
		return RoutingCreate_RouteDesc;
	}
	public void setRoutingCreate_RouteDesc(String routingCreate_RouteDesc) {
		RoutingCreate_RouteDesc = routingCreate_RouteDesc;
	}
	


}