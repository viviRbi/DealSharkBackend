
package com.dealshark.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order")
	@SequenceGenerator(name="order", sequenceName="ORDER_SEQ", allocationSize=1)
	@Column(name="ORDER_ID")
	private int orderId;  // primary key here
	
	@Column(name="GAME_ID", columnDefinition="INT")
	private int gameId;
	
	@ManyToOne
	@JoinColumn(name="ORDER_USER_ID")
	private OrderUser orderUser;
	
	@Column(name="GAME_PRICE", columnDefinition="NUMERIC")
	private int gamePrice;
	
	@Column(name="QUANTITY", columnDefinition="INT")
	private int quantity;
	


	public Order() {}


	

	public Order(int gameId, OrderUser orderUser, int gamePrice, int quantity) {
		super();
		this.gameId = gameId;
		this.orderUser = orderUser;
		this.gamePrice = gamePrice;
		this.quantity = quantity;
	}



	public Order(OrderUser orderUser, int gamePrice, int quantity) {
		super();
		this.orderUser = orderUser;
		this.gamePrice = gamePrice;
		this.quantity = quantity;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getGameId() {
		return gameId;
	}



	public void setGameId(int gameId) {
		this.gameId = gameId;
	}



	public OrderUser getOrderUser() {
		return orderUser;
	}



	public void setOrderUser(OrderUser orderUser) {
		this.orderUser = orderUser;
	}



	public int getGamePrice() {
		return gamePrice;
	}



	public void setGamePrice(int gamePrice) {
		this.gamePrice = gamePrice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + gamePrice;
		result = prime * result + orderId;
		result = prime * result + ((orderUser == null) ? 0 : orderUser.hashCode());
		result = prime * result + quantity;
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
		Order other = (Order) obj;
		if (gameId != other.gameId)
			return false;
		if (gamePrice != other.gamePrice)
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderUser == null) {
			if (other.orderUser != null)
				return false;
		} else if (!orderUser.equals(other.orderUser))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", gameId=" + gameId + ", orderUser=" + orderUser + ", gamePrice="
				+ gamePrice + ", quantity=" + quantity + "]";
	}


	

}
