package com.cy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.PersoninfoDaoInter;
import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;
import com.cy.service.interfaces.PersoninfoServiceInter;
import com.cy.service.interfaces.UserServiceInter;

@Transactional
public class PersoninfoServiceImpl implements PersoninfoServiceInter {

	//使用PersoninfoDaoInter接口定义对象，并添加set方法，实现依赖注入
	private PersoninfoDaoInter personinfoDaoInter;
	//使用UserDAOInter接口定义对象，并添加set方法，实现依赖注入
	private UserDaoInter userDaoInter;
	public void setPersoninfoDaoInter(PersoninfoDaoInter personinfoDaoInter) {
		this.personinfoDaoInter = personinfoDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaointer) {
		this.userDaoInter = userDaointer;
	}
	
	//修改个人信息
	@Override
	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDaoInter.modifyPersoninfo(personinfo);
		return true;
	}
	
    //管理员根据账户状态查询用户信息,状态为0表示获取所有用户
	@Override
	public List searchPersoninfo(Status status) {
        List users = new ArrayList();
        //System.out.println(status.getId());
        if(status.getId() != 0) {
        	//若账户状态标号不为0，则根据编号获取相应的客户记录
        	//status = userDaoInter.getStatus(status.getId());
        	//System.out.println("你好a"+status.getId());
        	users = personinfoDaoInter.searchPersoninfo(status.getId());
        } else {
        	//标号为0，则获取所有客户的记录
        	users = personinfoDaoInter.getAllPersoninfo();
        }
		return users;
	}
	//管理员根据用户真实名字查询用户信息
	@Override
	public List searchPersoninfo(Personinfo personinfo) {
		return personinfoDaoInter.searchPersoninfo(personinfo);
	}
	//管理员开户（添加个人信息）
	@Override
	public boolean add(Personinfo personinfo) {
		return personinfoDaoInter.add(personinfo);
	}

}
