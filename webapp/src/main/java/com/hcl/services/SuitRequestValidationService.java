package com.hcl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.dao.SuitRequestValidationDao;

@Service("suitRequestValidationService")
public class SuitRequestValidationService {
	
	@Autowired
	SuitRequestValidationDao suitRequestValidationDao;
	public boolean checkGroupName(String groupname){
	
		return suitRequestValidationDao.checkGroupName(groupname);
	}

}
