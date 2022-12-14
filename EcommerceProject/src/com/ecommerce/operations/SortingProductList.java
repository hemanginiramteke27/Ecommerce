package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.connection.JdbcConnection;

public class SortingProductList {
	
	PreparedStatement prs = null;
	 Connection con = null;
	
	
	public void sortProduct() {
		
		try {
			JdbcConnection op = new JdbcConnection();
			 con =op.getConnectionData();
			
		
			
		   prs = con.prepareStatement("select * from product order by pid");
			
			ResultSet rss = prs.executeQuery();
			while(rss.next()) {
				Thread.sleep(400);
				
				
				System.out.println("ID: "+rss.getInt(1));
				System.out.println("Product ID: "+rss.getInt(2));
				System.out.println("Product Description: "+rss.getString(3));
				System.out.println("ProductPrice: "+rss.getInt(4));
				
				System.out.println("Product Name: "+rss.getString(5));
				int h = rss.getInt(6);
				if (h <= 0) {
					System.out.println("Quantity: "+ 0);
				}else {
				System.out.println("Quantity: "+ h);
				}
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("  ");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}

	}
	
	
}
