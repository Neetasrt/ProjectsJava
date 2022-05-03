package com.practice.project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;



public class FileOperations {
	
	Scanner sc= new Scanner(System.in);
	
	//method to create a new file
	public void createFile(String filename) throws IOException {							
		boolean fileflag;
		File file = new File(filename);
		if(file.createNewFile()) {
				fileflag=true;
				writeToFile(file.getPath(), fileflag);		
			}
		}												
	
	//method to write to a file
	public  void writeToFile(String filepath, boolean fileflag)  {
		
		FileWriter write= null;
		String str;
		Date date = new Date();
	
			try {
				
			if(fileflag==true) {
				write= new FileWriter(filepath, true);
				str =("Created on: "+ date+"\r\n");	
				write.write(str);
				System.out.println("Process successful");
			}else {											//block to append to an existing file
				if(searchFile(filepath)) {
				write= new FileWriter(filepath, true);
					str=("Appended on: "+ date+"\r\n");
					write.write(str);
				System.out.println("Enter the Content to Update: ");
				str= sc.nextLine().concat("\r\n");
				write.write(str);
				System.out.println("Process successful");
				}
				 
				else {
				
					System.out.println("File does not exist"+ filepath);
			}
				
			}
			
			}catch (IOException e) {
				System.out.println("Error: File process incomplete");
				e.printStackTrace();
			}finally {
				
				if (write!= null)
					try {
						write.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			
		}
	
	//method used internally to search a file
	public boolean searchFile(String filename) {
		
		File file= new File(filename);
		if(file.isDirectory()) {
			if(file.list()!=null) {
				System.out.println("'Access Denied' Folder: "+ file.getPath());
				return false;
			}
		}
		if(file.isFile())
			return true;
		else 
			return false;
		}
	
	public void deleteFile(String nameit) throws IOException{	
	
		File file= new File(nameit);
					if(file.isFile()==true) {
						if(file.delete()==true)
						System.out.println("file"+ file.getName()+" is deleted !!");
					}else 
						System.out.println("File not found!!");
			}
			
	// method to read an existing file
	public void readFile(String filename)  {
		FileInputStream stream=null;
		try {
			stream = new FileInputStream(filename);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		int data;
		try {
			
			while((data= stream.read())!=-1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			if (stream!= null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}



	
	
