package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecommerce.connection.JdbcConnection;

public class UpdateQuantity {

	PreparedStatement prs = null;
	Connection con = null;
	static String a, x;
	static int b, y, c, p, l, m, k,v;

	public void selectdata() {
		try {
			JdbcConnection op = new JdbcConnection();
			con = op.getConnectionData();

			prs = con.prepareStatement("Select * from porder1");

			ResultSet r = prs.executeQuery();
			while (r.next()) {

				
				
				
				
				m = r.getInt(4);
				
				v=r.getInt(1);
				
				
				
				product();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void product() {
		try {
			JdbcConnection op = new JdbcConnection();
			con = op.getConnectionData();

			prs = con.prepareStatement("Select * from product where pid=?");
			prs.setInt(1, v);
			ResultSet r = prs.executeQuery();
			while (r.next()) {
				int a = r.getInt(1);
				 
				 b= 	r.getInt(2);
				
				l = r.getInt(6);
				demo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void demo() {

		c = l - m;
		
		


		try {
			JdbcConnection op = new JdbcConnection();
			con = op.getConnectionData();

			prs = con.prepareStatement("Update product set pquantity=? where pid=?");

			prs.setInt(1, c);
			prs.setInt(2, v);

			int u = prs.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}}



