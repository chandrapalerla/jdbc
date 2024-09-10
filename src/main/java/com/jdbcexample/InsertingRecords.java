package com.jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbcexample.connectionconfig.JdbcConnection;

public class InsertingRecords {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);

			String sql = "INSERT INTO PAYMENT(PAYMENTID,PAYERNAME,BENENAME,PAYERACCOUNT,BENEACCOUNT,PAYERADDRESS,BENEADDRESS,CURRENCY,AMOUNT)"
					+ "values(7,'komali','kaushik','SBI','AXIS','Nagaram','HYD','EUR',?)";
			psmt = con.prepareStatement(sql);
			psmt.setFloat(1, 8547.74f);
			psmt.execute();
			
			String sql1 = "INSERT INTO PAYMENT(PAYMENTID,PAYERNAME,BENENAME,PAYERACCOUNT,BENEACCOUNT,PAYERADDRESS,BENEADDRESS,CURRENCY,AMOUNT)"
					+ "values(8,'komali','kaushik','SBI','AXIS','Nagaram','HYD',?,?)";
			psmt = con.prepareStatement(sql1);
			psmt.setString(1, "IN");
			psmt.setFloat(2, 14258f);
			psmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.commit();
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
