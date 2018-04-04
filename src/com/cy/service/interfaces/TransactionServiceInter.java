package com.cy.service.interfaces;

import java.util.List;

import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;

public interface TransactionServiceInter {

	//存款
	public boolean deposit(TransactionLog log);
	//取款
	public boolean withdraw(TransactionLog log);
	//转账
	public boolean transfer(TransactionLog log);
	
	//获取交易记录
	public List getLogs(Account account, int page);
	//获得账户的交易记录总数，用来初始化分页类Pager对象，
	//并设置其perPagerRows和rowCount属性
	public Pager getPagerOfLogs(Account account);
}
