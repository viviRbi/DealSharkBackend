package com.dealshark.model;

import javax.persistence.*;

@Entity
@Table(name="ORDER_USER")
public class OrderUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	private int orderUserId;  // primary key here
	
	@Column(name="USER_ID", nullable=false, columnDefinition="INT")
	private int userId; // think this is foreign key that goes to user model id
	
	@Column(name="TOTAL_PRICE", nullable=false, columnDefinition="NUMERIC")
	private double totalPrice;

	public OrderUser() {}
	
	public OrderUser(int orderUserId, int userId, double totalPrice) {
		super();
		this.orderUserId = orderUserId;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderUser [orderUserId=" + orderUserId + ", userId=" + userId + ", totalPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderUserId;
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderUser other = (OrderUser) obj;
		if (orderUserId != other.orderUserId)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	


}
