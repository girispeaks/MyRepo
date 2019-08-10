package com.selcukesfw.alm.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
*
* These constants are used throughout the code to set the server to work with.
* To execute this code, change these settings to fit
* those of your server.
*/
public class Constants {
private Constants() {}
static{
	XMLConfiguration envConfig;
	try {
		envConfig = new XMLConfiguration("configurations/environment.xml");
		XMLConfiguration config = new XMLConfiguration("configurations/object-config.xml");
		String environemnt = config.getString("environemnt");
		HOST = envConfig.getString(environemnt+".almHost");
		PORT = envConfig.getString(environemnt+".almPort");
		USERNAME = envConfig.getString(environemnt+".almUsername");
		PASSWORD = envConfig.getString(environemnt+".almPassword");
		DOMAIN = envConfig.getString(environemnt+".almDomain");
		PROJECT = envConfig.getString(environemnt+".almProject");
	} catch (ConfigurationException e) {
		e.printStackTrace();
	}

}
protected static String HOST = "alm.trusted.csc.com";
protected static String PORT = "8080";
protected static String USERNAME = "vbeerakam";
protected static String PASSWORD = "";
protected static String DOMAIN = "DOMAIN";
protected static String PROJECT = "PROJECT";
protected static boolean VERSIONED = false;

}

