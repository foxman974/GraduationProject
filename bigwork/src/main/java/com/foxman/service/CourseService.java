package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Course;
import com.foxman.pojo.Student;
import com.foxman.pojo.Teacher;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.service
 * @ClassName: CourseService
 * @Author: Foxman
 * @Date: 2020/2/12 17:37
 * @Version: 1.0
 */
public interface CourseService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Course findById(String id);

    int update(Course course);

    int delete(String course_id);

    int add(Course course);

    ArrayList<HashMap<String, String>> findAll();

    PageResult pageQuery2(Integer currentPage, Integer pageSize, String queryString, Student student);

    PageResult pageQuery3(Integer currentPage, Integer pageSize, String queryString, Teacher teacher);
}
