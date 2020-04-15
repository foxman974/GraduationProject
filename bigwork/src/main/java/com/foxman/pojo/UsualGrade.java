package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: UsualGrade
 * @Author: Foxman
 * @Date: 2020/2/14 10:33
 * @Version: 1.0
 */
public class UsualGrade {

    private String stu_id;//学生序号
    private String course_id;//课程序号
    private String abs_point;//考勤得分
    private String que_point;//回答问题得分
    private String task_point;//作业得分
    private String other_point;//其他得分
    private String all_point;//总分
    private Student student;
    private Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAbs_point() {
        return abs_point;
    }

    public void setAbs_point(String abs_point) {
        this.abs_point = abs_point;
    }

    public String getQue_point() {
        return que_point;
    }

    public void setQue_point(String que_point) {
        this.que_point = que_point;
    }

    public String getTask_point() {
        return task_point;
    }

    public void setTask_point(String task_point) {
        this.task_point = task_point;
    }

    public String getOther_point() {
        return other_point;
    }

    public void setOther_point(String other_point) {
        this.other_point = other_point;
    }

    public String getAll_point() {
        return all_point;
    }

    public void setAll_point(String all_point) {
        this.all_point = all_point;
    }
}
