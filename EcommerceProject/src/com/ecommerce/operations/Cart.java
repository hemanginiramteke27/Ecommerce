package com.ecommerce.operations;


public class Cart {
	
	
	private ProductAddToCart[] cart;
	private int productCount;
	private double totalPrice;
	private String pName;
	
   
	@Override
	public String toString() {
		return "Cart [productCount=" + productCount + ", totalPrice=" + totalPrice + ", pName=" + pName + "]";
	}

	private int capacity;
	

	public Cart() {
		
		capacity=10;
	    cart = new ProductAddToCart[capacity];
		productCount=0;
		totalPrice=0.0;
	}
	
	
	public void addToCart(String pName,double pPrice,int quantity) {
		ProductAddToCart temp=new ProductAddToCart(pName,pPrice,quantity);
		totalPrice+=(pPrice*quantity);
		productCount+=quantity;
		if(productCount==capacity) {
			increaseSize();
		}
	}
	
	private void increaseSize() {
		ProductAddToCart[] temp=new ProductAddToCart[capacity+10];
		for(int i=0;i<capacity;i++) {
			temp[i] = cart[i];
		}
		cart=temp;
		temp=null;
		}
	
    }

