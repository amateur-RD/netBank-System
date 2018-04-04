package com.cy.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.TransactionDaoInter;
import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;
import com.cy.entity.TransactionType;
import com.cy.service.interfaces.TransactionServiceInter;

@Transactional
public class TransactionServiceImpl implements TransactionServiceInter {

	private TransactionDaoInter transactionDaoInter;
	private UserDaoInter userDaoInter;
	public void setTransactionDaoInter(TransactionDaoInter transactionDaoInter) {
		this.transactionDaoInter = transactionDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaoInter) {
		this.userDaoInter = userDaoInter;
	}
	//存款
	@Override
	public boolean deposit(TransactionLog log) {
		//从交易对象log中获取账户对象
        Account self = log.getAccount();
        //将账户余额与存款相加  
        //使用log.getTr_money()可以获取表单中填入的存款金额，原理是封装Transaction对象，实现action接收表单参数
        self.setBalance(log.getTr_money()+log.getAccount().getBalance());
        //更新账户表，修改余额
        userDaoInter.updateAccount(self);
        //根据交易类型获取交易对象
        TransactionType type = transactionDaoInter.getTranactionType("存款");
        log.setTransactionType(type);
        log.setOtherid(self.getAccountid());
        log.setDatetime(log.getDatetime());
		//调用接口中的addlog方法，向transaction_log中添加交易记录
        return transactionDaoInter.addLog(log);
	}
	//取款
	@Override
	public boolean withdraw(TransactionLog log) {
		//从交易对象log中获取账户对象
		Account self = log.getAccount();
		 //将账户余额与存款相加  
        //使用log.getTr_money()可以获取表单中填入的存款金额，原理是封装Transaction对象，实现action接收表单参数
		self.setBalance(log.getAccount().getBalance()-log.getTr_money());
        //更新账户表，修改余额
		userDaoInter.updateAccount(self);
        //根据交易类型获取交易对象
		TransactionType type = transactionDaoInter.getTranactionType("取款");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		log.setDatetime(log.getDatetime());
		//调用接口中的addlog方法，向transaction_log中添加交易记录
		return transactionDaoInter.addLog(log);
	}
	//转账
	@Override
	public boolean transfer(TransactionLog log) {
		//获取对方账户对象
		Account other = userDaoInter.getAccount(log.getOtherid());
        //获取自己账户对象		
		Account self = log.getAccount();
		if(other!=null) {
			//修改对方账户余额
			other.setBalance(other.getBalance()+log.getTr_money());
			//修改自己账户金额
			self.setBalance(self.getBalance()-log.getTr_money());
			//更新对方、自己账户的余额
			userDaoInter.updateAccount(other);
			userDaoInter.updateAccount(self);
			//根据交易类型获取交易对象
			TransactionType type = transactionDaoInter.getTranactionType("转账");
			log.setTransactionType(type);
			log.setOtherid(log.getOtherid());
			log.setDatetime(log.getDatetime());
			//向表transaction_log中添加交易记录
			return transactionDaoInter.addLog(log);
		}
		return false;
	}
	
	@Override
	//获取交易记录
	public List getLogs(Account account, int page) {
		return transactionDaoInter.getLogs(account, page);
	}
	@Override
	//获得账户的交易记录总数，用来初始化分页类Pager对象，
	//并设置其perPagerRows和rowCount属性
	public Pager getPagerOfLogs(Account account) {
		//从表Transaction_Log中获取与账户相关的交易记录数
		int count = transactionDaoInter.getCountOfLogs(account);
		//
		Pager pager = new Pager();
		//设置pager对象中PerPageRows属性，表示每页显示10条记录
		pager.setPerPageRows(5);
		//设置rowCount属性，表示记录总数
		pager.setRowCount(count);
		return pager;
	}
}
