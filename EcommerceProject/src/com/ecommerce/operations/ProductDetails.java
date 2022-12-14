package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ecommerce.connection.JdbcConnection;

public class ProductDetails {
	PreparedStatement prs = null;
	 Connection con = null;
	 
	 public void insertProduct() {
		 try {
			 JdbcConnection op = new JdbcConnection();
			 con =op.getConnectionData();
			 
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Enter PID :");
			 int a = sc.nextInt();
			 System.out.println("Enter Product Description :");
			 String b = sc.next();
			 System.out.println("Enter Price :");
			 int c = sc.nextInt();
			 System.out.println("Enter Product Name :");
			 String d = sc.next();
			 System.out.println("Enter Product Quantity :");
			 int e = sc.nextInt();
			 
			 
			 prs = con.prepareStatement("insert into product(PID ,PDescription,Price,PName,PQuantity) values(?,?,?,?,? )");
			 prs.setInt(1, a);
			 prs.setString(2,b);
			 prs.setInt(3,c);
			 prs.setString(4,d);
			 prs.setInt(5,e);
			 
			 prs.executeUpdate();
			 System.out.println("Data is inserted");
			 
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
}
