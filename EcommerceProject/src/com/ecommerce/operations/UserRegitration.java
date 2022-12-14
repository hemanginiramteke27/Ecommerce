package com.ecommerce.operations;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Scanner;

import com.ecommerce.connection.JdbcConnection;
import com.ecommerce.main.MainImpl;

	public class UserRegitration {
		Scanner sc = new Scanner(System.in);
		PreparedStatement prs = null;
		Connection con = null;
		SortingProductList sort = new SortingProductList();
		ProductDetails pd = new ProductDetails();
		ProductPrice pri = new ProductPrice();
		GetQuantityOfEachProduct get = new GetQuantityOfEachProduct();
		GetRegisteredUser user = new GetRegisteredUser();
		OrderHistory or = new OrderHistory();
		AdminCrud ac= new AdminCrud();
		UpdateQuantity uq = new UpdateQuantity();
		MainImpl mnc = new MainImpl();
		
		public void loginUser() {
			System.out.println("------------Login here------------");

			System.out.println("Username : ");
			String username = sc.next();
			System.out.println("Password : ");
			String password = sc.next();
			try {
				JdbcConnection op = new JdbcConnection();
				con = op.getConnectionData();
				prs = con.prepareStatement("SELECT name,password from users where name=? and password=?");
				prs.setString(1, username);
				prs.setString(2, password);
				ResultSet rec = prs.executeQuery();
				if (rec.next()) {
					Thread.sleep(400);
					System.out.println("------------Login Successful-------------");
					System.out.println(" Ukart ");
					sort.sortProduct();
					System.out.println("1. Add to cart");
					System.out.println("0. Exit");
					System.out.println("Enter choice : ");
					int b = sc.nextInt();
					switch (b) {

					case 1:
						pri.buyingProduct();
						uq.demo();
						break;
					case 0:
						mnc.platform();

					}

				} else {
					System.out.println("Invalid user");
				}
				
			} catch (Exception e) {
				e.printStackTrace();

			}
			

		}

		public void loginAdmin() {
			
			System.out.println("------------**Admin name : Ukart**------------");

			System.out.println("Password :");
			String Enterpass = sc.next();

			String password = "ukart@123";
			if (password.contentEquals(Enterpass)) {
				giveAccess();
				}

			else {
				System.out.println("Restricted Access ....please provide valid password");
				loginAdmin();
			}
		}

		public void getRegister() {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("User please start Registration >>  " );
			System.out.println(" 1. register " + " 0. Exit" );
			int Customer1 = sc1.nextInt();
			if (Customer1 == 1) {
				while (Customer1 == 1) {

					System.out.println("Enter customer name :");
					String name = sc1.next();

					System.out.println("Enter Password :");
					String password = sc1.next();

					System.out.println("Enter customer mobile number :");
					long mobileNum = sc1.nextLong();

					System.out.println("Enter customer Address :");
					String address = sc1.next();

					insertCustomerData(name, password, mobileNum, address);

					
				}
				System.out.println("Successfully added customer");
				sc.close();
				
			} else if (Customer1 == 0) {

				mnc.platform();
				
			}

		}

		public void insertCustomerData(String name, String password, long mobileNum, String address) {

			try {
				JdbcConnection op = new JdbcConnection();
				con = op.getConnectionData();
				prs = con.prepareStatement("insert into users(name, password, mobileNum, address)values(?,?,?,?)");
				prs.setString(1, name);
				prs.setString(2, password);
				prs.setLong(3, mobileNum);
				prs.setString(4, address);

				int i = prs.executeUpdate();
	          System.out.println("User is succesfully registered");
				
				mnc.platform();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void displayDetails(String name, int password, long mobileNum, String address) {
			System.out.println("------------Details of customer is: ------------");
			System.out.println("Customer name : " + name);
			System.out.println("your password : " + password);
			System.out.println("Customer mobile number : " + mobileNum);
			System.out.println("Cusomer Address :" + address);

		}
		
		public void giveAccess() {
			System.out.println("------------Admin access------------");
			System.out.println("1. Check the quantity ");
			System.out.println("2. Display Registered User List ");
			System.out.println("3. See purchase history ");
			System.out.println("4. Add new product ");
			System.out.println("5. Delete product ");
			System.out.println("6. Update product ");
			System.out.println("7. Display product list ");
			System.out.println("0. Exit ");
			int j = sc.nextInt();
			switch (j) {
			case 1:
				get.quantityOfEachProduct();
				giveAccess();
				break;
			case 2:
				user.registerUserList();
				giveAccess();
				break;
			case 3: 
					or.getPurchaseHistory();
					giveAccess();
				break;
			case 4: pd.insertProduct();
				giveAccess();
				break;
			case 5: ac.deletedata();
				giveAccess();
				break;
			case 6: ac.updatedata();
				giveAccess();
				break;
			case 7: ac.selectdata();
				giveAccess();
			case 0: 
				mnc.platform();
			}
		}

	}

	
	

	
	

