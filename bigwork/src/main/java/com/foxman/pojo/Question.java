package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Question
 * @Author: Foxman
 * @Date: 2020/2/14 10:20
 * @Version: 1.0
 */
public class Question {


    private String que_id;//问题序号
    private String que_code;//问题编号
    private String course_id;//课程序号
    private String que_content;//问题内容
    private Course course;//课程实体

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getQue_id() {
        return que_id;
    }

    public void setQue_id(String que_id) {
        this.que_id = que_id;
    }

    public String getQue_code() {
        return que_code;
    }

    public void setQue_code(String que_code) {
        this.que_code = que_code;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getQue_content() {
        return que_content;
    }

    public void setQue_content(String que_content) {
        this.que_content = que_content;
    }
}
