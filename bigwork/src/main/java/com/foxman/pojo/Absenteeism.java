package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Absenteeism
 * @Author: Foxman
 * @Date: 2020/2/14 10:30
 * @Version: 1.0
 */
public class Absenteeism {
    private String abs_id;//缺勤序号
    private String  abs_code;//缺勤编号
    private String course_id;//课程序号
    private String abC_id;//缺勤类型序号
    private String stu_id;//学生序号
    private String abs_week;//周次
    private String abs_dayOfWeek;//星期
    private String abs_section;//节次
    private AbsenteeismCategory absenteeismCategory;
    private Course course;
    private Student student;

    public String getAbs_id() {
        return abs_id;
    }

    public void setAbs_id(String abs_id) {
        this.abs_id = abs_id;
    }

    public String getAbs_code() {
        return abs_code;
    }

    public void setAbs_code(String abs_code) {
        this.abs_code = abs_code;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAbC_id() {
        return abC_id;
    }

    public void setAbC_id(String abC_id) {
        this.abC_id = abC_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getAbs_week() {
        return abs_week;
    }

    public void setAbs_week(String abs_week) {
        this.abs_week = abs_week;
    }

    public String getAbs_dayOfWeek() {
        return abs_dayOfWeek;
    }

    public void setAbs_dayOfWeek(String abs_dayOfWeek) {
        this.abs_dayOfWeek = abs_dayOfWeek;
    }

    public String getAbs_section() {
        return abs_section;
    }

    public void setAbs_section(String abs_section) {
        this.abs_section = abs_section;
    }

    public AbsenteeismCategory getAbsenteeismCategory() {
        return absenteeismCategory;
    }

    public void setAbsenteeismCategory(AbsenteeismCategory absenteeismCategory) {
        this.absenteeismCategory = absenteeismCategory;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
