package com.tech.ninza.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tech.ninza.jdbc.util.JdbcUtil;

public class JDBCResultSet {
	public static String query = "select * from Employee";
	
	public static void main(String[] args) {
		
		Connection conn;
		try {
		conn = JdbcUtil.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(query);
				
		ResultSet rs = pstmt.executeQuery();
		
		System.out.println("After Execution of Query");

		while( rs.next()){
		String productName = rs.getString(1);
		String color = rs.getString(2);
		String material = rs.getString(3);
		
		System.out.println("Product Name: "+ productName + " Color: "+ color + " Material: " + material);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
