package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_App {

	public static void main(String[] args) {
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/second","root","toor");
			s = con.createStatement();
			
			s.execute("SELECT * FROM EMPLOYEES");
			rs = s.getResultSet();
			System.out.println(rs);
			System.out.println("\n");
			while(rs.next()) {
				System.out.print(rs.getInt(1) + " , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4)+" , "+rs.getInt(5)+" , "+rs.getString(6));
				System.out.println("\n");
			}

			System.out.println("\n");

			rs = s.executeQuery("SELECT * FROM EMPLOYEES where id = 106");
			System.out.println(rs);
			
			while(rs.next()) {
				System.out.print(rs.getInt(1) + " , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4)+" , "+rs.getInt(5)+" , "+rs.getString(6));
			}

			System.out.println("\n");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
