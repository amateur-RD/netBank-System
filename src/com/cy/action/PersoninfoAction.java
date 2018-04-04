package com.cy.action;

import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.Personinfo;
import com.cy.service.interfaces.PersoninfoServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class PersoninfoAction extends ActionSupport implements RequestAware,SessionAware {

	@Resource private PersoninfoServiceInter personinfoServiceInter;
	private Personinfo personinfo;
	Map<String, Object> request;
	Map<String, Object> session;
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
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
	
	//修改个人信息
	public String modify() {
		//从session中获取保存的个人信息对象
		//System.out.println("sfa");
		Personinfo per = (Personinfo) session.get("personinfo");
		per.setAddress(personinfo.getAddress());
		per.setAge(personinfo.getAge());
		per.setCardid(personinfo.getCardid());
		per.setRealname(personinfo.getRealname());
		per.setSex(personinfo.getSex());
		per.setTelephone(personinfo.getTelephone());
		//将个人信息更新数据库
		if(personinfoServiceInter.modifyPersoninfo(per)) {
			//更新成功，保存到session
			session.put("personinfo", per);
			request.put("message", "修改成功！");
			return "message";
		}
		request.put("message", "修改失败！");
		return "message";
	}
	
	//修改个人信息页面校验
	public void validateModify() {
		if(!(personinfo.getAge()>18 && personinfo.getAge()<100)) {
			addFieldError("personinfo.age", "年龄不符！");
		}
		if(!(Pattern.compile("^\\d{17}(\\d|x)$")
			.matcher(personinfo.getCardid().toString()).matches())) {
			addFieldError("personinfo.cardID", "身份证格式不正确！");
		}
		if(!(Pattern.compile("^(?:1[358]\\d{9}|\\d{3,4}-\\d{8,9})$")
				.matcher(personinfo.getTelephone()).matches())) {
			addFieldError("personinfo.telephone", "电话号格式不正确！");
		}
	}
	
}
