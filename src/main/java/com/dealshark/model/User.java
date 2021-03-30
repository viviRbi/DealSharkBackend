package com.dealshark.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name="USER_ID", nullable=false)
	private int id;  // primary key here
	
	@Column(name="USERNAME", unique=true, nullable=false, columnDefinition="VARCHAR")
	private String username;
	
	@Column(name="USER_PASSWORD", nullable=false, columnDefinition="VARCHAR")
	private String password;
	
	@Column(name="FIRST_NAME", nullable=false, columnDefinition="VARCHAR")
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false, columnDefinition="VARCHAR")
	private String lastName;
	
	@Column(name="BALANCE", nullable=false, columnDefinition="NUMERIC")
	private int balance = 100;
	
	
	@Column(name="SAVED_GAMES", columnDefinition="VARCHAR")
	private String gamesArray; 
	
	@Column(name="PURCHASED_GAMES", columnDefinition="VARCHAR")
	private String purchasedArray;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	private Set<OrderUser> orderUser = new HashSet<OrderUser>();
	
	
	
	
	
	public User() {
		
	}

	
	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String username, String password, String firstName, String lastName, int balance) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public User(int id, String username, String password, String firstName, String lastName, int balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}


	public User(int id, String username, String password, String firstName, String lastName, int balance,
			String gamesArray, String purchasedArray, Set<OrderUser> orderUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.gamesArray = gamesArray;
		this.purchasedArray = purchasedArray;
		this.orderUser = orderUser;
	}


	public User(String username, String password, String firstName, String lastName, int balance, String gamesArray,
			String purchasedArray, Set<OrderUser> orderUser) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.gamesArray = gamesArray;
		this.purchasedArray = purchasedArray;
		this.orderUser = orderUser;
	}
	
	


	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public String getGamesArray() {
		return gamesArray;
	}


	public void setGamesArray(String gamesArray) {
		this.gamesArray = gamesArray;
	}


	public String getPurchasedArray() {
		return purchasedArray;
	}


	public void setPurchasedArray(String purchasedArray) {
		this.purchasedArray = purchasedArray;
	}


	public Set<OrderUser> getOrderUser() {
		return orderUser;
	}


	public void setOrderUser(Set<OrderUser> orderUser) {
		this.orderUser = orderUser;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gamesArray == null) ? 0 : gamesArray.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((orderUser == null) ? 0 : orderUser.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((purchasedArray == null) ? 0 : purchasedArray.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (balance != other.balance)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gamesArray == null) {
			if (other.gamesArray != null)
				return false;
		} else if (!gamesArray.equals(other.gamesArray))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (orderUser == null) {
			if (other.orderUser != null)
				return false;
		} else if (!orderUser.equals(other.orderUser))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (purchasedArray == null) {
			if (other.purchasedArray != null)
				return false;
		} else if (!purchasedArray.equals(other.purchasedArray))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", balance=" + balance + ", gamesArray=" + gamesArray + ", purchasedArray="
				+ purchasedArray + ", orderUser=" + orderUser + "]";
	}




}
