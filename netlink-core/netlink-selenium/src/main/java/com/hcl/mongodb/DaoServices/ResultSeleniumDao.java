package com.hcl.mongodb.DaoServices;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.hcl.selenium.cfg.DbTemplateCfg;
import com.hcl.selenium.common.formpages.ResultForm;
import com.hcl.selenium.common.formpages.SubResultForm;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;
import com.hcl.selenium.interfaceImpl.SpringAnnotationAppConfigContextInterface;
import com.hcl.utility.STATUS;


@Service("resultSeleniumDao")
public class ResultSeleniumDao {

	private static final Logger logger = LoggerFactory.getLogger(ResultSeleniumDao.class);

	public List<SubResultForm> formResults(List<Set<ITestResult>> listResults) {
		List<SubResultForm> listOfSubResult = new ArrayList<SubResultForm>();
		try {
			listResults.stream().forEach(setOfResults -> {

				setOfResults.stream().forEach(itestResult -> {
					SubResultForm sub = new SubResultForm();
					sub.setMethodName(itestResult.getMethod().getMethodName().toString());
					sub.setClassName(itestResult.getTestClass().getName());
					sub.setStatus(itestResult.getStatus());
					if (itestResult.getThrowable() != null)
						sub.setException(itestResult.getThrowable().toString());
					listOfSubResult.add(sub);
				});
			});

		} catch (Exception exp) {
			logger.error("ERROR ResultDao getPassedTests:" + exp);
		}
		return listOfSubResult;
	}

	public ResultForm prepareToSaveResult(ITestContext testContext) {

		ResultForm resultForm = new ResultForm();
		try {
			List<Set<ITestResult>> listResults = new ArrayList<Set<ITestResult>>();
			listResults.add(testContext.getPassedTests().getAllResults());
			listResults.add(testContext.getFailedTests().getAllResults());
			listResults.add(testContext.getFailedTests().getAllResults());
			List<SubResultForm> listOfSubResult = formResults(listResults);
			
			resultForm.setSubResultForm(listOfSubResult);

			String suiteName = testContext.getSuite().getName().trim();
			String groupName = testContext.getName().trim();

			updateStatus(suiteName,STATUS.COMPLETED.toString());
			resultForm.setStartDate(testContext.getStartDate().toInstant());
			resultForm.setEndDate(testContext.getEndDate().toInstant());
			resultForm.setSuiteName(suiteName);
			resultForm.setGroupName(groupName);

		} catch (Exception exp) {
			logger.error(" ResultForm prepareToSaveResult :: " + exp);
		}
		return resultForm;

	}

	public static boolean saveResults(ITestContext testContext) {
		try {
			ResultSeleniumDao resultSeleniumDao = new ResultSeleniumDao();
			Class<DbTemplateCfg> regclass = DbTemplateCfg.class;
			ApplicationContext ctx = SpringAnnotationAppConfigContextInterface.getAnnotationConfig(regclass);
			MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
			ResultForm resultForm = resultSeleniumDao.prepareToSaveResult(testContext);
			mongoTemplate.save(resultForm);
		} catch (Exception exp) {
			logger.error("Exception ResultSeleniumDao " + exp);
		}
		return true;
	}

	public List<ResultForm> getResults() {
		List<ResultForm> resultForm = null;
		try {
			Class<DbTemplateCfg> regclass = DbTemplateCfg.class;
			ApplicationContext ctx = SpringAnnotationAppConfigContextInterface.getAnnotationConfig(regclass);
			MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
			resultForm = (List<ResultForm>) mongoTemplate.findAll(ResultForm.class);
			logger.info("RESULTS :: " + resultForm.toString());
		} catch (Exception exp) {
			logger.error("public ResultForm getResults() .. " + exp);
		}
		return resultForm;
	}

	/*public static boolean updateTestCasesFormSubmit(String groupname, String suiteName) {
		try {
			Class<DbTemplateCfg> regclass = DbTemplateCfg.class;
			ApplicationContext ctx = SpringAnnotationAppConfigContextInterface.getAnnotationConfig(regclass);
			MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
			Update update = new Update();
			update.set("status", STATUS.COMPLETED);
			mongoTemplate.updateMulti(
					query(where("groupName").is(groupname).and("testCasesFormlist.pageActionName").is(suiteName)),
					update, TestCasesFormSubmit.class);
		} catch (Exception exp) {
			logger.error(" ResultSelenium failed to update ::  :::  :::: " + exp);
		}
		return true;
	}*/
	
	public static boolean updateStatus(String suiteName,String status) {
		try {
			Class<DbTemplateCfg> regclass = DbTemplateCfg.class;
			ApplicationContext ctx = SpringAnnotationAppConfigContextInterface.getAnnotationConfig(regclass);
			MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
			Update update = new Update();
			update.set("status", status);
			mongoTemplate.updateMulti(
					query(where("groupName").is(suiteName)),
					update, TestCasesFormSubmit.class);
		} catch (Exception exp) {
			logger.error(" ResultSelenium failed to update ::  :::  :::: " + exp);
		}
		return true;
	}

	
}
