package com.tech.ninza.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tech.ninza.jdbc.util.JdbcUtil;

public class JdbcInsert {

	public static String insertQuery = "insert into product values (?, ?, ?, ?, ?, ?, ?)";
	public static String deleteQuery = "delete from product where product_id = ?";
	
	public static void main(String[] args) {
		
		try {
			Connection conn = JdbcUtil.getConnection();
			//updateProduct(conn);
			deleteProduct(conn, 100);
			
			JdbcUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	


	public static void updateProduct(Connection conn) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		pstmt.setInt(1, 100);
		pstmt.setFloat(2,(float) 100.11);
		pstmt.setString(3, "Delete This");
		pstmt.setString(4, "Delete this");
		pstmt.setString(5, "Delete this");
		pstmt.setString(6, "Delete this");
		pstmt.setString(7, "Delete this");
		
		int rowsUpdated = pstmt.executeUpdate();
		
		
		System.out.println(rowsUpdated + " Rows Affected");
	}

	private static void deleteProduct(Connection conn, int productId) throws Exception {
	
		PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, productId);
		int rowsUpdated = pstmt.executeUpdate();
		
		System.out.println(rowsUpdated + " Rows Deleted");
	}
	
}
