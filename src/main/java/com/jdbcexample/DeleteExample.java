package com.jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbcexample.connectionconfig.JdbcConnection;

public class DeleteExample {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE from Payment where PaymentID = ?;";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, 7);
			psmt.execute();
			con.commit();
		} finally {
			try {
				if (con != null)
					con.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
