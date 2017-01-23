package com.hcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.services.SuitRequestValidationService;

@RestController
@ComponentScan("com.hcl")
public class SuitRequestValidationController {

	@Autowired
	private SuitRequestValidationService suitRequestValidationService;
	
	
	@RequestMapping(value="/validation/{groupName}")
	@ResponseBody
	public boolean groupNameValidation(@PathVariable("groupName") String groupName){
		//suitRequestValidationService.
		return suitRequestValidationService.checkGroupName(groupName);
		
	}
}
