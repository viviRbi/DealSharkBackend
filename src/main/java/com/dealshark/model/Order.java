package com.dealshark.model;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Column(name="ORDER_USER_ID", columnDefinition="INT")
	private int userId;
	
	@Column(name="GAME_ID", columnDefinition="INT")
	private int gameId;
	
	@Column(name="GAME_PRICE", columnDefinition="NUMERIC")
	private int gamePrice;
	
	@Column(name="quantity", columnDefinition="INT")
	private int quantity;

	public Order() {}
	
	public Order(int userId, int gameId, int gamePrice, int quantity) {
		super();
		this.userId = userId;
		this.gameId = gameId;
		this.gamePrice = gamePrice;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", gameId=" + gameId + ", gamePrice=" + gamePrice + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + gamePrice;
		result = prime * result + quantity;
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
		Order other = (Order) obj;
		if (gameId != other.gameId)
			return false;
		if (gamePrice != other.gamePrice)
			return false;
		if (quantity != other.quantity)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
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

	
	
}
