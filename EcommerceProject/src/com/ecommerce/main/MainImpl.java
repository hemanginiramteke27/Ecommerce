package com.ecommerce.main;

import java.util.Scanner;

import com.ecommerce.operations.UserRegitration;



public class MainImpl implements Main {

	


public void platform() {
	UserRegitration user = new UserRegitration();
	
	
	try {
		Thread.sleep(500);
		System.out.println("**********************************************************************************************************************************************************************");
		Thread.sleep(500);
		System.out.print("                                                     U");
		
		Thread.sleep(500);
		System.out.print("K");
		Thread.sleep(500);
		System.out.print("A");
		Thread.sleep(500);
		System.out.print("R");
		Thread.sleep(500);
		System.out.println("T");
		Thread.sleep(500);
		System.out.println("**********************************************************************************************************************************************************************");
		Thread.sleep(1000);
		System.out.println("------------------------------------------******Welcome to Ukart******-----------------------------------------------------");
				
	System.out.println("\n                                       1. New User Registration");
	System.out.println("\n                                       2. Login");
	System.out.println("\n                                       3. Admin login");
	System.out.println("\n                                       4. Exit");
	Scanner sc = new  Scanner(System.in);
	
	System.out.println("\n Enter your choice : ");
	int i = sc.nextInt();
	
	switch(i) {
	case 1 : user.getRegister();
	break;
	case 2 : user.loginUser();
	break;
	case 3 : user.loginAdmin();
	
	}
	


} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

public static void main(String[] args) {
	MainImpl mn = new MainImpl();
	mn.platform();
}

}
