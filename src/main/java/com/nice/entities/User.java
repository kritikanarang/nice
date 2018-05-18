package com.nice.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {

    @Id
    private Long id=Long.valueOf(1234);
    private String username;
    private String password;
    private List<Role> roles;
   
    User() {}

    public User(String username, String password, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public List<Role> getRole() {
		return roles;
	}
	public void setRole(List<Role> role) {
		this.roles = role;
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