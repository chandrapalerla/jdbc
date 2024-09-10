package com.jdbcexample.beans;

import java.io.Serializable;

public class PaymentBean implements Serializable {

	private static final long serialVersionUID = -5753210085171628735L;

	private int paymentId;

	private String payername;

	private String benename;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayername() {
		return payername;
	}

	public void setPayername(String payername) {
		this.payername = payername;
	}

	public String getBenename() {
		return benename;
	}

	public void setBenename(String benename) {
		this.benename = benename;
	}

	@Override
	public String toString() {
		return "PaymetId::::" +this.getPaymentId()+"  "+"PayerName::::"+this.getPayername()+" "+"Bene Name::::"+this.getBenename();
	}
	
	
		
}
