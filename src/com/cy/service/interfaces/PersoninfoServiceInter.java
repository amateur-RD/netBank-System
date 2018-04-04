package com.cy.service.interfaces;

import java.util.List;

import com.cy.entity.Personinfo;
import com.cy.entity.Status;

public interface PersoninfoServiceInter {

	//修改个人信息
	public boolean modifyPersoninfo(Personinfo personinfo);
	
	
    //管理员根据账户状态查询用户信息
	public List searchPersoninfo(Status status);
	//管理员根据用户真实名字查询用户信息
	public List searchPersoninfo(Personinfo personinfo);
	
	//管理员开户（个人信息）
	public boolean add(Personinfo personinfo);
	
}
