package com.foxman.entity;

/**
 * @Package: com.foxman.entity
 * @ClassName: UserLogin
 * @Author: Foxman
 * @Date: 2020/3/7 10:11
 * @Version: 1.0
 */
public class UserLogin {
    private String code;
    private String pwd;
    private String role;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
