package com.qa.dec01;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("C:\\Users\\gramakrishn6\\workspace\\Sample\\Resource\\OR.properties");
		FileInputStream ip=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(ip);
		System.out.println(prop.getProperty("firstName_name"));
	}

}
