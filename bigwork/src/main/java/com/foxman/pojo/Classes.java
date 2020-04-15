package com.foxman.pojo;

import java.util.ArrayList;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Classes
 * @Author: Foxman
 * @Date: 2020/2/14 10:12
 * @Version: 1.0
 */
public class Classes {
    private String class_id;//班级序号
    private String class_name;//班级名称
    private String class_code;//班级编号
    private String academy_id;//学院序号
    private String major_id;//专业序号
    private Academy academy;//学院
    private Major major;//专业
    private ArrayList<Student> students;//班级学生


    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(String academy_id) {
        this.academy_id = academy_id;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
