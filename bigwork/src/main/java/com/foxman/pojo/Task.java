package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Task
 * @Author: Foxman
 * @Date: 2020/2/14 10:24
 * @Version: 1.0
 */
public class Task {
    private String task_id;//作业序号
    private String task_code;//作业编号
    private String course_id;//课程序号
    private String task_title;//作业题目
    private String task_point;//分数百分比
    private Course course;//课程

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_code() {
        return task_code;
    }

    public void setTask_code(String task_code) {
        this.task_code = task_code;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getTask_point() {
        return task_point;
    }

    public void setTask_point(String task_point) {
        this.task_point = task_point;
    }
}
