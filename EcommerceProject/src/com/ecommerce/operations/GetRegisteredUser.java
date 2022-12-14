package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.connection.JdbcConnection;

public class GetRegisteredUser {
	
	PreparedStatement prs = null;
	 Connection con = null; 
	 
	public void registerUserList() {
		try {
			JdbcConnection op = new JdbcConnection();
			con= op.getConnectionData();
			
			
			
		 prs= con.prepareStatement("select * from users");
			
			
			ResultSet rs = prs.executeQuery();
		
		
			while(rs.next()) {
					  	System.out.println("******************* Registered Users Data ***************");
					    System.out.println("User Id :"+rs.getInt(1));
						System.out.println("User Name :"+rs.getString(2));
						System.out.println("User Password :" +rs.getString(3));
						System.out.println("User Mobile No: " +rs.getLong(4));
						System.out.println("User Address : " + rs.getString(5));
						
			
			
			}
			
			
			
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	}


}
