package com.foxman.mapper;

import com.foxman.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.mapper
 * @ClassName: StuCourseMapper
 * @Author: Foxman
 * @Date: 2020/3/9 11:50
 * @Version: 1.0
 */
@Mapper
public interface StuCourseMapper {
    int chooseCourse(HashMap map);

    ArrayList<Student> getStudentsByCourseId(String course_id);
}
