package com.ecommerce.operations;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import com.ecommerce.connection.JdbcConnection;

	public class OrderHistory{
		UpdateQuantity uq = new UpdateQuantity();
		PreparedStatement prs = null;
		 Connection con = null;
		public static int e;
		public static int f;
		
		public void getOrder(int pid) {
			try {
				JdbcConnection op = new JdbcConnection();
				 con =op.getConnectionData();
				 prs = con.prepareStatement("select * from pOrder1 where pid=?");
				 prs.setInt(1, pid);
				 ResultSet rss = prs.executeQuery();
			
				    System.out.println("Purchase History : " );
				    while(rss.next()) {
				    	
					System.out.println("Product ID: "+ rss.getInt(1));
					System.out.println("Product Name: "+rss.getString(2));
					System.out.println("ProductPrice: "+rss.getInt(3));
					System.out.println("Quantity: "+ rss.getInt(4));
					System.out.println("Total price :  "+rss.getString(5));
				    }
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void insertOrder(int pid, String pName, long price, int qty1, long sum) {
			try {
				JdbcConnection op = new JdbcConnection();
				 con =op.getConnectionData();
				 prs = con.prepareStatement("insert into pOrder1(PID ,PName,Price,PQuantity,Psum) values(?,?,?,?,? )");
				 prs.setInt(1, pid);
				 prs.setString(2,pName);
				 prs.setLong(3,price);
				 prs.setInt(4,qty1);
				 prs.setLong(5,sum);
				 
				 prs.executeUpdate();
				 uq.selectdata();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	  
		public void getPurchaseHistory() {
			
	try {
				JdbcConnection op = new JdbcConnection();
				con = op.getConnectionData();
				

				prs = con.prepareStatement("select * from porder1");
			
				ResultSet rs = prs.executeQuery();
				System.out.println(" Purchase History");
				while (rs.next()) {
					Thread.sleep(300);
					System.out.println("Product ID: "+rs.getInt(1));
					System.out.println("Product Name: "+rs.getString(2));
					System.out.println("ProductPrice: "+rs.getInt(3));
					System.out.println("ProductQuantity: "+rs.getInt(4));
					System.out.println("Product Sum: "+rs.getString(5));
				}
				

				
			} catch (Exception e) {
				e.printStackTrace();

			}
			
			
		

		
		
			
		}	
		}	
		
		




