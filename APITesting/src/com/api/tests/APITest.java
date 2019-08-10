package com.api.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.api.pojo.CreateUserPOJO;
import com.api.webservice.APIMethods;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class APITest {
	Properties prop=null;
	@BeforeClass
	public void init() throws Exception{
		File f=new File("C:\\Users\\gramakrishn6\\workspace\\APITesting\\src\\Resources\\URL.properties");
		FileInputStream ip=new FileInputStream(f);
		prop=new Properties();
		prop.load(ip);
		RestAssured.baseURI="https://reqres.in/api";
	}
	
	@Test
	public void getUsers() throws Exception{
		
		Response resp=APIMethods.getUsers(prop.getProperty("getUserList"),"2");
		String response=resp.asString();
		System.out.println(resp.asString());
		/*System.out.println(resp.getStatusCode());
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getSessionId());
		System.out.println(resp.getHeaders().toString());
		System.out.println(resp.getHeader("Date"));
		if(resp.getStatusCode()==200){
			JSONObject object=new JSONObject(resp.asString());
			JSONArray data=object.getJSONArray("data");
			
			int totalUsers=data.length();
			System.out.println("Total users are "+totalUsers);
			Assert.assertEquals("2", JsonPath.from(response).get("page").toString());
			Assert.assertEquals("3", JsonPath.from(response).get("per_page").toString());
			Assert.assertEquals("12", JsonPath.from(response).get("total").toString());
			Assert.assertEquals("4", JsonPath.from(response).get("total_pages").toString());
			Assert.assertEquals("4", JsonPath.from(response).get("data[0].id").toString());
			Assert.assertEquals("Eve", JsonPath.from(response).get("data[0].first_name").toString());
		}*/
	}
	
	//@Test(dataProvider="getData")
	public void postUser(String name, String job){
		CreateUserPOJO user=new CreateUserPOJO();
		user.setName(name);
		user.setJob(job);
		JSONObject object=new JSONObject(user); // Marshelling or Serialization
		Response resp=APIMethods.postUser(prop.getProperty("createUser"), object.toString());
		String respBody=resp.asString();
		System.out.println(respBody);
		if(resp.getStatusCode()==200){
			Assert.assertEquals(user.getName(), JsonPath.from(respBody).get("name").toString());
			Assert.assertEquals(user.getJob(), JsonPath.from(respBody).get("job").toString());
		}
		//System.out.println(resp.getHeaders().toString());		
	}
	//@Test
	public void testJson(){
		File f=new File("C:\\Users\\gramakrishn6\\Desktop\\Sample.txt");
		System.out.println(JsonPath.from(f).get("[2].chatRoom").toString());
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		data[0][0]="Ramesh";
		data[0][1]="Manager";
		data[1][0]="Mohan";
		data[1][1]="IT";	
		return data;
	}
}
