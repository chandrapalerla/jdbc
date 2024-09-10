package com.jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbcexample.connectionconfig.JdbcConnection;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "CREATE TABLE PAYMENT " + "(PAYMENTID INT PRIMARY KEY     NOT NULL,"
					+ " PAYERNAME           TEXT    NOT NULL, " + " BENENAME           TEXT    NOT NULL, "
					+ " PAYERACCOUNT           TEXT    NOT NULL, " + " BENEACCOUNT           TEXT    NOT NULL, "
					+ " PAYERADDRESS           TEXT    NOT NULL, " + " BENEADDRESS           TEXT    NOT NULL, "
					+ " CURRENCY            TEXT     NOT NULL, " + " AMOUNT        REAL)";
			System.out.println(sql);
			//creatring prepared statement object from connection object and passing sql query
			psmt = con.prepareStatement(sql);
			//execute the psmt objet
			psmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			con.rollback();
			e.printStackTrace();
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
