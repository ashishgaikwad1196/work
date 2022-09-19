package com.miniproject;

import java.sql.*;
import java.util.Scanner;

public class Start {
	
	
		
		public void start (String userName)throws  SQLException, ClassNotFoundException {
			Scanner sc=new Scanner(System.in);
			
			StudentInfo si=new StudentInfo();
			StudMarksDetails smd=new StudMarksDetails();
			
			
			boolean flag=true;
			
			while(flag) {
			System.out.println("\n-----------DASHBOARD------------\n");
			System.out.println("1.Give Test");
			System.out.println("2.View Result");
			System.out.println("3.Rank");
			System.out.println("0.Logout");
			System.out.println("Select Option");
			
			int ch=sc.nextInt();
			
			switch(ch) {
			
			case 1:
				si.getStudentInfo(userName);
				break;
			case 2:
				smd.getMarks();
				break;
			case 3:
				smd.getRank();
				System.out.println("\n");
				break;
			case 0:
				flag=false;
				break;
			
			}
				
			
		}
	}

}
