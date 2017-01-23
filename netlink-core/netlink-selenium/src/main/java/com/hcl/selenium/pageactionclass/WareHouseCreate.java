package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class WareHouseCreate {
	@Indexed(unique = true) 
	private String wareHouseCreate_SiteId;
	@Indexed(unique = true) 
	private String wareHouseCreate_WareDesc;
	@Indexed(unique = true) 
	private String wareHouseCreate_WareHouseId;

	public String getWareHouseCreate_SiteId() {
		return wareHouseCreate_SiteId;
	}
	public void setWareHouseCreate_SiteId(String wareHouseCreate_SiteId) {
		this.wareHouseCreate_SiteId = wareHouseCreate_SiteId;
	}
	public String getWareHouseCreate_WareDesc() {
		return wareHouseCreate_WareDesc;
	}
	public void setWareHouseCreate_WareDesc(String wareHouseCreate_WareDesc) {
		this.wareHouseCreate_WareDesc = wareHouseCreate_WareDesc;
	}
	public String getWareHouseCreate_WareHouseId() {
		return wareHouseCreate_WareHouseId;
	}
	public void setWareHouseCreate_WareHouseId(String wareHouseCreate_WareHouseId) {
		this.wareHouseCreate_WareHouseId = wareHouseCreate_WareHouseId;
	}
	
	

}