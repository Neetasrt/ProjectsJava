package com.project.practice;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EmailValidation {

public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
		EmailFunction function = new EmailFunction();
		
		System.out.println("Creating List of E-mail Address for the Employees");
		
		String list[]=null;
		try {
			list = function.createList();
		
		
		do {	
			System.out.println("Enter the Email address to validate:");
				String email;
				email = sc.next();
				function.validateEmail(email, list);
		
			}while(function.continueFlag());
		
		
		 }catch (InputMismatchException e) {
			System.out.println("Invalid length of List. Start Again!!");
			e.printStackTrace();
			}
		sc.close();
	}

}

