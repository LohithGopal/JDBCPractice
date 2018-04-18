package com.tech.ninza.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.tech.ninza.jdbc.util.JdbcUtil;

public class JDBCStoredProcedure {

	public static String sp = "{ call getProductByProductId (?, ?, ?, ?)}"; 
	
	public static void main(String[] args) throws SQLException {
		
		int productId = 10;
		try {
			Connection conn = JdbcUtil.getConnection();
			CallableStatement cstmt = conn.prepareCall(sp);
	
			cstmt.setInt(1, productId);
			
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
			String productName = cstmt.getString(2);
			String color = cstmt.getString(3);
			String material = cstmt.getString(4);
			
			
			System.out.println("After Execution of SP");
			System.out.println("Product Name: "+ productName + " Color: "+ color + " Material: " + material);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close();
		}
		
		
	}

}
