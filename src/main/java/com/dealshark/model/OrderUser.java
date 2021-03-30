package com.dealshark.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ORDER_USER")
public class OrderUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderUserSequence")
	@SequenceGenerator(name="orderUserSequence", sequenceName="ORDER_USER_SEQ", allocationSize=1)
	@Column(name="ORDER_USER_ID")
	private int orderUserId;  // primary key here
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user; // this is where we get user id from in the constructor
	
	
	
	
	@Column(name="TOTAL_PRICE", nullable=false, columnDefinition="NUMERIC")
	private double totalPrice;
	
	
	@OneToMany(mappedBy="orderUser")
	private Set<Order> order;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public OrderUser() {}
	public OrderUser(int orderUserId, User user, double totalPrice, Set<Order> order) {
		super();
		this.orderUserId = orderUserId;
		this.user = user;
		this.totalPrice = totalPrice;
		this.order = order;
	}
	public OrderUser(User user, double totalPrice) {
		super();
		this.user = user;
		this.totalPrice = totalPrice;
	}
	public int getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + orderUserId;
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orderUserId != other.orderUserId)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderUser [orderUserId=" + orderUserId + ", user=" + user + ", totalPrice=" + totalPrice + ", order="
				+ order + "]";
	}

}
