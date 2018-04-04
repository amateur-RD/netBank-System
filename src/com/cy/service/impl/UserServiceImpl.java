package com.cy.service.impl;

import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;
import com.cy.service.interfaces.UserServiceInter;

public class UserServiceImpl implements UserServiceInter {

	UserDaoInter userDaoInter;
	public UserDaoInter getUserDaoInter() {
		return userDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaoInter) {
		this.userDaoInter = userDaoInter;
	}
	@Override
	public Account getAccount(String username) {
		return userDaoInter.getAccount(username);
	}
	//修改账户信息
	@Override
	public Boolean modifyAccount(Account account) {
		return userDaoInter.updateAccount(account);
	}
	//从session中重新获取对象account
	@Override
    public void reflush(Account account) {
	    userDaoInter.reflush(account);		
    }
	//获取账户对象
	@Override
	public Account getAccount(int accountid) {
		return userDaoInter.getAccount(accountid);
	}
	//获取管理员对象
	@Override
	public Admin getAdmin(String username) {
		return userDaoInter.getAdmin(username);
	}
	
	//启用账户
	@Override
	public void enabled(int id) {
        Account account = userDaoInter.getAccount(id);
        //获取并修改账户对象的状态属性，设置为启用
        Status status = userDaoInter.getStatus("启用");
        account.setStatus(status);
		userDaoInter.updateAccount(account);
	}
	//冻结账户
	@Override
	public void locking(int id) {
		Account account = userDaoInter.getAccount(id);
        //获取并修改账户对象的状态属性，设置为启用
        Status status = userDaoInter.getStatus("冻结");
        account.setStatus(status);
		userDaoInter.updateAccount(account);
		
	}
	//管理员删除账户
	@Override
	public boolean delAccount(int id) {
        Account account = userDaoInter.getAccount(id);
		return userDaoInter.delAccount(account);
	}
	//管理员开户
	@Override
	public boolean addAccount(Account account) {
		Status status = userDaoInter.getStatus("启用");
		account.setStatus(status);
		return userDaoInter.addAccount(account);
	}

}
