package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.CourseMapper;
import com.foxman.pojo.Course;
import com.foxman.pojo.Student;
import com.foxman.pojo.Teacher;
import com.foxman.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: CourseServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/12 17:38
 * @Version: 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 方案一：如果不使用mybatis的分页插件
        // 总记录数：（sql：select count(*) from t_checkitem where name=#{queryString}）
        // 当前页的查询集合List：（sql：select * from t_checkitem where name=#{queryString} limit ?,?）
        // 第一个?表示当前页从第几条开始检索（起始记录数）：计算(currentPage-1)*pageSize
        // 第二个?表示当前页最多显示的记录数：计算pageSize
        // 方案二：使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<Course> list = courseMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
        // 或者使用
//        Page<CheckItem> page = checkItemDao.findPage(queryString);
//        return new PageResult(page.getTotal(),page.getResult());

    }

    @Override
    public Course findById(String id) {

        return courseMapper.findById(id);
    }

    @Override
    public int update(Course course) {

        return courseMapper.update(course);
    }

    @Override
    public int delete(String course_id) {
        return courseMapper.deleteById(course_id);
    }

    @Override
    public int add(Course course) {

        return courseMapper.add(course);
    }

    @Override
    public ArrayList<HashMap<String, String>> findAll() {
        ArrayList<Course> courses=courseMapper.findAll();
        ArrayList<HashMap<String, String>> list=new ArrayList<>();
        HashMap<String,String> courseMap=null;
        for (Course course : courses) {
            courseMap=new HashMap<>();
            courseMap.put("label",course.getCourse_name()+course.getCourse_code());
            courseMap.put("value2",course.getCourse_id()+"");
            list.add(courseMap);
        }
        return list;
    }

    @Override
    public PageResult pageQuery2(Integer currentPage, Integer pageSize, String queryString, Student student) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        String stu_id=student.getStu_id();
        HashMap map=new HashMap();
        map.put("queryString",queryString);
        map.put("stu_id",stu_id);
        // 2：查询数据
        List<Course> list = courseMapper.findPage2(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult pageQuery3(Integer currentPage, Integer pageSize, String queryString, Teacher teacher) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        String teac_id=teacher.getTeac_id();
        HashMap map=new HashMap();
        map.put("queryString",queryString);
        map.put("teac_id",teac_id);
        // 2：查询数据
        List<Course> list = courseMapper.findPage3(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }


}
