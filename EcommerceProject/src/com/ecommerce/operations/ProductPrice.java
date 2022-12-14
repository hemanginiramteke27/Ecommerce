package com.ecommerce.operations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

import com.ecommerce.connection.JdbcConnection;

public class ProductPrice {
	OrderHistory or = new OrderHistory();

	int qty1;

	private ProductAddToCart[] cart;

	@Override
	public String toString() {
		return "ProductPrice [cart=" + Arrays.toString(cart) + ", price=" + price + ", qty=" + qty + ", sum=" + sum
				+ "]";
	}

	int pid = 0;
	long price = 0;
	int qty = 0;
	long sum = 0;
	String pName = null;
	PreparedStatement prs = null;
	Connection con = null;

	public void getPrice() {

		try {
			JdbcConnection op = new JdbcConnection();
			con = op.getConnectionData();
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter product id :");
			pid = sc.nextInt();
			System.out.println("Quantity : ");
			qty1 = sc.nextInt();
			if (qty1 <= 0 || qty1 > 10) {
				System.out.println("Unavailable product");
				getPrice();
			}

			prs = con.prepareStatement("select * from product where PID=?");
			prs.setInt(1, pid);

			ResultSet rs = prs.executeQuery();

			while (rs.next()) {
				price = rs.getInt(4);
				qty = (rs.getInt(6));
				if (qty<= 0 || qty > 10) {
					System.out.println("Unavailable product");
					//getPrice();
				}else {
				
				System.out.println();
				pName = rs.getString(5);
				sum += price * qty1;
				Thread.sleep(500);

				System.out.println(
						"Selected Product  : " + pName + "\nQuantity : " + qty1 + "\nPrice of product : " + price);

				System.out.println("  ====================  ");

			}
			Thread.sleep(800);
			System.out.println("              ********************                ");
			Thread.sleep(500);
			System.out.println("Total amount is : " + sum);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		or.insertOrder(pid, pName, price, qty1, sum);
        //or.getOrder( pid);
	}

	public void buyingProduct() {

		String keepShopping = "y";

		do {
			getPrice();

			System.out.println("Continue Shopping(y/n)?");
			Scanner sc = new Scanner(System.in);
			keepShopping = sc.next();

		}

		while (keepShopping.equals("y"));

		System.out.println("Do you want to buy the product: y/n");
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		if (c.equals("y")) {

			System.out.println("Your order is placed Succesfully");

			System.out.println("Do you want to see your purchse history : y/n");
			String d = sc.next();
			if (d.equals("y")) {
				or.getOrder(pid);
				System.out.println("Thankyou");
				System.out.println("Please visit again");
				System.out.println("Happy Shopping!!!!!!!!!!!!!!!!!!!!!");
				
			} else {
				System.out.println("Thankyou");
				System.out.println("Please visit again");
				System.out.println("Happy Shopping!!!!!!!!!!!!!!!!!!!!!");
			}

		} else {
			System.out.println("Your order in cart is :");
			System.out.println("Product name: " + pName);
			System.out.println("Price: " + price);
			System.out.println("Qyantity: " + qty);

		}

	}
}

