package com.mockuptest.mockuptest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	@Column(nullable = false)
	private String namalengkap;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String status;

	public User() {
		
	}
	
	public User(long userid, String namalengkap, String username, String password, String status) {
		super();
		this.userid = userid;
		this.namalengkap = namalengkap;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getNamalengkap() {
		return namalengkap;
	}

	public void setNamalengkap(String namalengkap) {
		this.namalengkap = namalengkap;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
