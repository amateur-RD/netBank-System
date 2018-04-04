package com.cy.dao.interfaces;

import java.util.List;

import com.cy.entity.Account;
import com.cy.entity.TransactionLog;
import com.cy.entity.TransactionType;

public interface TransactionDaoInter {

	//根据交易类型名称获取交易类型对象
	public TransactionType getTranactionType(String name);
	//向Transaction_log表中添加交易记录
	public boolean addLog(TransactionLog log);
	//根据待显示页页码和账户对象获取交易记录
	public List getLogs(Account account, int page);
	//获取交易记录数
	public Integer getCountOfLogs(Account account);
}
