package com.cy.dao.interfaces;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;

public interface UserDaoInter {

	//获取账户对象
	public Account getAccount(String username);
	//获取账户对象
	public Account getAccount(int accountid);
	//修改账户
	public boolean updateAccount(Account account);
	//从session中重新获取对象account
	public void reflush(Account account);
	
	//根据username获取管理员对象
	public Admin getAdmin(String username);
	
	//根据账户状态名称获取账户状态对象
	public Status getStatus(String name);
	//根据账户状态id获取账户状态对象	
	public Status getStatus(int id);
	
	//管理员删除账户
	public boolean delAccount(Account account);
	//开户
	public boolean addAccount(Account account);
}
