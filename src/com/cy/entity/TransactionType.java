package com.cy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TransactionType implements Serializable{

	private Integer id;
	private String name;
	private Set transactionLogs = new HashSet(0);
	
	public TransactionType() {}

	public TransactionType(String name, Set transactionLogs) {
		this.name = name;
		this.transactionLogs = transactionLogs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTransactionLogs() {
		return transactionLogs;
	}

	public void setTransactionLogs(Set transactionLogs) {
		this.transactionLogs = transactionLogs;
	}
	
}
