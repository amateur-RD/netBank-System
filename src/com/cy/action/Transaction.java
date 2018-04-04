package com.cy.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;
import com.cy.service.interfaces.TransactionServiceInter;
import com.cy.service.interfaces.UserServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class Transaction extends ActionSupport implements RequestAware, SessionAware {

	//定义属性，添加set方法，实现依赖注入
	private UserServiceInter userServiceInter;
	private TransactionServiceInter transactionServiceInter;
	private Map<String, Object> request;
	private Map<String, Object> session;
	public UserServiceInter getUserServiceInter() {
		return userServiceInter;
	}
	public void setUserServiceInter(UserServiceInter userServiceInter) {
		this.userServiceInter = userServiceInter;
	}
	public TransactionServiceInter getTransactionServiceInter() {
		return transactionServiceInter;
	}
	public void setTransactionServiceInter(TransactionServiceInter transactionServiceInter) {
		this.transactionServiceInter = transactionServiceInter;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	//定义TransactionLog对象并添加get和set方法，用户封装页面表单参数
	private TransactionLog log;
	public TransactionLog getLog() {
		return log;
	}
	public void setLog(TransactionLog log) {
		this.log = log;
	}
	
	//定义分页实体类
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	//存款
	public String deposit() {
		//调用isEnable方法判断账户是否冻结
		if(isEnable()) {
			//System.out.println(log.getTr_money());
			//给交易对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表account中的余额
			//并在交易信息表transaction_log表中添加记录
			return isSuccess(transactionServiceInter.deposit(log));
		}
		return "message";
	}
	
	//对取款页面进行验证，判断账户余额是否充足
	public void validateWithdraw() {
		account = (Account) session.get("user");
		//System.out.println(log.getTr_money());
		//System.out.println(account.getBalance());
		if(log.getTr_money()>account.getBalance()) {
			this.addFieldError("log.tr_money", "您的账户余额不足！");
		}
	}
	
	//取款
	public String withdraw() {
		//调用isEnable方法判断账户是否冻结
		if(isEnable()) {
			//给交易对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表account中的余额
			//并在交易信息表transaction_log表中添加记录
			return isSuccess(transactionServiceInter.withdraw(log));
		}
		return "message";
	}
	
	//对转账页面表单进行验证
	public void validateTransfer() {
		account = (Account) session.get("user");
		if(log.getOtherid().intValue() == account.getAccountid().intValue()) {
			this.addFieldError("log.otherid", "您不能转给自己！");
		}
		if(userServiceInter.getAccount(log.getOtherid()) == null) {
			this.addFieldError("log.otherid", "该账户不存在！");
		}
		if(log.getTr_money()>account.getBalance()) {
			this.addFieldError("log.tr_money", "您的账户余额不足！");
		}
	}
	//转账
	public String transfer() {
		//判断账户是否冻结
		if(isEnable()) {
			//给交易对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表account中的余额
			//并在交易信息表transaction_log表中添加记录
			return isSuccess(transactionServiceInter.transfer(log));
		}
		return "message";
	}
	
	//判断账户是否冻结
	public boolean isEnable() {
		//userServiceInter.reflush(account);
		account = (Account) session.get("user");
		//System.out.println(account.getUsername());
		if(account.getStatus().getName().equals("冻结")) {
			request.put("message", "抱歉！该账户已被冻结，无法进行相关操作！<br>");
			return false;
		}
		return true;
	}
	//
	public String isSuccess(boolean flag) {
		if(flag) {
			request.put("message", "操作成功！");
			return "message";
		}
		request.put("message", "操作失败！<a href='javascript:history.go(-1)'>返回</a>");
		return "message";
	}
	
	//显示交易记录
	public String list() {
		account = (Account) session.get("user");
		//获取待显示页页码
		int curPage = pager.getCurPage();
		//根据待显示页页码和账户对象获取交易记录
		List<TransactionLog> logs = transactionServiceInter.getLogs(account, curPage);
		//获得账户的交易记录总数，用来初始化pager对象，
		//并设置其perPageRows和rowCount属性
		pager = transactionServiceInter.getPagerOfLogs(account);
		//设置pager对象中待显示页页码
		pager.setCurPage(curPage);
		request.put("logs", logs);
		return "success";
	}
	
}
