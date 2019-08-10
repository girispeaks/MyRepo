package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("C:\\Users\\gramakrishn6\\workspace\\Practice\\src\\Resource\\OR.properties");
		FileInputStream ip=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(ip);
		System.out.println(prop.getProperty("name"));	
	}
}
