package com.cy.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.*;
import com.cy.service.interfaces.UserServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{

	//通过@Resource注解注入userServiceInter，可以省略set方法
	@Resource private UserServiceInter userServiceInter;
	Map<String, Object> request;
	Map<String, Object> session;
	private Account account;
	private Personinfo personinfo;
	private String oldpwd;
	private String newpwd;
	
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	
	//使用validate*方法，进行登录(login)表单校验。 根据用户名获取用户对象
	public void validateLogin() {
		Account a = userServiceInter.getAccount(account.getUsername());	
		System.out.println(account.getUsername());
	    if(a == null) {
	    	this.addFieldError("username", "用户名不存在！");
	    } else {
	    	if(!account.getPassword().equals(a.getPassword())) {
	    		this.addFieldError("password", "密码错误！");
	    	}
	    }
	    account = a;
	}
	//执行页面登录请求，并从用户对象中获取个人信息对象，并保存到session中
	public String login() {
		personinfo = (Personinfo)account.getPersoninfos().iterator().next();
		session.put("user", account);
		session.put("personinfo", personinfo);
		return "success";
	}
	
	//使用validate*方法，进行修改密码(changepwd)表单校验
	public void validateChangepwd() {
		account = (Account) session.get("user");
		if(!oldpwd.equals(account.getPassword())) {
			this.addFieldError("pwderror", "密码不正确！");
		}
//		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())) {
//			this.addFieldError("confirmpwd", "两次密码不一致！");
//		}
		
	}
	
	//执行修改密码请求
	public String changepwd() {
		//System.out.println("密码："+oldpwd);
		account = (Account) session.get("user");
		//System.out.println("用户："+account.getPassword());
		account.setPassword(newpwd);
		if(userServiceInter.modifyAccount(account)) {
			session.put("user", account);
			request.put("message", "密码修改成功！");
			return "message";
		} else {
			request.put("message", "密码修改失败！");
			return "message";
		}
	}
	
	//注销
	public String logout() {
        	session.remove("user");
    		session.remove("personinfo");
    		return "input";  
	}
	
}
