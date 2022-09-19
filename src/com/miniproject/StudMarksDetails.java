package com.miniproject;

import java.sql.*;
import java.util.*;

public class StudMarksDetails extends DataBaseLogic {

	public void getMarks() throws SQLException, ClassNotFoundException {

		Scanner s = new Scanner(System.in);
		System.out.print("\n enter student id");

		int id = s.nextInt();
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from studentinfo where id=" + id);

		if (rs.next() != false) {
			System.out.println("ID: " + rs.getInt(1) + "Name: " + rs.getString(2) + "Marks: " + rs.getInt(3) + "Garde: "
					+ rs.getString(4));
		} else {
			System.err.println("Invalid Student Id");
		}

	}

	public void getRank() throws SQLException, ClassNotFoundException {
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from studentinfo order by marks desc ");
		System.out.println("\n---------Student Ranking-----");
		System.out.print("-----------------------------------");
		System.out.printf("\n |%-5S |%-10S |%-5S |%-5S|", "ID ", "NAME ", "MARKS ", "GRADE ");
		System.out.print("\n---------------------------------");

		while (rs.next()) {
			System.out.printf("\n |%-5d |%-10S |%-5d |%-5S|", rs.getInt(1), rs.getString(2), rs.getInt(3),
					rs.getString(4));
		}

		System.out.print("\n------------------------------------");

	}

}
