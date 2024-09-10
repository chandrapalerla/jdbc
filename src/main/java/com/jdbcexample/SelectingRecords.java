package com.jdbcexample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcexample.connectionconfig.JdbcConnection;

public class SelectingRecords {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			String sql = "select * from Payment";
			psmt = con.prepareStatement(sql);
			rs= psmt.executeQuery();
			while (rs.next()) {
				System.out.println("*************Payment Id"+rs.getInt("PAYMENTID")+"***********");
				int paymentID = rs.getInt("PAYMENTID");
				String payerName = rs.getString("PAYERNAME");
				String beneName = rs.getString("BENENAME");
				System.out.println("PaymentId::::" + paymentID);
				System.out.println("Payer Name::::" + payerName);
				System.out.println("bene Name:::::" + beneName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
