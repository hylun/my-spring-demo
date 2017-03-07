package com.springmvcdemo.entities;

import org.hibernate.validator.constraints.Length;

public class User {
    private Integer id;
    
    @Length(min=5,max=20,message="请填写5-20位的用户名")
    private String username;

    @Length(min=5,max=20,message="请填写5-20位的密码")
    private String password;

    private String pic="";

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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}