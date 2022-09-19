package com.miniproject;

import java.sql.*;
import java.util.Scanner;

public class StudentInfo extends DataBaseLogic {

	
	public void getStudentInfo(String userName) throws ClassNotFoundException,SQLException{
		

		
		
		ExamQuestion eq=new ExamQuestion();
		int marks=eq.getQuestion();
		
		String grade;
		if(marks>=8 & marks<=10)
		grade="A";
		
		else if(marks>=6 & marks<=8)
			grade="B";
		
		else if(marks==5)
			grade="C";
		
		else
			grade="Fail";
		
		super.InsertStudInfo(userName, marks,grade);
		
		
		
	}
}
