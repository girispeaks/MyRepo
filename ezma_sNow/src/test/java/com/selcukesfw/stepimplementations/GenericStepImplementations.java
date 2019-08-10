package com.selcukesfw.stepimplementations;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.naming.ConfigurationException;

import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.primitives.Ints;
import com.selcukesfw.alm.utils.ALMUtils;
import com.selcukesfw.db.utilities.DBUtils;
import com.selcukesfw.utilities.CompareImages;
import com.selcukesfw.utilities.DriverFactory;
import com.selcukesfw.utilities.ElementFactory;
import com.selcukesfw.utilities.WebUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class GenericStepImplementations {

	XMLConfiguration config;
	

	@Before
	public void setUp(Scenario scenario) throws ConfigurationException, org.apache.commons.configuration.ConfigurationException {
		config = new XMLConfiguration("configurations/object-config.xml");
//		if (config.getString("alm_integration") != null && config.getString("alm_integration").equalsIgnoreCase("true")) {
//			Assume.assumeTrue(true);
//		}
	}
/*
	@After
	public void tearDown(Scenario scenario) {
		//below block is to connect to ALM and update the status.
		if (config.getString("alm_integration") != null && config.getString("alm_integration").equalsIgnoreCase("true")) {
			String testCaseNum = ALMUtils.getTestCaseID(scenario.getName());
			String almTestSetId = System.getProperty("almTestSetId");
			System.out.println("almTestSetId:" + almTestSetId);
			System.out.println("Test Status:" + scenario.getStatus());
			System.out.println("ALM Test Case Number:" + testCaseNum);
			if (scenario.getStatus().equalsIgnoreCase("passed")) {
				ALMUtils.setTestCaseStatus(almTestSetId, testCaseNum, "Passed");
			} else {
				ALMUtils.setTestCaseStatus(almTestSetId, testCaseNum, "Failed");
			}
		}
		
		config.clear();
	}
*/
	
	/**
	 * This method puts the execution on hold for given number of seconds.
	 * @param seconds
	 */
	@Then("I wait for \"([^\"]*)\" seconds")
	public void i_wait_for_given_seconds(String seconds) {
		try {
			Thread.sleep(new Long(seconds) * 1000);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method takes the control to a given URL
	 * @param url
	 */
	@Given("I open \"([^\"]*)\" URL in the browser")
	public void i_go_to_URL(String url) {
		try {
			
//			String configuredURL = config.getString(url);
			
			DriverFactory.getDriver().get(url);
			System.err.println(DriverFactory.getDriver().getTitle());
		} catch (Exception e) {
			DriverFactory.getDriver().get(url);
		}
	}
	
	@Given("I go to \"([^\"]*)\" URL later")
	public void i_go_to_URL_later(String url) {
		try {
			String configuredURL = config.getString(url);
			DriverFactory.getDriver().get(configuredURL);
		} catch (Exception e) {
			DriverFactory.getDriver().get(url);
		}
	}

	/* START: Handle Check boxes */

	/**
	 * This method selects(checks) an unselected (unchecked) checkbox
	 * 
	 * @param identifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@Then("I select \"([^\"]*)\" checkbox")
	public void i_select_checkbox(String identifier) {
		if (!ElementFactory.getElement(identifier).isSelected()) {
			ElementFactory.getElement(identifier).click();
		}
	}
	
	// It switches to the mentioned frame
	@Then("I switch to frame \"([^\"]*)\"")
	public void i_switchto_frame(String framename) throws InterruptedException {
		if (!framename.isEmpty() && framename!=null) {
			Thread.sleep(2000);
			DriverFactory.getDriver().switchTo().frame(framename);
		}
	}

	/**
	 * This method unselects (unchecks) a selected (checked) checkbox
	 * 
	 * @param identifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@Then("I unselect \"([^\"]*)\" checkbox")
	public void i_unselect_checkbox(String identifier) {
		if (ElementFactory.getElement(identifier).isSelected()) {
			ElementFactory.getElement(identifier).click();
		}
	}

	/* END: Handle Check boxes */
	
	/* START: Handle Buttons */
	/**
	 * This method clicks on a button based on the HTML identifier provided.
	 * @param buttonIdentifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@And("I click on \"([^\"]*)\" button")
	public void i_click_on_button(String buttonIdentifier) {
		ElementFactory.getElement(buttonIdentifier).click();
	}
	
	@And("I wait for \"([^\"]*)\" element for 2 mins")
	public void i_wait_for_ele(String eleIdentifier) 
	{
		XMLConfiguration config=null;
	try {
		config = new XMLConfiguration("configurations/object-config.xml");
		Method method = By.class.getMethod(config.getString(eleIdentifier + "[@locator]"), String.class);
		By by = (By) method.invoke(By.class, config.getString(eleIdentifier));
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
		catch (Exception e) {
			System.err.println("Object Not found. Please verify if "+eleIdentifier+ " is configered object-config.xml");
			e.printStackTrace();
		} finally{
			config.clear();
		}
	}

	/* End: Handle Buttons */
	
	/* Start: Handle links */
	/**
	 * This method clicks on a hyper link 
	 * @param linkIdentifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@Then("I click on \"([^\"]*)\" link")
	public void i_click_on_link(String linkIdentifier) {
		ElementFactory.getElement(linkIdentifier).click();
	}
	
	/**
	 * This method clicks on a hyper link and focuses on popup window
	 * @param linkIdentifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@Then("I click on \"([^\"]*)\" and switch to popup")
	public void i_click_on_link_and_focus_popup(String linkIdentifier) {
		String parentwindowhandle = DriverFactory.getDriver().getWindowHandle();
		ElementFactory.getElement(linkIdentifier).click();
		WebUtils.switchpopups(parentwindowhandle,DriverFactory.getDriver());
	}	
	@Then("I switch to popup")
	public void switch_to_popup() {
		String parentwindowhandle = DriverFactory.getDriver().getWindowHandle();
		WebUtils.switchpopups(parentwindowhandle,DriverFactory.getDriver());
	}
	
	/* End: Handle links */
	/**
	 * This method clicks on a hyper link 
	 * @param linkIdentifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@Then("I click on \"([^\"]*)\" hyperlink")
	public void i_click_onLink(String linkIdentifier) {
		DriverFactory.getDriver().findElement(By.linkText(linkIdentifier)).click();
		
	}
	
	/* End: Handle links */
	
	/* Start: Handle text boxes */
	/**
	 * This method enters given 'value' into the text box
	 * @param value
	 * @param identifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 */
	@And("I enter \"([^\"]*)\" into \"([^\"]*)\" text field")
	public void i_enter_value_into_textfield(String value, String identifier) {
		ElementFactory.getElement(identifier).clear();
		ElementFactory.getElement(identifier).sendKeys(value);
	}
	
	@Then("I enter current date in \"([^\"]*)\" into \"([^\"]*)\" text field")
	public void enterCurrentDateIntoTextField(String dateFormat, String identifier)
	{
		if(dateFormat.length() > 10)
		{
			Assert.fail("Please enter valid date format. Eg: mm/dd/yyyy");
		}
		//Date format is expected in dd/mm/yyyy or mm/dd/yyyy. dd and yyyy should be lower case. mm could be in upper or lower case.
		dateFormat = dateFormat.replaceAll("mm", "MM");
		String currentDate = new SimpleDateFormat(dateFormat).format(new Date());
		ElementFactory.getElement(identifier).clear();
		ElementFactory.getElement(identifier).sendKeys(currentDate);
	}
	
	@And("I enter \"([^\"]*)\" appended with timestamp into \"([^\"]*)\" text field")
	public void i_enter_value_with_timestamp_into_textfield(String value, String identifier) {
		java.util.Date date= new java.util.Date();
		ElementFactory.getElement(identifier).clear();
		ElementFactory.getElement(identifier).sendKeys(value+date.getTime());
	}
	
	@And("I enter \"([^\"]*)\" into \"([^\"]*)\" field and click tab")
	public void enter_text_field_value_press_tab(String value, String identifier) {
		ElementFactory.getElement(identifier).clear();
		ElementFactory.getElement(identifier).sendKeys(value);
		ElementFactory.getElement(identifier).sendKeys(Keys.TAB);
		
	}
	
	
	@And("I enter \"([^\"]*)\" into \"([^\"]*)\" field and click enter")
	public void enter_text_field_value_press_enter(String value, String identifier) {
		ElementFactory.getElement(identifier).clear();
		ElementFactory.getElement(identifier).sendKeys(value);
		ElementFactory.getElement(identifier).sendKeys(Keys.ENTER);
		
	}
	
	/* End: Handle text boxes */
	
	@Then("I select \"([^\"]*)\" from \"([^\"]*)\" select box")
	public void select_value_from_selectbox(String value, String selectboxIdentifier) throws InterruptedException {
		new Select(ElementFactory.getElement(selectboxIdentifier)).selectByVisibleText(value);
	}
	
	/* Start: Handle Radio Buttons */
	/**
	 * This method takes name and value attributes to select a radio button.
	 * @param value
	 * @param name
	 */
	@And("I select \"([^\"]*)\" radio button for \"([^\"]*)\" field")
	public void i_select_radio_button(String value, String name) {
		final List<WebElement> radios = DriverFactory.getDriver().findElements(By.name(name));
	    for (WebElement radio : radios) {
	        if (radio.getAttribute("value").toLowerCase().equals(value.toLowerCase())) {
	            radio.click();
	        }
	    }
	}
	 
	/* End: Handle Radio Buttons */
	
	/**
	 * This method creates and returns a Selenium WebElement based on the identifier provided.
	 * @param identifier (identifier is calculated based on ObjectIdentityConfig.properties)
	 * @return WebElement
	 */
	public static By getBy(ArrayList<String> objKeySet) {

		By by;
		try {
			Method method = By.class.getMethod(objKeySet.get(0), String.class);
			by = (By) method.invoke(By.class, objKeySet.get(1));
		} catch (Exception NoSuchElementException) {
			return null;
		}
		return by;
	}

	
	@Then("^close browser window$")
	public void close_browser_window() {
		DriverFactory.getDriver().close();
	}
	
	@And("I compare \"([^\"]*)\" image displayed on the web page with \"([^\"]*)\" image")
	public void compare_images(String webUrl, String imageLocalNameExtn) {
		boolean imageMatched = new CompareImages().compareImages(webUrl, imageLocalNameExtn);
		Assert.assertTrue("Images did not match",imageMatched);
	}
	
	@And("I upload \"([^\"]*)\" file into \"([^\"]*)\" field")
	public void upload_file_into_field(String fileCompletePath, String inputFieldIdentifier) {
		ElementFactory.getElement(inputFieldIdentifier).sendKeys(fileCompletePath);
	}

	@And("I should see \"([^\"]*)\" on the page$")
	public void verify_text_matching(String text) {
		String bodyText = DriverFactory.getDriver().findElement(By.tagName("body")).getText();
		Assert.assertTrue("'"+text+"' not found on the page", bodyText.contains(text));
	}
	
	@And("\"([^\"]*)\" should appear on the page$")
	public void verify_text1_matching(String text) {
		String bodyText = DriverFactory.getDriver().findElement(By.tagName("body")).getText();
		Assert.assertTrue("'"+text+"' not found on the page", bodyText.contains(text));
	}
	
	@And("I should not see \"([^\"]*)\" on the page")
	public void verify_text_not_matching(String text) {
		String bodyText = DriverFactory.getDriver().findElement(By.tagName("body")).getText();
		Assert.assertTrue("'"+text+"' not found on the page", (!(bodyText.contains(text))));
	}
	

	
	/**
	 * This method enters the values into multiple text fields
	 * @param seconds
	 */
	@Then("I fill multiple text fields as per below table:$")
	public void fill_multiple_text_feidls(List<Map<String, String>> values) {
		for(Map<String, String> map : values)
		{
			String fieldName = map.get("fieldName");
			String value = map.get("value");
			i_enter_value_into_textfield(value,fieldName);
		}
	}
	
	@Then("I sohuld see \"([^\"]*)\" is disabled")
	public void fieldShouldBeDisabled(String fieldIdentifier){
		Assert.assertTrue(fieldIdentifier+" is expected to be disabled, but it is found enabled", !(ElementFactory.getElement(fieldIdentifier).isEnabled()));
	}
	
	@Then("I sohuld see \"([^\"]*)\" is enabled")
	public void fieldShouldBeEnabled(String fieldIdentifier){
		Assert.assertTrue(fieldIdentifier+" is expected to be enabled, but it is found disabled", ElementFactory.getElement(fieldIdentifier).isEnabled());
	}
	
	@Then("I select below options in \"([^\"]*)\" multi select box")
	public void selectMultipleOptionsFromMultiSelectBox(String multiSelectIdentifier, List<String> options){
		Select selections = new Select(ElementFactory.getElement(multiSelectIdentifier));
		for(String optionValue : options)
		{
			selections.selectByVisibleText(optionValue);
		}
		
	}
	
	@Then("I should see \"([^\"]*)\" table is sorted based on column number \"([^\"]*)\" in \"([^\"]*)\" order$")
	public void checkTableValuesSortedAscending(String tableIdentifier, String columnNumber, String order)
	{
		WebElement table = ElementFactory.getElement(tableIdentifier);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<String> ValuesOfReqdColumn = new ArrayList<String>();
        int columnNum = new Integer(columnNumber) - 1;

        for(int i=1;i<rows.size()-1;i++)
        {
        	WebElement row = rows.get(i);
        	List<WebElement> TDs = row.findElements(By.tagName("td"));
        	if(TDs.size() == 0)
        		continue;
        	WebElement reqColumnElement = TDs.get(columnNum);
        	if(reqColumnElement != null)
        	{
        		ValuesOfReqdColumn.add(reqColumnElement.getText());
        	}
        }
        if(order != null && order.equalsIgnoreCase("descending")){
        	Assert.assertTrue("'"+tableIdentifier+"' table is not sorted in descending order by Column Number:"+columnNumber,!isSorted(ValuesOfReqdColumn));
        }else{
        	Assert.assertTrue("'"+tableIdentifier+"' table is not sorted in ascending order by Column Number:"+columnNumber,isSorted(ValuesOfReqdColumn));
        }
        	
        
	}
	
	public boolean isSorted(List<String> list)
	{
	    boolean sorted = true;        
	    for (int i = 1; i < list.size(); i++) {
	        if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
	    }
	    return sorted;
	}
	/*
	@Then("I compare \"([^\"]*)\" table contents with \"([^\"]*)\" query with below options:")
	public void compareTableDataWithQueryResults(String tableIdentifier, String queryIdentifier, Map<String,String> options)
	{
		
		List<String> stringDBResultRows = DBUtils.getStringResultRows(queryIdentifier);
		
		String ignoreRows = "";
		String ignoreColumns = "";
		if(options != null)
		{
			ignoreRows = options.get("ignore rows");
			ignoreColumns = options.get("ignore columns");
		}
		int[] rowsToIgnore = stringToIntArray(ignoreRows);
		int[] columnsToIgnore = stringToIntArray(ignoreColumns);
		
		WebElement table = ElementFactory.getElement(tableIdentifier);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int j=-1;
		for(int i =0; i<rows.size(); i++)
		{
			j++;
			if(Ints.contains(rowsToIgnore, i+1))
			{
				j--;
				continue;
			}
			String rowUIText = WebUtils.getTableRowAsCommaSeperatedString(rows.get(i), columnsToIgnore);
			String rowDBText = stringDBResultRows.get(j);
			if(!(rowUIText.equalsIgnoreCase(rowDBText)))
			{
				Assert.fail();
			}
		}
	}
	
	private int[] stringToIntArray(String commaSeparatedStringValue)
	{
		String[] items = commaSeparatedStringValue.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		int[] intArray = new int[items.length];

		for (int i = 0; i < items.length; i++) {
		    try {
		    	intArray[i] = Integer.parseInt(items[i]);
		    } catch (NumberFormatException nfe) {};
		}
		return intArray;
	}
	*/
	@Then("I click OK button in popup window")
	public void clickOkOnPopUp()
	{
		DriverFactory.getDriver().switchTo().alert().accept();
	}
	
	
	
	@Then("I switch to default content")
	public void switch_to_default_content() throws InterruptedException
	{
		DriverFactory.getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	
	@And("I validate if \"([^\"]*)\" value exists as \"([^\"]*)\" field in table")
		public void i_validate_field(String expectedfield,String fieldval){
		WebElement field =ElementFactory.getElement(fieldval);
		String fieldvalue = field.getText();
		System.out.println(fieldvalue);
		Assert.assertEquals(expectedfield,fieldvalue);
	}
	
	@And("I validate if \"([^\"]*)\" values exists as \"([^\"]*)\" field in table")
	public void i_validate_exists_field(String expectedfield,String fieldval){
	WebElement field =ElementFactory.getElement(fieldval);
	String fieldvalue=null;
	//for (int i=1;i<=3;i++){
		//WebElement sValue = null;
		//sValue = DriverFactory.getDriver().findElement(By.xpath("field/tr[i]/td[5]/a"));
	fieldvalue = field.getText();
	//}
	System.out.println(fieldvalue);
	Assert.assertEquals(expectedfield,fieldvalue);
}
	
	@And("I validate if \"([^\"]*)\" values exists in table")
	public void i_validate_exists_in_table(String expectedfield){
	String fieldvalue=null;
	for (int i=1;i<=3;i++){
		WebElement sValue = null;
		sValue = DriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr[1]/td[5]/a"));
	fieldvalue = sValue.getText();
	
	System.out.println(fieldvalue);
	Assert.assertEquals(expectedfield,fieldvalue);
	}
}
	
	
	
	
	@And("I validate \"([^\"]*)\" value exists in table")
	public void print_data(String expectedfield){
		 
		 //Get number of rows In table.
		 int Row_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr")).size();
		 //System.out.println("Number Of Rows = "+Row_count);
		 
		 //Get number of columns In table.
		 int Col_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/thead/tr[1]/th")).size();
		 //System.out.println("Number Of Columns = "+Col_count);
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr[";
		 String second_part = "]";
		 String third_part = "/td[5]/a";
		 
		 //Used for loop for number of rows.
		 for (int i=1; i<=Row_count; i++){
			 String final_xpath = first_part+i+second_part+third_part;
			 String Table_data = DriverFactory.getDriver().findElement(By.xpath(final_xpath)).getText();
			 if(expectedfield.equalsIgnoreCase(Table_data)){
			 //Assert.assertEquals(expectedfield,Table_data);
			 System.out.print(" "+Table_data +"  ");
			 }
			 
		 }
		 
	}
	
	
	@And("I compare the saved value exists in table")
	public void compare_saved_value(){
	 
		 //Get number of rows In table.
		 int Row_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr")).size();
	 
		 //Get number of columns In table.
		 int Col_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/thead/tr[1]/th")).size();
		//System.out.println("Number Of Columns = "+Col_count);
		 
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr[";
		 String second_part = "]";
		 String third_part = "/td[";
		 String fourthpart="]";
		
		 //Used for loop for number of rows.
		 boolean printed =false;
		 for (int i=1; i<=Row_count; i++){
			 
			 
				 String firstpath=first_part+i;
				 for (int j=1; j<=Col_count; j++)
				 {
			 String final_xpath = firstpath+second_part+third_part+j+fourthpart;
			 String Table_data = DriverFactory.getDriver().findElement(By.xpath(final_xpath)).getText();
			 //System.out.println(Table_data);
			 if(crqnumber.equalsIgnoreCase(Table_data)){
			 Assert.assertEquals(crqnumber,Table_data);
				 if(!printed ){
			 System.out.print("\n"+" "+Table_data +"  "+"exists in table");
			 printed = true;
			 }
			 }
			 //else if(!expectedfield.equalsIgnoreCase(Table_data))
			 //{
				 //System.out.println("Expected conflict type "+expectedfield+" is not present");
			// }
			 }
		 }
			 
	}
			 
		
	@And("I compare table \"([^\"]*)\" value exists in table")
	public void compare_data(String expectedfield){
	 
		 //Get number of rows In table.
		 int Row_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr")).size();
	 
		 //Get number of columns In table.
		 int Col_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/thead/tr[1]/th")).size();
		 //System.out.println("Number Of Columns = "+Col_count);
		 
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr[";
		 String second_part = "]";
		 String third_part = "/td[";
		 String fourthpart="]";
		
		 //Used for loop for number of rows.
		 boolean printed =false;
		 for (int i=1; i<=Row_count; i++){
			 
			 
				 String firstpath=first_part+i;
				 for (int j=1; j<=Col_count; j++)
				 {
			 String final_xpath = firstpath+second_part+third_part+j+fourthpart;
			 String Table_data = DriverFactory.getDriver().findElement(By.xpath(final_xpath)).getText();
			 //System.out.println(Table_data);
			 if(expectedfield.equalsIgnoreCase(Table_data)){
				 if(!printed ){
			 //Assert.assertEquals(expectedfield,Table_data);
			 System.out.print("\n"+"Conflict "+Table_data +"  " +"is present in table");
			 printed = true;
				 }
			 } 
			 //else if(!expectedfield.equalsIgnoreCase(Table_data))
			 //{
				 //System.out.println("Expected conflict type "+expectedfield+" is not present");
			// }
			 }
			 }
	}
				 
	/*@And("I compare table \"([^\"]*)\" value exists in table")
	public void compare_data(String expectedfield){
		 
		 //Get number of rows In table.
		 int Row_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr")).size();
		 
		 //Get number of columns In table.
		 int Col_count = DriverFactory.getDriver().findElements(By.xpath("/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/thead/tr[1]/th")).size();
		 System.out.println("Number Of Columns = "+Col_count);
		 
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "/html/body/div[2]/form/span[4]/span/div/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/span/div[2]/div[2]/table/tbody/tr/td/div/table/tbody/tr[";
		 String second_part = "]";
		 String third_part = "/td[";
		 String fourthpart="]";
		 
		 //Used for loop for number of rows.
		 
		 for (int i=1; i<=Row_count; i++){
			 
			 
				 String firstpath=first_part+i;
				 for (int j=1; j<=Col_count; j++)
				 {
			 String final_xpath = firstpath+second_part+third_part+j+fourthpart;
			
			 //(Table_data);
			 String Table_data = DriverFactory.getDriver().findElement(By.xpath(final_xpath)).getText();
			 //if(expectedfield.equalsIgnoreCase(Table_data)){
				 //flag=true;
			 try
			 {
				 Assert.assertEquals(expectedfield,Table_data);
				 System.out.print(Table_data +"  ");
				 } 
			 
			 catch (Error e)
			 {
				 System.out.println("Expected conflict type "+expectedfield+" is not present");	
			 }
			 //Assert.assertTrue(flag);
				// }
			 }
		 }
			 		 
			
			 //System.out.println("Expected conflict type "+expectedfield+" is not present");	
			 
		 
		 }*/
		 
	
	
	@And("I compare the \"([^\"]*)\" state with the \"([^\"]*)\" element state")
	public void i_compare_element_state_with(String state,String comparetext) throws InterruptedException{
		
		//WebElement element =ElementFactory.getElement(comparetext);
		Select select = new Select(ElementFactory.getElement(comparetext));
		WebElement option=select.getFirstSelectedOption();
		String strng=option.getText();
	//String strng = element.getText();
	System.out.println("\n"+"Change is now in "+strng+" State");
		Assert.assertEquals(state,strng);
	
	}
	
	//@And("I compard the \"([^\"]*)\" state with the \"([^\"]*)\" element state")
	//public void i_compard_element_state_with(String state,String comparetext) throws InterruptedException{
		
		//WebElement element =ElementFactory.getElement(comparetext);
		//Select select = new Select(ElementFactory.getElement(comparetext));
		//WebElement option=select.getFirstSelectedOption();
		//System.out.println(option);
		//Assert.assertEquals(state,option);
	//}
	
//	@And("I compared the \"([^\"]*)\" state with the \"([^\"]*)\" element state")
	//public void i_compared_element_state_with(String state,String comparetext) throws InterruptedException{
		
		//new Select=ElementFactory.getElement(comparetext).selectByVisibleText("option");
		//WebElement mySelectElm = ElementFactory.getElement(comparetext); 
		//Select mySelect= new Select(mySelectElm);
		//mySelect.selectByVisibleText("Option");
		//String selectedValue = ((Select) mySelectElm).getFirstSelectedOption().getText();
		//System.out.println(selectedValue);
		//new Select(ElementFactory.getElement(comparetext)).selectByVisibleText("option");
		
	//String strng = element.getText(byvi);
	//Select strng = element.selectByVisibleText(comparetext);
	//System.out.println(strng);
		//Assert.assertEquals(state,selectedValue);
	
	//}
	
	@And("I store the \"([^\"]*)\" and place in field")
	public void i_store_and_place_in_field(String Changenumber) {
		
		WebElement element1 =ElementFactory.getElement(Changenumber);
		 crqnumber=element1.getAttribute("value");
		System.out.println(crqnumber);

	}
	
	@And("I store the \"([^\"]*)\" and place in \"([^\"]*)\" field")
	public void i_store_and_place_in_field(String Changenumber,String strSearchString) {
		
		WebElement element1 =ElementFactory.getElement(Changenumber);
		
		String crqnumber=element1.getAttribute("value");
		System.out.println(crqnumber);
		
		WebElement element2 =ElementFactory.getElement(strSearchString);
		element2.sendKeys(crqnumber);
	}
	
	@And("I store \"([^\"]*)\" field")
	public  String i_store_field(String Changenumber) {
		
		 
		WebElement element1 =ElementFactory.getElement(Changenumber);
		
		crqnumber=element1.getAttribute("value");
		System.out.println(crqnumber);
		return crqnumber;		
	}
	String crqnumber;
	
	@Then("I search for \"([^\"]*)\" in search field and click enter")
//	@And("I store \"([^\"]*)\" field")
public void i_search_for_CRQ(String strSearchString) {	
		
		WebElement element2 =ElementFactory.getElement(strSearchString);
		
		element2.sendKeys(crqnumber);
		System.out.println(crqnumber);
		ElementFactory.getElement(strSearchString).sendKeys(Keys.ENTER);
	}
	
	static String TargetPopUp;
    @Then("I switch to child window")
    public static void I_SwitchTo_popUpWindow()
    {
           
    for (String WindowId : DriverFactory.getDriver().getWindowHandles()) 
    {
    TargetPopUp= WindowId;
    }

    DriverFactory.getDriver().switchTo().window(TargetPopUp);

    }

    @Then("I Switch to Parent Window")
    public void SwitchToParentWindow() throws InterruptedException{
    Set<String> WindowId=DriverFactory.getDriver().getWindowHandles();
    //System.out.println("Number of windows open: "+WindowId.size());
    Iterator itr = WindowId.iterator();
    String parentwindow = null;
    while(itr.hasNext())
    {
           parentwindow = itr.next().toString();
           System.out.println("aaa: "+parentwindow);
    }
    DriverFactory.getDriver().switchTo().window(parentwindow);
           Thread.sleep(5000);
           System.out.println("window title: "+DriverFactory.getDriver().getTitle());
           
    }
    
    @Then("I click on \"([^\"]*)\" element")
    public void i_click_onelement(String elementidentifier) {
           DriverFactory.getDriver().findElement(By.id(elementidentifier)).click();
    }
    
 


    
    @Then("I select below value in \"([^\"]*)\" dropdown")
    public void selectvalueFromdropdown(String value, List<String> options){
           Select selections = new Select(ElementFactory.getElement(value));
           for(String optionValue : options)
           {
                  selections.selectByVisibleText(optionValue);
           }
           
    }
    
    @Then("I select \"([^\"]*)\" from \"([^\"]*)\" dropdown")
    public void select_from_dropdown(String value, String option){
    	Select mySelect= new Select(ElementFactory.getElement(value));
    	mySelect.selectByVisibleText(option);
    }
    
    
 @And("I compare the \"([^\"]*)\" startdate with the \"([^\"]*)\" enddate")
 public void i_compare_startdate_with(String startdate,String comparedate) throws InterruptedException{
        
        WebElement element =ElementFactory.getElement(comparedate);
        
 String strng = element.getText();
 System.out.println(strng);
        Assert.assertEquals(startdate,strng);
        
 }
 
 @Then("I save \"([^\"]*)\" field value element")
 public String i_store_fieldvalueelement(String AssigneeField) {
        
        
        WebElement element12 =ElementFactory.getElement(AssigneeField);
        
        assignee=element12.getAttribute("value");
        
        System.out.println(assignee);
        return assignee; 
        //System.out.println(assignee);
 }
 String assignee;

 @Then("I enter \"([^\"]*)\" value saved in search field element and click enter")

public void i_search_for_valueelement(String Assigneevalue) { 
        
        WebElement element13 =ElementFactory.getElement(Assigneevalue);
        
        element13.sendKeys(assignee);
       
        ElementFactory.getElement(Assigneevalue).sendKeys(Keys.ENTER);
 }
 /*
 @Then("I search for \"([^\"]*)\" value saved in search field element and click enter")

public void i_search_for_savedassignee(String Assigneevalue) { 
        
        WebElement element13 =ElementFactory.getElement(Assigneevalue);
        
        element13.sendKeys(assignee);
       
        ElementFactory.getElement(Assigneevalue).sendKeys(Keys.ENTER);
 }
 */

	@And("I store \"([^\"]*)\" CRQfield of copychange")
    public String i_store_CRQfield(String Requestnumber) {
                    
                    
                    WebElement element31 =ElementFactory.getElement(Requestnumber);
                    
                    CRQ=element31.getAttribute("value");
                    System.out.println(CRQ);
                    return CRQ;                          
    }
    String CRQ;
    
    @Then("I search for \"([^\"]*)\" in CRQsearch field and click enter")
        public void i_search_for_CRQ2(String SearchString) {   
                    
                    WebElement element32 =ElementFactory.getElement(SearchString);
                    
                    element32.sendKeys(CRQ);
                    System.out.println(CRQ);
                    ElementFactory.getElement(SearchString).sendKeys(Keys.ENTER);
    }
    
    @Then("I increment \"([^\"]*)\" days in \"([^\"]*)\" field") 

	public void i_increment_days(int increday,String datePicker){
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String PST = df.format(today);
		System.out.println(PST+" PST Timing");
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_YEAR, increday); 
		Date tomorrow = cal.getTime();
		String dayAfterTmr = df.format(tomorrow);
		//System.out.println(dayAfterTmr+" day after tommorow");      

		ElementFactory.getElement(datePicker).sendKeys(dayAfterTmr);
}



	@Then("I clear dates and increment \"([^\"]*)\" days in \"([^\"]*)\" field") 

	public void i_clear_dates_increment_day(int increday,String datePicker){
    ElementFactory.getElement(datePicker).clear();
    Date today = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
    String PST = df.format(today);
    System.out.println(PST+" PST Timing");
    Calendar cal = Calendar.getInstance();
    cal.setTime(today);
    cal.add(Calendar.DAY_OF_YEAR, increday); 
    Date tomorrow = cal.getTime();
    String futuPlannedDate = df.format(tomorrow);
    //System.out.println(futuPlannedDate+" day after tommorow");      

    ElementFactory.getElement(datePicker).sendKeys(futuPlannedDate);
    
}

	@Then ("I enter PST time zone in \"([^\"]*)\" datepicker")
	   public static void i_enter_pst_time_zone(String datePicker){
		   dateCreation DD = new dateCreation();
	     ElementFactory.getElement(datePicker).sendKeys(DD.dates());
	   }

	@Then("I save \"([^\"]*)\" requestdate field value element")
		public String i_save_requestdate_fieldvalueelement(String Requestdate) {
			WebElement element41 =ElementFactory.getElement(Requestdate);
			request=element41.getAttribute("value");
			//System.out.println(assignee);
			return request;          
}
String request;

	@Then("I enter same PST date in \"([^\"]*)\" field")
		public void i_enter_same_date(String Searchrequest){
			WebElement element42 =ElementFactory.getElement(Searchrequest);
			element42.sendKeys(request);
			//System.out.println(request);
			ElementFactory.getElement(Searchrequest).sendKeys(Keys.ENTER);
}
	
//	@Then ("I enter planned start future date in \"([^\"]*)\" datepicker")
//		public static void i_enter_start_future_date(String datePicker){
//			dateCreation FD = new dateCreation();
//			ElementFactory.getElement(datePicker).sendKeys(FD.dayAfterStart());
//	}

	@Then ("I enter future date in \"([^\"]*)\" datepicker")
	public static void i_enter_start_future_date(String datePicker){
		dateCreation FD = new dateCreation();
		ElementFactory.getElement(datePicker).sendKeys(FD.dayAfterStart());
}
	
	@Then("I save \"([^\"]*)\" PlannedStartDate field value element")
		public String i_save_PlannedStartDate_fieldvalueelement(String PlannedStartDate) {
			WebElement element51 =ElementFactory.getElement(PlannedStartDate);
			PlannedStart=element51.getAttribute("value");
			//System.out.println(assignee);
			return PlannedStart;          
}
String PlannedStart;

	@Then("I enter same planned start future date in \"([^\"]*)\" field")
		public void i_enter_same_planned_start_future_date(String PlannedStartrequest){
			WebElement element52 =ElementFactory.getElement(PlannedStartrequest);
			element52.sendKeys(PlannedStart);
			//System.out.println(PlannedStart);
			ElementFactory.getElement(PlannedStartrequest).sendKeys(Keys.ENTER);
}  
    
	@Then("I enter planned end future date in \"([^\"]*)\" field")
		public void i_enter_end_future_date(String datePicker){
			dateCreation ED = new dateCreation();
			ElementFactory.getElement(datePicker).sendKeys(ED.dayAfterEnd());
	}

	@Then("I save \"([^\"]*)\" PlanendDate field value element")
	public String i_save_PlanendDate_fieldvalueelement(String PlannedEndDate) {
		WebElement element61 =ElementFactory.getElement(PlannedEndDate);
		PlannedEnd=element61.getAttribute("value");
		//System.out.println(assignee);
		return PlannedEnd;          
}
String PlannedEnd;

	@Then("I enter same plan end future date in \"([^\"]*)\" field")
		public void i_enter_same_plan_end_future_date(String PlannedEndrequest){
			WebElement element52 =ElementFactory.getElement(PlannedEndrequest);
			element52.sendKeys(PlannedEnd);
			//System.out.println(PlannedEnd);
			ElementFactory.getElement(PlannedEndrequest).sendKeys(Keys.ENTER);
}
 
 
// @Then("I enter current date into \"([^\"]*)\" datepicker")
//
// public void i_enter_current_date_into_datepicker(String Datepicker) { 
//
// DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
// Date date2 = new Date();
//
// String today = dateFormat2.format(date2); 
//System.out.println(today);
// //find the calendar
// WebElement dateWidget =ElementFactory.getElement(Datepicker);
// List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
////By calendarXpath=By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+date+"']");
// //comparing the text of cell with today's date and clicking it.
// for (WebElement cell : columns)
// {
//    if (cell.getText().equals(today))
//    {
//       cell.click();
//       break;
//    }
// }
//
// 
// }
// String PST;
// String dayAfterTmr;
//@Then("I enter PST time zone in \"([^\"]*)\" datepicker") 
//public static void i_enter_time_zone(String datePicker){
//       Date today = new Date();
//    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
//    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//    String PST = df.format(today);
//    System.out.println(PST);
//    ElementFactory.getElement(datePicker).sendKeys(PST);
//  
//}
//@Then("I increment \"([^\"]*)\" days in \"([^\"]*)\" field") 
//
//public void i_increment_days(int increday,String datePicker){
//       Date today = new Date();
//       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
//    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//    String PST = df.format(today);
//    System.out.println(PST+" PST Timing");
//    Calendar cal = Calendar.getInstance();
//    cal.setTime(today);
//    cal.add(Calendar.DAY_OF_YEAR, increday); 
//    Date tomorrow = cal.getTime();
//    String dayAfterTmr = df.format(tomorrow);
//    System.out.println(dayAfterTmr+" day after tommorow");      
//
//    ElementFactory.getElement(datePicker).sendKeys(dayAfterTmr);
//}
//
//
//
////@Then("I clear dates and increment \"([^\"]*)\" days in \"([^\"]*)\" field") 
////
////public void i_clear_dates_increment_day(int increday,String datePicker){
////	ElementFactory.getElement(datePicker).clear();
////       Date today = new Date();
////       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
////    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
////    String PST = df.format(today);
////    System.out.println(PST+" PST Timing");
////    Calendar cal = Calendar.getInstance();
////    cal.setTime(today);
////    cal.add(Calendar.DAY_OF_YEAR, increday); 
////    Date tomorrow = cal.getTime();
////    String dayAfterTmr = df.format(tomorrow);
////    System.out.println(dayAfterTmr+" day after tommorow");      
////
////    ElementFactory.getElement(datePicker).sendKeys(dayAfterTmr);
////}
//
////@Then("I enter same PST time zone in \"([^\"]*)\" datepicker")
////public static void IentersamePSTtimezone(String datePicker){
////     ElementFactory.getElement(datePicker).sendKeys(PST);
//      
//       
//@Then("I clear dates and increment \"([^\"]*)\" days in \"([^\"]*)\" field") 
//
//public void i_clear_dates_increment_day(int increday,String datePicker){
//ElementFactory.getElement(datePicker).clear();
//Date today = new Date();
//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-06-07 03:07:20
//df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//String PST = df.format(today);
//System.out.println(PST+" PST Timing");
//Calendar cal = Calendar.getInstance();
//cal.setTime(today);
//cal.add(Calendar.DAY_OF_YEAR, increday); 
//Date tomorrow = cal.getTime();
//String futuPlannedDate = df.format(tomorrow);
//System.out.println(futuPlannedDate+" day after tommorow");      
//
//ElementFactory.getElement(datePicker).sendKeys(futuPlannedDate);
//
//}
//
//@Then ("I enter PST time zone in \"([^\"]*)\" datepicker")
//   public static void i_enter_pst_time_zone(String datePicker){
//	   dateCreation DD = new dateCreation();
//     ElementFactory.getElement(datePicker).sendKeys(DD.dates());
//   }
//
//@Then("I save \"([^\"]*)\" requestdate field value element")
//	public String i_save_requestdate_fieldvalueelement(String Requestdate) {
//		WebElement element41 =ElementFactory.getElement(Requestdate);
//		request=element41.getAttribute("value");
//		//System.out.println(assignee);
//		return request;          
//}
//String request;
//
//@Then("I enter same PST date in \"([^\"]*)\" field")
//	public void i_enter_same_date(String Searchrequest){
//		WebElement element42 =ElementFactory.getElement(Searchrequest);
//		element42.sendKeys(request);
//		System.out.println(request);
//		ElementFactory.getElement(Searchrequest).sendKeys(Keys.ENTER);
//}
//
//@Then ("I enter planned start future date in \"([^\"]*)\" datepicker")
//	public static void i_enter_start_future_date(String datePicker){
//		dateCreation FD = new dateCreation();
//		ElementFactory.getElement(datePicker).sendKeys(FD.dayAfterStart());
//}
//
//
//@Then("I save \"([^\"]*)\" PlannedStartDate field value element")
//	public String i_save_PlannedStartDate_fieldvalueelement(String PlannedStartDate) {
//		WebElement element51 =ElementFactory.getElement(PlannedStartDate);
//		PlannedStart=element51.getAttribute("value");
//		//System.out.println(assignee);
//		return PlannedStart;          
//}
//String PlannedStart;
//
//@Then("I enter same planned start future date in \"([^\"]*)\" field")
//	public void i_enter_same_planned_start_future_date(String PlannedStartrequest){
//		WebElement element52 =ElementFactory.getElement(PlannedStartrequest);
//		element52.sendKeys(PlannedStart);
//		System.out.println(PlannedStart);
//		ElementFactory.getElement(PlannedStartrequest).sendKeys(Keys.ENTER);
//}  
//
//@Then("I enter planned end future date in \"([^\"]*)\" field")
//	public void i_enter_end_future_date(String datePicker){
//		dateCreation ED = new dateCreation();
//		ElementFactory.getElement(datePicker).sendKeys(ED.dayAfterEnd());
//}
//
//@Then("I save \"([^\"]*)\" PlanendDate field value element")
//public String i_save_PlanendDate_fieldvalueelement(String PlannedEndDate) {
//	WebElement element61 =ElementFactory.getElement(PlannedEndDate);
//	PlannedEnd=element61.getAttribute("value");
//	//System.out.println(assignee);
//	return PlannedEnd;          
//}
//String PlannedEnd;
//
//@Then("I enter same plan end future date in \"([^\"]*)\" field")
//	public void i_enter_same_plan_end_future_date(String PlannedEndrequest){
//		WebElement element52 =ElementFactory.getElement(PlannedEndrequest);
//		element52.sendKeys(PlannedEnd);
//		System.out.println(PlannedEnd);
//		ElementFactory.getElement(PlannedEndrequest).sendKeys(Keys.ENTER);
//}
	
	
}