package com.tech.ninza.jdbc;

import java.sql.*;


public class JdbcEx {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:SYSTEM/SYSTEM@localhost:1521:productcatal", "system", "Password123" );
			
			Statement stmt=conn.createStatement(); 
			
			ResultSet rs=stmt.executeQuery("select * from product");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			  
			stmt.close();
			conn.close();  
			  
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
