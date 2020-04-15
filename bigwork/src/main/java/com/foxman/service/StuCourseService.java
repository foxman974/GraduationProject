package com.foxman.service;

import com.foxman.pojo.Course;
import com.foxman.pojo.Student;

import java.util.ArrayList;

/**
 * @Package: com.foxman.service
 * @ClassName: StuCourseService
 * @Author: Foxman
 * @Date: 2020/3/9 11:49
 * @Version: 1.0
 */
public interface StuCourseService {
    int chooseCourse(Student student, ArrayList<Course> courseList);

    ArrayList<Student> getStudentsByCourseId(String course_id);
}
