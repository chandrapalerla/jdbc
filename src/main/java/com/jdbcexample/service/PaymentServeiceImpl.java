package com.jdbcexample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcexample.beans.PaymentBean;
import com.jdbcexample.connectionconfig.JdbcConnection;

public class PaymentServeiceImpl implements PayamentService {

	@Override
	public List<PaymentBean> getPaymentDetails() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<PaymentBean> listPayments = new ArrayList<PaymentBean>();
		try {
			con = JdbcConnection.getConnection();
			String sql = "select PAYMENTID, PAYERNAME, BENENAME from Payment;";
			psmt = con.prepareStatement(sql);
			System.out.println(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				PaymentBean bean = new PaymentBean();
				bean.setPaymentId(rs.getInt("PAYMENTID"));
				bean.setPayername(rs.getString("PAYERNAME"));
				bean.setBenename(rs.getString("BENENAME"));
				listPayments.add(bean);
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

		return listPayments;
	}
}
