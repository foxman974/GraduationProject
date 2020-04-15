package com.foxman.mapper;

import com.foxman.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: CourseMapper
 * @Author: Foxman
 * @Date: 2020/2/12 17:45
 * @Version: 1.0
 */
@Mapper
public interface CourseMapper {
    List<Course> findPage(String queryString);

    Course findById(String id);

    int update(Course course);

    int deleteById(String course_id);

    int add(Course course);

    ArrayList<Course> findAll();

    List<Course> findPage2(HashMap map);

    List<Course> findPage3(HashMap map);
}
