package com.cy.service.interfaces;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;

public interface UserServiceInter {

	//获取账户对象
	public Account getAccount(String username);
	//获取账户对象
	public Account getAccount(int accountid);
	//修改账户
	public Boolean modifyAccount(Account account);
	//从session中重新获取对象account
	public void reflush(Account account);
	
	//根据username获取管理员对象
	public Admin getAdmin(String username);
	
	//启用账户
	public void enabled(int id);
	//冻结账户
	public void locking(int id);
	//删除账户
	public boolean delAccount(int id);
	//管理员开户
	public boolean addAccount(Account account);
	
}
