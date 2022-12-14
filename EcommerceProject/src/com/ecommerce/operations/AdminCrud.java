package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ecommerce.connection.JdbcConnection;

public class AdminCrud {
ProductPrice pp = new ProductPrice();
	static int i;
		PreparedStatement prs = null;
		 Connection con = null;
	Scanner sc = new Scanner(System.in);	 
		
public void deletedata() {
			try {
				JdbcConnection op = new JdbcConnection();
				 con =op.getConnectionData();
				
				PreparedStatement pst = con.prepareStatement("Delete from product where pid=?");
				System.out.println("Enter PID of product you want delete :");
				int x= sc.nextInt();
				pst.setInt(1,x);
				
				int i= pst.executeUpdate();
				
				System.out.println("Record deleted "+i);
				
				
			}
				catch(Exception e) {
					e.printStackTrace();
					
				}
		}
		public void updatedata() {
		
				try {
				
					JdbcConnection op = new JdbcConnection();
					 con =op.getConnectionData();
				  prs = con.prepareStatement("Update product set pname=?,price=?,pquantity=? where p"
				 		+ "id=?");
				  System.out.println("Enter PID of product you want to update");
				  int a = sc.nextInt();
				  System.out.println("Enter name of product : ");
				  String b = sc.next();
				  System.out.println("Enter price :");
				  int c = sc.nextInt();
				  System.out.println("Enter quantity :");
				  int d = sc.nextInt();
				 
				 
				 prs.setString(1, b);
				 prs.setInt(2, c);
				 prs.setInt(3, d);
				 prs.setInt(4, a);
				 
				 int u = prs.executeUpdate();
				 
				 System.out.println("Data updated successfully");
				 
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}

			}

		public void selectdata() {
			try {
				JdbcConnection op = new JdbcConnection();
				 con =op.getConnectionData();
				
				 prs = con.prepareStatement("Select * from product");
				
				ResultSet r = prs.executeQuery();
				while(r.next()) {
					System.out.println("Product Details : ");
					System.out.println("ID: "+r.getInt(1));
					System.out.println("Product ID: "+r.getInt(2));
					System.out.println("Product Dscription: "+r.getString(3));
					System.out.println("ProductPrice : "+r.getInt(4));
					System.out.println("Product Name: "+r.getString(5));
					System.out.println("Quantity:  "+(r.getInt(6)-pp.qty1));
				}
			}
				catch(Exception e) {
					e.printStackTrace();
				}

			
		}
	}


