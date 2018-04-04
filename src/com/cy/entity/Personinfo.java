package com.cy.entity;

import java.io.Serializable;

public class Personinfo implements Serializable {

	private Integer id;
    private Account account;
    private String realname;
    private Integer age;
    private String sex;
    private Long cardid;
    private String address;
    private String telephone;
    
    public Personinfo() {}

	public Personinfo(Account account, String realname, Integer age, String sex, Long cardid, String address,
			String telephone) {
		this.account = account;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.cardid = cardid;
		this.address = address;
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getCardid() {
		return cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
      
}
