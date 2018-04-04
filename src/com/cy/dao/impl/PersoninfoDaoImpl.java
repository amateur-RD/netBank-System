package com.cy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.PersoninfoDaoInter;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;

@Transactional
public class PersoninfoDaoImpl implements PersoninfoDaoInter {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//实现修改个人信息
	@Override
	public void modifyPersoninfo(Personinfo personinfo) {

		Session session = sessionFactory.getCurrentSession();
		session.update(personinfo);
	}

	//管理员获取所有用户信息
	@Override
	public List getAllPersoninfo() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Personinfo";
		Query query = session.createQuery(hql);
		return query.list();
	}

	//管理员根据账户状态查询用户信息，参数id为管理员页面超链接上面的id值
	@Override
	public List searchPersoninfo(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Personinfo p where p.account.status.id = "+id;
		Query query = session.createQuery(hql);
		return query.list();
	}

	//根据真实姓名查询个人信息
	@Override
	public List searchPersoninfo(Personinfo personinfo) {
        Session session = sessionFactory.getCurrentSession();
        //使用hibernate中criteria方法进行查询
        Criteria c = session.createCriteria(Personinfo.class);
        //System.out.println(personinfo.getAddress());
        if(personinfo.getRealname() != null && !"".equals(personinfo.getRealname())) {
        	//System.out.println(personinfo.getCardid());
        	if(personinfo.getCardid() != null) {
        		c.add(Restrictions.or(Restrictions.eq("realname", personinfo.getRealname()), Restrictions.eq("cardid", personinfo.getCardid())));
        	} else {
        		//MatchMode.ANYWHERE表示模糊匹配     "realname"为数据库中的字段
        		c.add(Restrictions.like("realname", personinfo.getRealname(), MatchMode.ANYWHERE));
        	}
        }
        //查询结果按照id值进行升序排列
        c.addOrder(Order.asc("id"));
        return c.list();
	}

	//管理员开户
	@Override
	public boolean add(Personinfo personinfo) {
        Session session = sessionFactory.getCurrentSession();
        session.save(personinfo);
		return true;
	}

}
