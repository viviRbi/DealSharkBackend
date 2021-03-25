package com.dealshark.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name="USER_ID")
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
	
	
//	@Column(name="SAVED_GAMES", columnDefinition="INTEGER[]")
//	private Integer[] gamesArray; 
//	
//	@Column(name="PURCHASED_GAMES", columnDefinition="INTEGER[]")
//	private Integer[] purchasedArray;
	
	
	
	public User() {
		
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


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + balance;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
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
	if (id != other.id)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
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
			+ ", lastName=" + lastName + ", balance=" + balance + "]";
}


	
}
