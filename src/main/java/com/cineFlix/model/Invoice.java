package com.cineFlix.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice implements Comparable<Invoice> {
	
	@Id
	private String transId;
	private Time time;
	private int quantity;
	private int price;
	private int userId;
	private String userName;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTransactionId() {
		return transId;
	}
	public void setTransactionId(String transactionId) {
		this.transId = transactionId;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "InvoiceDTO [transactionId=" + transId + ", time=" + time + ", quantity=" + quantity + ", price="
				+ price + ", userId=" + userId + ", userName=" + userName + "]";
	}
	@Override
	public int compareTo(Invoice o) {
		return this.transId.compareTo(o.transId);
	}
	
	

}
