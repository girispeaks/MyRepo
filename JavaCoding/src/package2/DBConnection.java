package package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/";
		String driver="com.mysql.jdbc.Driver";
		String dbName="testing";
		String userName="root";
		String password="mypassword";
		
		//connect to database
		//fire queries
		//disconnect. This has to be done. If not it creates problems to open a new connection
		
		try{
			//create an object of driver
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection(url+dbName,userName,password);
			System.out.println(conn.isClosed());
			/******************STATEMENT INTERFACE**********************/
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from EMPLOYEE"); //using Statment interface we cannot right condition(where) in the query
			while(rs.next()){
				System.out.println(rs.getString(1)+"----"+rs.getString(2)+"------"+rs.getString(3));
			}
			//st.executeUpdate("INSERT INTO EMPLOYEE VALUE('ARJUN','MYSORE',35)");//insert, update, delete
			
			/****************PREPARED_STATEMENT INTERFACE****************/
			PreparedStatement pst=conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE PLACE=?");
			pst.setString(1, "MYSORE");
			pst.setInt(2, 35);
			rs=pst.executeQuery();
			System.out.println("--------------------");
			while(rs.next()){
				System.out.println(rs.getString(1)+"----"+rs.getString(2)+"------"+rs.getString(3));
			}
			//pst.executeUpdate("");// insert, update, delete with condition
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if((conn!=null)&&(!conn.isClosed()))
				conn.close();
		}
		System.out.println(conn.isClosed());
		
	}

}
