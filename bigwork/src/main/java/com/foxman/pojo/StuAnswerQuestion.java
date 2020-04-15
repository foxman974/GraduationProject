package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: StuAnswerQuestion
 * @Author: Foxman
 * @Date: 2020/2/14 10:23
 * @Version: 1.0
 */
public class StuAnswerQuestion {

    private String que_id;//问题序号
    private String que_getPoint;//问题得分
    private String stu_id;//学生序号
    private String course_id;//课程序号
    private Question question;//问题实体
    private Course course;//课程实体
    private Student student;//学生实体

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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

    public String getQue_id() {
        return que_id;
    }

    public void setQue_id(String que_id) {
        this.que_id = que_id;
    }

    public String getQue_getPoint() {
        return que_getPoint;
    }

    public void setQue_getPoint(String que_getPoint) {
        this.que_getPoint = que_getPoint;
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
}
