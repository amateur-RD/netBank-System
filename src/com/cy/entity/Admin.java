package com.cy.entity;

import java.io.Serializable;

public class Admin implements Serializable {

	private Integer id;
    private String username;
    private String password;
    
    public Admin() {}
        
	public Admin(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
