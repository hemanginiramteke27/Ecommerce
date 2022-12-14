package com.ecommerce.operations;


import java.util.ArrayList;
import java.util.Scanner;

public class BuyProduct {

	public void buyProduct() {

	SortingProductList s=new SortingProductList();
	
	ArrayList<ProductAddToCart> cart=new ArrayList<ProductAddToCart>();
	ProductAddToCart product;
	String pName;
	int pPrice;
	int quantity;
	
	Scanner sc=new Scanner(System.in);
	String keepShopping="y";
	
	
	do {
		
		
		System.out.println("Continue Shopping(y/n)?");
		keepShopping=sc.next();
		
	}
	while(keepShopping.equals("y"));
}
	}


