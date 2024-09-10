package com.jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcexample.connectionconfig.JdbcConnection;

public class UpdateExample {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "update Payment set amount=83866.457 where paymentid=?;";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, 7);
			psmt.execute();
			con.commit();

			String sql1 = "select * from Payment";
			psmt = con.prepareStatement(sql1);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int paymentID = rs.getInt("PAYMENTID");
				String payerName = rs.getString("PAYERNAME");
				String beneName = rs.getString("BENENAME");
				float amount = rs.getFloat("AMOUNT");

				System.out.println("PaymentId::::" + paymentID);
				System.out.println("Payer Name::::" + payerName);
				System.out.println("bene Name:::::" + beneName);
				System.out.println("amount:::::" + amount);
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
