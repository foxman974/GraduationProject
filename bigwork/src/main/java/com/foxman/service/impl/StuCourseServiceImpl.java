package com.foxman.service.impl;

import com.foxman.mapper.StuCourseMapper;
import com.foxman.mapper.UsualGradeMapper;
import com.foxman.pojo.Course;
import com.foxman.pojo.Student;
import com.foxman.pojo.UsualGrade;
import com.foxman.service.StuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: StuCourseServiceImpl
 * @Author: Foxman
 * @Date: 2020/3/9 11:49
 * @Version: 1.0
 */
@Service
public class StuCourseServiceImpl implements StuCourseService {
    @Autowired
    private StuCourseMapper stuCourseMapper;
    @Autowired
    private UsualGradeMapper usualGradeMapper;


    @Override
    public int chooseCourse(Student student, ArrayList<Course> courseList) {
        String stu_id=student.getStu_id();
        HashMap map=null;
        int result=0;
        UsualGrade usualGrade=null;
        for (Course course : courseList) {
            map=new HashMap();
            map.put("stu_id",stu_id);
            map.put("course_id",course.getCourse_id());
            //新增平时成绩记录
            usualGrade=new UsualGrade();
            usualGrade.setStu_id(stu_id);
            usualGrade.setCourse_id(course.getCourse_id());
            usualGradeMapper.insert(usualGrade);
            result+=stuCourseMapper.chooseCourse(map);
        }
        return result;
    }

    @Override
    public ArrayList<Student> getStudentsByCourseId(String course_id) {

        return stuCourseMapper.getStudentsByCourseId(course_id);
    }
}
