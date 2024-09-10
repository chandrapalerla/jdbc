package com.jdbcexample;

import java.util.List;

import com.jdbcexample.beans.PaymentBean;
import com.jdbcexample.service.PayamentService;
import com.jdbcexample.service.PaymentServeiceImpl;

public class JdbcExample {
	public static void main(String[] args) {
		System.out.println("welcome to jdbc connectivity");
		PayamentService service = new PaymentServeiceImpl();
		List<PaymentBean> paymentDetails = service.getPaymentDetails();
		System.out.println(paymentDetails.toString());
		for (PaymentBean paymentBean : paymentDetails) {
			if(paymentBean.getPaymentId()==1) {
				String name = paymentBean.getPayername();
				System.out.println(name);
			}
			
		}
	}
}
