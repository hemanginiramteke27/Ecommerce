package com.ecommerce.operations;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ecommerce.connection.JdbcConnection;

public class GetQuantityOfEachProduct {
	ProductPrice prod = new ProductPrice();
	Scanner sc = new Scanner(System.in);
	PreparedStatement prs = null;
	Connection con = null;

	public void quantityOfEachProduct() {
		try {

			
			JdbcConnection op = new JdbcConnection();
			con = op.getConnectionData();
			System.out.println("Enter Product Id :");
			int k= sc.nextInt();

			prs = con.prepareStatement("select * from product where pid=?");
			prs.setInt(1, k);
			ResultSet rs = prs.executeQuery();

			while (rs.next()) {
				Thread.sleep(300);
				System.out.println("PID : >>" + rs.getInt(2) + "  :::: " + "Quantity : >>" + (rs.getInt(6)-prod.qty1));
				
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();

		}
		

	}

}
