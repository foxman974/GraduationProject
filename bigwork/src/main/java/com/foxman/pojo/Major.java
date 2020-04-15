package com.foxman.pojo;

import java.util.ArrayList;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Major
 * @Author: Foxman
 * @Date: 2020/2/14 10:07
 * @Version: 1.0
 */
public class Major {
    private String major_id;//专业序号
    private String major_code;//专业编号
    private String major_name;//专业名称
    private String academy_id;//学院序号
    private Academy academy;//所属学院
    private ArrayList<Classes> classes;//专业班级
    private ArrayList<Teacher> teachers;//专业老师

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(String academy_id) {
        this.academy_id = academy_id;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
}
