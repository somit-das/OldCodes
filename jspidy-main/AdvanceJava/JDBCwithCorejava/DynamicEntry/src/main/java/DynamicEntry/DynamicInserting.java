package DynamicEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInserting {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement s = null;
		
		String url = "jdbc:mysql://localhost:3306/second";
		String user = "root";
		String pass = "toor";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id : ");
		int id = sc.nextInt();
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter Salary : ");
		Double sal = sc.nextDouble();
		
		System.out.println("Enter DeptNo : ");
		int dNo = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			s = con.createStatement();
//			int row = s.executeUpdate("INSERT INTO  EMP VALUES("+id+","+name+","+sal+","+dNo+")");
			int row = s.executeUpdate("INSERT INTO  EMP VALUES("+id+",'"+name+"',"+sal+","+dNo+")");
			System.out.println(row + " : Row Affected ...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
