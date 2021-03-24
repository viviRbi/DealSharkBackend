package com.dealshark.model;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="email")
	private String email;
	
}
