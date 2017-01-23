package com.hcl.selenium.pageactionclass;

import java.io.Serializable;
import java.util.Map;

import org.json.JSONObject;

public interface InputDataPageActionClassInterface extends Serializable{
	
	default public void setInputData(Map map){
		
	}
	
/*	 private T t;          

	    public void set(T t) {
	        this.t = t;
	    }

	    public T get() {
	        return t;
	    }
	    List listInputs;
	    public <U extends BasePageActionClass> List getListInputs(U u) {
	    	
			return listInputs;
		}
*/
	//public InputDataPageActionClassInterface addInputValues(JSONObject a);
		
}
