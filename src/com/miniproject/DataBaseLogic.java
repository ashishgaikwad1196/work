package com.miniproject;

import java.sql.*;

public class DataBaseLogic {

	Connection con=null;
	PreparedStatement ps=null;
	
	public Connection getConnection() throws ClassNotFoundException ,SQLException{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void InsertStudInfo(String userName,int marks,String grade)throws  ClassNotFoundException ,SQLException{
		con=this.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from loginDetails where userName='"+userName+"'");
		if(rs.next()!=false) {
			ps=con.prepareStatement("Update studentInfo set marks=? , grade=? where userName=? ");
			ps.setInt(1, marks);
			ps.setString(2, grade);
			ps.setString(3, userName);
			ps.executeUpdate();
			con.close();
			ps.close();
			
			
		}
		else {
		ps=con.prepareStatement("insert into studentInfo(userName  ,marks  ,grade  ) values(?,?,?)");
		
		ps.setString(1, userName);
		ps.setInt(2,marks);
		ps.setString(3, grade);
		ps.executeUpdate();
		con.close();
		ps.close();
		System.out.println("Record inserted successfully...");
		
		
		}
		
	}
	
	
	
}
