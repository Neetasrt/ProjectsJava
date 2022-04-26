package com.practice.project;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
Scanner sc= new Scanner(System.in);
int num1, num2;
char operation;
boolean continueflag=true;


do {
	
System.out.println("\t\t\tCalculator App");


System.out.println("Enter the first number");
num1= sc.nextInt();
System.out.println("Enter the second number");
num2= sc.nextInt();

System.out.println("Choose the Operation ");
System.out.println("+ Addition\n- Subtraction\n* Multiplication\n/ Division");
operation= sc.next().charAt(0);

switch(operation) {

case '+':
	
	int result= num1+num2;
	System.out.println("Sum of "+ num1+" and "+ num2+ " = "+result );
	break;
	
case '-':
	
	result= num1-num2;
	System.out.println("Difference of "+ num1+" and "+ num2+ " = "+result );
	break;
case '*':
	

	result= num1*num2;
	System.out.println("Product of "+ num1+" and "+ num2+ " = "+result );
	break;
case '/':
	float resultd= (float)num1/num2;
	System.out.println("Quotient of "+ num1+" and "+ num2+ " = "+resultd );
	if(num2==0)
		System.out.println("\t**Choose a Valid Divisor Next Time**");
	break;
	
default:
	System.out.println("Invalid Option.You May Try Again!!");
	break;
	
}

System.out.println("\nChoose Option\n 1. Continue\n 2. Exit");
int option= sc.nextInt();
		switch(option) {
		
		case 1:
			break;
		case 2: 
			System.out.println("Thank You for Using My Simple Calculator App!!");
			continueflag=false;
			break;
			
		default:
			continueflag=false;
			System.out.println("Invalid Option. Start Again!!");
			break;
		}

}while(continueflag==true);

sc.close();
	}
	
		

}
