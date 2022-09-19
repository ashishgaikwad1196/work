package com.miniproject;

import java.sql.*;

public class Login extends DataBaseLogic{
	
	public void login(String userName, String password) throws ClassNotFoundException, SQLException {
		Start s=new Start();
		Connection con=super.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from loginDetails where userName='"+userName+"'");
		if(rs.next()!=false) {
			if(password.equals(rs.getString(3))) {
				System.out.println("Login Successfully Completed........");
				s.start(userName);
			}
			else {
				System.err.println("\nIncorrect Password  \n");
			}
		}
		else {
				System.err.println("\nUserName Dose Not Exist,please Register first  \n");
			}
		}
		
	
	
	public void register(String userName, String password) throws ClassNotFoundException, SQLException{
		Connection con=super.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from loginDetails where userName='"+userName+"'");
		if(rs.next()!=false) {
			System.err.println("\nUserName Already Exist Please choose Anothor UseName\n");
		}
		
		else {
			ps=con.prepareStatement("insert into loginDetails(userName,password) values (?,?)");
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.executeUpdate();
			con.close();
			ps.close();
			
			System.out.println("\nRegistration successfully complited.......\n");
		}
	}
	
	}

