package com.cy.entity;

import java.io.Serializable;

public class TransactionLog implements Serializable {

	private Integer id;
    private Account account;
    private Integer otherid;
    private Double tr_money;
    private String datetime;
    private TransactionType transactionType;
    
    public TransactionLog() {}

	public TransactionLog(Account account, Integer otherid, Double tr_money, String datetime,
			TransactionType transactionType) {
		this.account = account;
		this.otherid = otherid;
		this.tr_money = tr_money;
		this.datetime = datetime;
		this.transactionType = transactionType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getOtherid() {
		return otherid;
	}

	public void setOtherid(Integer otherid) {
		this.otherid = otherid;
	}

	public Double getTr_money() {
		return tr_money;
	}

	public void setTr_money(Double tr_money) {
		this.tr_money = tr_money;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
     
}
