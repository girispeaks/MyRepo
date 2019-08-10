package com.testng.tests2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("C:\\Users\\gramakrishn6\\workspace\\Sample\\src\\objectProp.properties");
		FileInputStream ip=new FileInputStream(f);
		Properties p=new Properties();
		p.load(ip);
		System.out.println(p.getProperty("City"));
	}

}
