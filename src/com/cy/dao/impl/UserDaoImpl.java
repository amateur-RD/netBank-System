package com.cy.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;

@Transactional
public class UserDaoImpl implements UserDaoInter {

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Account getAccount(String username) {
        //获取session
		Session session = sessionFactory.getCurrentSession();
        String hql = "from Account where username = '" + username + "'";
        //创建query对象
        Query query = session.createQuery(hql);
        //返回实例只有一个或为null时，用uniqueResult()方法；有多个时，用list()方法
		return (Account) query.uniqueResult();
	}
	@Override
	public boolean updateAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(account);
		return true;
	}
	//从session中重新获取对象account
	public void reflush(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.refresh(account);
		System.out.println(account.getUsername());
	}
	//获取账户对象，根据账户ID
	@Override
	public Account getAccount(int accountid) {
        Session session = sessionFactory.getCurrentSession();
		return (Account) session.get(Account.class, accountid);
	}
	//根据username获取管理员对象
	@Override
	public Admin getAdmin(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Admin as a where a.username='" + username + "'";
        Query query = session.createQuery(hql);
		return (Admin) query.uniqueResult();
	}
	//获取账户状态对象，根据账户ID
	@Override
	public Status getStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
		return (Status) session.get(Status.class, id);
	}
	//获取账户状态对象，根据名称
	@Override
	public Status getStatus(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Status as s where s.name='" + name + "'";
        Query query = session.createQuery(hql);
		return (Status) query.uniqueResult();
	}
	//管理员删除账户
	@Override
	public boolean delAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
		return true;
	}
	//开户
	@Override
	public boolean addAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
		return true;
	}

}
