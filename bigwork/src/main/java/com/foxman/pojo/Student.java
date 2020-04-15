package com.foxman.pojo;

/**
 * @Package: com.ecut.pojo
 * @ClassName: Student
 * @Author: Foxman
 * @Date: 2020/1/15 10:25
 * @Version: 1.0
 */

public class Student {

    private String stu_id;//序号
    private String stu_code;//学号
    private String class_id;//班级序号
    private String stu_name;//姓名
    private String stu_sex;//性别
    private String stu_birthday;//出生年月
    private String stu_nativePlace;//籍贯
    private Classes classes;//班级
    private String stu_pwd;//登陆密码

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getStu_code() {
        return stu_code;
    }

    public void setStu_code(String stu_code) {
        this.stu_code = stu_code;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_birthday() {
        return stu_birthday;
    }

    public void setStu_birthday(String stu_birthday) {
        this.stu_birthday = stu_birthday;
    }

    public String getStu_nativePlace() {
        return stu_nativePlace;
    }

    public void setStu_nativePlace(String stu_nativePlace) {
        this.stu_nativePlace = stu_nativePlace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                ", class_id='" + class_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_birthday='" + stu_birthday + '\'' +
                ", stu_nativePlace='" + stu_nativePlace + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                '}';
    }
}
