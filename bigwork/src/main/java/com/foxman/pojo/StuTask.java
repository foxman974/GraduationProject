package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: StuTask
 * @Author: Foxman
 * @Date: 2020/2/14 10:27
 * @Version: 1.0
 */
public class StuTask {

    private String teac_id;//教师序号
    private String stu_id;//学生序号
    private String course_id;//课程序号
    private String task_id;//作业序号
    private String stuTask_answer;//答案图像
    private String stuTask_grade;//成绩
    private Teacher teacher;
    private Student student;
    private Course course;
    private Task task;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTeac_id() {
        return teac_id;
    }

    public void setTeac_id(String teac_id) {
        this.teac_id = teac_id;
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

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getStuTask_answer() {
        return stuTask_answer;
    }

    public void setStuTask_answer(String stuTask_answer) {
        this.stuTask_answer = stuTask_answer;
    }

    public String getStuTask_grade() {
        return stuTask_grade;
    }

    public void setStuTask_grade(String stuTask_grade) {
        this.stuTask_grade = stuTask_grade;
    }
}
