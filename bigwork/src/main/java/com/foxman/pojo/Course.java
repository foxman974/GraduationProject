package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Course
 * @Author: Foxman
 * @Date: 2020/2/14 10:16
 * @Version: 1.0
 */
public class Course {
    private String course_id;//课程序号
    private String course_code;//课程编号
    private String course_name;//课程名
    private String course_period;//学时
    private String course_credit;//学分
    private String course_year;//学年
    private String course_term;//学期
    private String course_checking;//考勤比例
    private String course_answer;//回答问题
    private String course_task;//作业比例
    private String teac_id;//任课老师

    public String getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(String teac_id) {
        this.teac_id = teac_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_period() {
        return course_period;
    }

    public void setCourse_period(String course_period) {
        this.course_period = course_period;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(String course_credit) {
        this.course_credit = course_credit;
    }

    public String getCourse_year() {
        return course_year;
    }

    public void setCourse_year(String course_year) {
        this.course_year = course_year;
    }

    public String getCourse_term() {
        return course_term;
    }

    public void setCourse_term(String course_term) {
        this.course_term = course_term;
    }

    public String getCourse_checking() {
        return course_checking;
    }

    public void setCourse_checking(String course_checking) {
        this.course_checking = course_checking;
    }

    public String getCourse_answer() {
        return course_answer;
    }

    public void setCourse_answer(String course_answer) {
        this.course_answer = course_answer;
    }

    public String getCourse_task() {
        return course_task;
    }

    public void setCourse_task(String course_task) {
        this.course_task = course_task;
    }
}
