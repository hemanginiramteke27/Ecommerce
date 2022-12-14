package com.ecommerce.operations;

public class ProductAddToCart extends Cart {

	
	 int pid;
		public ProductAddToCart(String pName2, double pPrice2, int quantity2) {
		
	}

		public int getPid() {
			return pid;
		}

		 String pname;
	     double pPrice;
		int quantity;
		
		@Override
		public String toString() {
			return "Product [pname=" + pname + ", pPrice=" + pPrice + ", quantity=" + quantity + "]";
		}

	   public void ProductAddToCart(String pname, double  pPrice2, int quanty) {
			
			this.pname=pname;
			pPrice=pPrice2;
			quantity=quanty;
		}
		
		public String getPname() {
			return pname;
		}

		public double getpPrice() {
			return pPrice;
		}
		
		public int getQuantity() {
			return quantity;
		}
}
