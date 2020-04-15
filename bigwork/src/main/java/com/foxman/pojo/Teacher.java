package com.foxman.pojo;

/**
 * @Package: com.ecut.pojo
 * @ClassName: Teacher
 * @Author: Foxman
 * @Date: 2020/1/22 13:56
 * @Version: 1.0
 */
public class Teacher {

    private String teac_id;//序号
    private String teac_code;//职工号
    private String major_id;//专业序号
    private String academy_id;//学院序号
    private String teac_name;//姓名
    private String teac_sex;//性别
    private String teac_birthday;//出生年月
    private String teac_level;//职称
    private String teac_pwd;//登陆密码
    private Major major;//专业
    private Academy academy;//学院

    public String getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(String teac_id) {
        this.teac_id = teac_id;
    }

    public String getTeac_code() {
        return teac_code;
    }

    public void setTeac_code(String teac_code) {
        this.teac_code = teac_code;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(String academy_id) {
        this.academy_id = academy_id;
    }

    public String getTeac_name() {
        return teac_name;
    }

    public void setTeac_name(String teac_name) {
        this.teac_name = teac_name;
    }

    public String getTeac_sex() {
        return teac_sex;
    }

    public void setTeac_sex(String teac_sex) {
        this.teac_sex = teac_sex;
    }

    public String getTeac_birthday() {
        return teac_birthday;
    }

    public void setTeac_birthday(String teac_birthday) {
        this.teac_birthday = teac_birthday;
    }

    public String getTeac_level() {
        return teac_level;
    }

    public void setTeac_level(String teac_level) {
        this.teac_level = teac_level;
    }

    public String getTeac_pwd() {
        return teac_pwd;
    }

    public void setTeac_pwd(String teac_pwd) {
        this.teac_pwd = teac_pwd;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
