package com.cy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cy.dao.interfaces.TransactionDaoInter;
import com.cy.entity.Account;
import com.cy.entity.TransactionLog;
import com.cy.entity.TransactionType;

public class TransactionDaoImpl implements TransactionDaoInter {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//根据交易类型获取交易类型对象
	@Override
	public TransactionType getTranactionType(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from TransactionType t where t.name='"+ name +"'";
        Query query = session.createQuery(hql);
		return (TransactionType) query.uniqueResult();
	}

	@Override
	public boolean addLog(TransactionLog log) {
        Session session = sessionFactory.getCurrentSession();
        session.save(log);
		return true;
	}

	@Override
	public List getLogs(Account account, int page) {
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(TransactionLog.class);
        //System.out.println(account.getPassword());
        c.add(Restrictions.or(Restrictions.eq("account", account), Restrictions.eq("otherid", account.getAccountid())));
        c.addOrder(Order.desc("id"));
        c.setFirstResult(10*(page-1));
        c.setMaxResults(10);
		return c.list();
	}

	@Override
	public Integer getCountOfLogs(Account account) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select count(*) from Transaction_Log where (accountid="+account.getAccountid()+" or otherid="+account.getAccountid()+")";
        Query query = session.createSQLQuery(sql);
        Integer count = Integer.parseInt(query.uniqueResult().toString());
		return count;
	}

}
