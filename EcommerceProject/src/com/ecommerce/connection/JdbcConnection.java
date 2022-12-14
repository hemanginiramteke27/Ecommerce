package com.ecommerce.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
Connection con = null;
	
	public Connection getConnectionData() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","root","xyz");
			
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		return con;
	}
}
