package com.miniproject;

import java.sql.*;
import java.util.*;

public class ExamQuestion extends DataBaseLogic {

	public int getQuestion() throws ClassNotFoundException, SQLException {
		
		
int totalmarks=0;
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from quedetails order by rand()");
		while(rs.next()) {// outer while loop is for iterating question
			System.out.println("\n");
			System.out.println(rs.getString(2));
			
			boolean flag=true;
			
			while(flag) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Select option:    ");
				int answer=sc1.nextInt();
				
				if(answer<5 & answer>0) {
					flag=false;
					
					int correctans=rs.getInt(3);
					
					if(answer==correctans) {
						totalmarks=totalmarks+1;
					}
					
				}
				else {
					System.out.println("Invalid option");
				}
				
			}
			
			
		}
	
		return totalmarks;
	}
 
}
