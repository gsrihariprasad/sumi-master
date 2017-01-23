package com.hcl.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hcl.selenium.common.formpages.ResultForm;
import com.hcl.services.GetResultService;
@RestController
public class ResultController {
	Logger logger = LoggerFactory.getLogger(ResultController.class);
	@Autowired
	@Qualifier("getResultService")
	private GetResultService getResultService;
	
	/*	@RequestMapping(value = "/getResults", method = RequestMethod.GET)
		public String getResultsPage(ModelMap map) {
			
			List<ResultForm> res = getResultService.getResults();
			res.stream().forEach(r -> System.out.println(" GGGGGGGGGGG  ::: " + r.getGroupName()));
			Gson gson = new Gson();
			String jsonInString = gson.toJson(res);

			logger.info(" HOME :::  jsonInString  ::  " + jsonInString);
			map.put("listOfResults", res);

			return "Results";

		}	*/
		
		@RequestMapping(value = "/results", method = RequestMethod.GET)
		
		public @ResponseBody String getResults(ModelMap map) {
			
			List<ResultForm> res = getResultService.getResults();
			res.stream().forEach(r -> logger.info(" ResultController  getResults() ::: " + r.getGroupName()));
			Gson gson = new Gson();
			String jsonInString = gson.toJson(res);

			logger.info(" HOME :::  jsonInString  ::  " + jsonInString);
			map.put("listOfResults", res);

			return jsonInString;

		}	
		
	
}
