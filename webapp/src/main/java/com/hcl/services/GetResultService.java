package com.hcl.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.DaoServices.ResultSeleniumDao;
import com.hcl.selenium.common.formpages.ResultForm;;
@Service("getResultService")
public class GetResultService {
	private static final Logger logger = LoggerFactory.getLogger(GetResultService.class);
	@Autowired
	ResultSeleniumDao resultSeleniumDao;

	public List<ResultForm> getResults() {

		List<ResultForm> res = resultSeleniumDao.getResults();
		res.stream().forEach(r ->logger.info(" ResultService  ::: " + r.getGroupName()));
		return res;
	}
	
	
}
