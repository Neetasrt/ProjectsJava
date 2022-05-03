package com.practice.project;
import java.io.IOException;
import java.util.Scanner;
import com.reuse.ToContinue;

public class FileMain {

	public static void main(String[] args) {
		FileOperations fileo= new FileOperations();
		
		Scanner sc= new Scanner(System.in);
		ToContinue tc=new ToContinue();
		String filename;	
		String filepath;	
		System.out.println("\t\t**Project File Handling**\n");
		System.out.println("Set the PATH variable");	//To set Path for File Operations
		filepath=sc.next();
		
		
		do {
		System.out.println("Choose the operation:\n1. Create a new File\n2. Write to an existing File\n3.Read a File\n4.Delete a File");
		char operation = sc.next().charAt(0);
		
		switch(operation) {
		case '1':									//create a new file
			System.out.println("Create a New File");
			System.out.println("Enter the filename");
			filename=filepath.concat(sc.next());
			System.out.println(filename);
			try {
				fileo.createFile(filename);
			} catch (IOException e) {
				System.out.println("Error: File process incomplete");
				e.printStackTrace();
			}
		
			break;
			
		case '2':								//Append to a file
			System.out.println("Write to an Existing File");
			System.out.println("Enter the filename");
			filename=filepath.concat(sc.next());
			fileo.writeToFile(filename, false);
			break;
			
		case '3':								//read a file
			System.out.println("Read a File");
			System.out.println("Enter the filename");
			filename=filepath.concat(sc.next());
			
			if(fileo.searchFile(filename))
				fileo.readFile(filename);
			else
				System.out.println("File does not Exist!");
			break;
			
		case '4':								// delete a file
			System.out.println("Delete a File");
			System.out.println("Enter the filename");
			filename=filepath.concat(sc.next());
			
			try {
				fileo.deleteFile(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
		default:
			System.out.println("Invalid Option. Start Again!!");
			break;
		}
		
	}while(tc.continueFlag());
	sc.close();	
}
}
