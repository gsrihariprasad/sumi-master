package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class CreateEnterpriseItems implements InputDataPageActionClassInterface{

	@Indexed(unique = true) 
	String CreateEnterpriseItems_itemName;
	@Indexed(unique = true) 
	String CreateEnterpriseItems_itemDescription;
	
	
	public String getCreateEnterpriseItems_itemName() {
		return CreateEnterpriseItems_itemName;
	}
	public void setCreateEnterpriseItems_itemName(String createEnterpriseItems_itemName) {
		CreateEnterpriseItems_itemName = createEnterpriseItems_itemName;
	}
	public String getCreateEnterpriseItems_itemDescription() {
		return CreateEnterpriseItems_itemDescription;
	}
	public void setCreateEnterpriseItems_itemDescription(String createEnterpriseItems_itemDescription) {
		CreateEnterpriseItems_itemDescription = createEnterpriseItems_itemDescription;
	}
}
