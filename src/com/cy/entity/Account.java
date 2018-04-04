package com.cy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable{

	private Integer accountid;
	private String username;
    private	String password;
	private Double balance;
	private Status status;
	private Set transactionLogs = new HashSet(0);
	private Set personinfos = new HashSet(0);
	
	public Account() {}

	public Account(String username, String password, Double balance, Status status, Set transactionLogs,
			Set personinfos) {
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.status = status;
		this.transactionLogs = transactionLogs;
		this.personinfos = personinfos;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set getTransactionLogs() {
		return transactionLogs;
	}

	public void setTransactionLogs(Set transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	public Set getPersoninfos() {
		return personinfos;
	}

	public void setPersoninfos(Set personinfos) {
		this.personinfos = personinfos;
	}
	
}
