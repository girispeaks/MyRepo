package com.selcukesfw.stepimplementations;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import com.selcukesfw.utilities.WebUtils;
import com.selcukesfw.utilities.XMLUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebServicesStepImplementations {
	XMLConfiguration wsConfig;
	/*
	@Given("I post \"([^\"]*)\" request to \"([^\"]*)\" Web Service method and save Response as \"([^\"]*)\"")
	public void callWS(String requestXMLFileName, String wsMethod, String responseXMLFileName) throws org.apache.commons.configuration.ConfigurationException {
		try {
			wsConfig = new XMLConfiguration("/configurations/WSConfig.xml");
			WebUtils.setProxies();
			Map<String, String> wsMethodDetails = getCurrentWSMethodDetails(wsMethod);
			System.out.println(wsMethodDetails);
			//REST URL setup
			URL oURL = new URL(wsMethodDetails.get("url"));
			
			//Make connection with REST Service
			HttpURLConnection con = (HttpURLConnection) oURL.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");//content type is xml
			con.setRequestProperty("SOAPAction", 
					"http://www.webserviceX.NET/GetWeather");
			//read request xml from configured path
			String reqXML = readFile(wsConfig.getString("requestFilesPath") + requestXMLFileName);
			System.out.println("reqXML:"+reqXML);
			OutputStream reqStream = con.getOutputStream();
			reqStream.write(reqXML.getBytes());
			InputStream is;
			if (con.getResponseCode() >= 400) {
			    is = con.getErrorStream();
			    String myString = IOUtils.toString(is, "UTF-8");
			    System.out.println("@@@@@@@@@@@2:"+myString);
			}
			//get the response from service
			InputStream resStream = con.getInputStream();
			
			String myString = IOUtils.toString(resStream, "UTF-8");// convert response stream to string
			String response = XMLUtils.getCDataXML(myString);
			System.out.println("Response:"+myString);
			
			XMLUtils.saveXML(response, "responses/" + responseXMLFileName); // save XML into configured Path

		} catch (Exception e) {
//			Assert.fail("exception occurred while connecting to web service. Exception:"+e.getMessage());
			e.printStackTrace();
		}
	}

	public Map<String, String> getCurrentWSMethodDetails(String wsMethod)
			throws org.apache.commons.configuration.ConfigurationException {
		Map<String, String> wsDetailsMap = new HashMap<String, String>();
		
		List<HierarchicalConfiguration> wsMethods = wsConfig.configurationsAt("wsMethod");
		for (HierarchicalConfiguration method : wsMethods) 
		{
			if (method.getString("name").equals(wsMethod)) //consider only current method
			{
				wsDetailsMap.put("type", method.getString("type"));
//				if (method.getString("type").equals("rest")) 
//				{
					wsDetailsMap.put("url", method.getString("url"));
//				}
			}
		}
		System.out.println(wsDetailsMap);
		return wsDetailsMap;
	}

	private static String readFile(String pathname) {
		Scanner scanner = null;
		StringBuilder fileContents = new StringBuilder("");
		try {

			File file = new File(pathname);
			fileContents = new StringBuilder((int) file.length());
			scanner = new Scanner(file);
			String lineSeparator = System.getProperty("line.separator");
			while (scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
		} catch (Exception e) {
			Assert.fail("Request File Not Found");
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return fileContents.toString();
	}

	@Then("I should see \"([^\"]*)\" in \"([^\"]*)\" at \"([^\"]*)\" xpath")
	public void validateResponse(String expectedValue, String responseFileName,
			String xPath) throws ConfigurationException {
		
		String responseString = readFile(wsConfig.getString("responseFilesPath") + responseFileName);
		String actualValueFromXML = XMLUtils.getNodeValue(responseString, xPath);
		if (!expectedValue.equals(actualValueFromXML)) {
			Assert.fail("Actual Value from Response did not match with Expected. (Actual:"+ actualValueFromXML + ")(Expected:" + expectedValue + ")");
		}

	}*/
}
