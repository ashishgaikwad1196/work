package com.miniproject;

import java.sql.*;
import java.util.Scanner;


public class MainMethod {
	
 public static void main(String[] args) throws ClassNotFoundException ,SQLException{
	 Login l=new Login();
	 
	  Scanner sc=new Scanner(System.in);
	  String userName;
	  String password;
	 boolean flag=true;
	 
	 while(flag) {
		 System.out.println("\n----- JAVA ONLINE MCQ TEST -----");
		 System.out.println("1.Login");
		 System.out.println("2.Register");
		 System.out.println("0.exit");
		 System.out.print("Select Option : ");
		
		 int ch=sc.nextInt();
		 
		 switch(ch) {
		 case 1:
			System.out.print("\n------- LOGIN -------\n");
			System.out.print("Enter userName :  ");
			userName=sc.next();
			
			System.out.print("Enter password :  ");
			password=sc.next();
			
			l.login(userName, password);
			 break;
			 
		 case 2:
				System.out.print("\n------- REGISTER -------\n");
				System.out.print("Enter userName :  ");
				userName=sc.next();
				System.out.print("Enter password :  ");
				password=sc.next();
				
				l.register(userName, password);
			 break;
			 
		 case 0:
			 flag=false;
			 break;
			 
			 default:
				 System.out.println("\nEnter Valid Option");
	 }
	 }
 }
}


