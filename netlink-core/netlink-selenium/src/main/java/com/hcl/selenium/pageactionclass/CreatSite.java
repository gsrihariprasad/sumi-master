package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class CreatSite implements InputDataPageActionClassInterface {
	
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
	private String createSite_SiteId;
	//@JsonView(View.InputDataPageActionClassInterface.class)
	@Indexed(unique = true) 
		private String createSite_SiteDesc;
		
		
	public String getCreateSite_SiteId() {
		return createSite_SiteId;
	}
	public void setCreateSite_SiteId(String createSite_SiteId) {
		this.createSite_SiteId = createSite_SiteId;
	}
	public String getCreateSite_SiteDesc() {
		return createSite_SiteDesc;
	}
	public void setCreateSite_SiteDesc(String createSite_SiteDesc) {
		this.createSite_SiteDesc = createSite_SiteDesc;
	}
	

}