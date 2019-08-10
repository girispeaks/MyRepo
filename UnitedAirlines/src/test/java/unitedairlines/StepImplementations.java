package unitedairlines;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import com.service.utils.logger.LoggerUtil;
import com.service.utils.webservices.WebServiceUtil;
import com.service.utils.xml.XmlUtil;
import com.service.utils.db.DBUtil;
import com.service.utils.io.IOUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepImplementations {

	@After
	public void afterScenario(Scenario scenario) {
		LoggerUtil.info(scenario.getName() + ": " + scenario.getStatus());
	}

	@Given("^I create \"([^\"]*)\" WS request with \"([^\"]*)\" test data and save request as \"([^\"]*)\" file$")
	public void createRequest(String methodName, String testReferenceID,
			String reqFileName) {
		try {
			String str = com.service.utils.webservices.WebServiceUtil.createRequest(methodName,
					testReferenceID);
			Assert.assertNotNull(str);
			IOUtil.saveFile(str, reqFileName);
		} catch (Exception e) {
			LoggerUtil.error("Exception while creating REQUEST ...");
		}
	}
	@Then("^I post \"([^\"]*)\" request to \"([^\"]*)\" WS method and save response as \"([^\"]*)\" file$")
	public void postRequest(String reqFileName, String methodName,
			String resFileName) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + reqFileName);
			String str = WebServiceUtil.postRequest(methodName,
					FileUtils.readFileToString(file));
			Assert.assertNotNull(str);
			IOUtil.saveFile(str, resFileName);
		} catch (Exception e) {
			LoggerUtil.error("Exception while posting REQUEST ...");
		}
	}
	@Then("^I verify If \"([^\"]*)\" exists in \"([^\"]*)\" response in \"([^\"]*)\" tag$")
	public void validateResponse(String value, String fileName, String tagXPath) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			Assert.assertTrue(XmlUtil.getElementValue(
					FileUtils.readFileToString(file), tagXPath).contains(value));
		} catch (Exception e) {
			LoggerUtil.error("Exception while posting REQUEST ...");
		}
	}
	@Then("^I verify \"([^\"]*)\" test data exists in \"([^\"]*)\" table for below fields$")
	public void validateDatabase(String fileName, String tableName,
			Map<String, String> options) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			String str = FileUtils.readFileToString(file);

			String sqlQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE ";
			int i = 1;

			for (Entry<String, String> entry : options.entrySet()) {
				if (i == 1) {
					sqlQuery = sqlQuery + entry.getKey() + "='"
							+ XmlUtil.getElementValue(str, entry.getValue())
							+ "'";
				} else {
					sqlQuery = sqlQuery + " AND " + entry.getKey() + "='"
							+ XmlUtil.getElementValue(str, entry.getValue())
							+ "'";;
				}
				i++;
			}
			String result = DBUtil.getOracleDBResult("DPSCRUser", sqlQuery);
			LoggerUtil.info("Query Result: " + result);
			Assert.assertEquals("1", result);
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}
	@Then("^I verify If \"([^\"]*)\" exists in \"([^\"]*)\" column in table \"([^\"]*)\" for Message ID \"([^\"]*)\" from \"([^\"]*)\" file$")
	public void validateMessage(String value, String colName, String tableName,
			String tagXPath, String fileName) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			String str = FileUtils.readFileToString(file);
			String sqlQuery = "SELECT COUNT(*) FROM " + tableName
					+ " Where MSG_ID='"
					+ XmlUtil.getElementValue(str, tagXPath) + "' AND "
					+ colName + "='" + value + "'";

			String result = DBUtil.getOracleDBResult("DPSCRUser", sqlQuery);
			LoggerUtil.info("Query Result: " + result);
			Assert.assertEquals("1", result);
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}

	@Then("^I verify If \"([^\"]*)\" not exists in \"([^\"]*)\" column in table \"([^\"]*)\" for Message ID \"([^\"]*)\" from \"([^\"]*)\" file$")
	public void validateMessageNot(String value, String colName,
			String tableName, String tagXPath, String fileName) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			String str = FileUtils.readFileToString(file);
			String sqlQuery = "SELECT COUNT(*) FROM " + tableName
					+ " Where MSG_ID='"
					+ XmlUtil.getElementValue(str, tagXPath) + "' AND "
					+ colName + "='" + value + "'";

			String result = DBUtil.getOracleDBResult("DPSCRUser", sqlQuery);
			LoggerUtil.info("Query Result: " + result);
			Assert.assertNotEquals("1", result);
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}

	@And("^I update \"([^\"]*)\" tag in \"([^\"]*)\" file with ([^\"]*)$")
	public void updateElementTag(String tagXpath, String fileName, String value) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			String str = FileUtils.readFileToString(file);
			str = XmlUtil.setElementValue(str, tagXpath, value);
			FileUtils.writeStringToFile(file, str);
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}

	@Then("^I verify If \"([^\"]*)\" exists in \"([^\"]*)\" response$")
	public void valueExistsInFile(String value, String fileName) {
		try {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(
					(ClassLoader.getSystemClassLoader().getResource(".")
							.getPath().replaceFirst("/", "") + "iofiles/")
							+ dateFormat.format(date) + "/" + fileName);
			String str = FileUtils.readFileToString(file);
			Assert.assertTrue(str.contains(value));
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}

	@Then("^I wait \"([^\"]*)\" seconds$")
	public void wait(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			LoggerUtil.error("Exception: " + e);
		}
	}

}
