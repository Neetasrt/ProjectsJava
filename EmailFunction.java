package com.project.practice;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFunction {
	 static String domain;
	 Scanner sc = new Scanner(System.in); 
	
	 //method to create  a List of Employees' Email Addresses
	public  String[] createList() throws InputMismatchException {
		
			System.out.println("\nEnter the Number of Employees to Create E-mail List:");
			
			
				String list[]= new String[sc.nextInt()];
				
					for(int i=0;i<=list.length-1;i++) {
						System.out.println("Enter Email address:\n"+(i+1)+".");
						String input= sc.next();
							if( verifyPattern(input)) {
								list[i]= input;
							}
							else {
								System.out.println("\t**Enter a Valid Email-address");
								i--;
							}
					}
				return list;
			}

//method to verify patterns--for domain and user-name
	public static  boolean verifyPattern(String email) {
		
		String emailex= "^[a-zA-z0-9-_]+[@][a-zA-Z]+[.][a-zA-Z]{2,3}$";	//pattern defined for user-name
		
		Pattern p= Pattern.compile(emailex);
		Matcher m= p.matcher(email);
		return m.matches();
		}
			
	//method to allow user to continue. exit on choice
	public  boolean continueFlag() {
		
			System.out.println("\n Press Y to Continue...\n Any other key to Exit.");
			char option= sc.next().charAt(0);
			if(option=='y' ||option=='Y') {
				
				return true;
			}
			else {
				
				System.out.println("\t**Thank you!!**");
				
				return false;
				}
		}
		
	
	//method to validate a user emailId in the entered list
public  void validateEmail(String email, String[] list) {
	if(verifyPattern(email)==true) {
		
		for(int i=0;i<=list.length-1;i++) {
					
			if(list[i].equalsIgnoreCase(email)==true) {
					
				System.out.println("\tValidated Employee Email: "+  email);
				break;
			}else if(i>=list.length-1)
					System.out.println("\tEmployee Email: '"+email+"' Could not be Validated");
		}
		
	}else 
		System.out.println("\t**Invalid email Address!");
}



}


