package com.testng.tests2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String dburl="< dbtype>://ipaddress:portnumber/db_name"; // dbtype can be oracle or mysql
		String username="";
		String password="";
		//Load jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		//Create connection
		Connection con=DriverManager.getConnection(dburl,username,password);
		//Create Statement object
		Statement st=con.createStatement();
		//execute query
		ResultSet rs=st.executeQuery("");
		while(rs.next()){
			String name=rs.getString(1);//column 1
			String age=rs.getString(2);//column 2
		}
		//closing the connection
		con.close();
	}

}
