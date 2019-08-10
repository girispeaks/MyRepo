package com.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
	
	public void dbconnect() throws Exception{
		String userName="";
		String password="";
		String dburl="<dbtype>://ip:port/db_name"; //"jdbc:mysql://localhost:3306/sonoo"
		
		Class.forName("com.mysql.jdbc.driver");
		Connection con=DriverManager.getConnection(dburl, userName, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from table");
		while(rs.next()){
			String str=rs.getString(0);
		}
		con.close();
	}

}
