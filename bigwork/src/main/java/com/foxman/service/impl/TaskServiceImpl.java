package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.TaskMapper;
import com.foxman.pojo.*;
import com.foxman.service.CourseService;
import com.foxman.service.StuCourseService;
import com.foxman.service.StuTaskService;
import com.foxman.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: TaskServiceImpl
 * @Author: Foxman
 * @Date: 2020/3/6 11:21
 * @Version: 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private StuTaskService stuTaskService;
    @Autowired
    private StuCourseService stuCourseService;
    @Autowired
    private CourseService courseService;
    
    @Override
    public List<HashMap<String, Object>> findAll() {
        return null;
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<Task> list = taskMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Task> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Task findById(String task_id) {
        return taskMapper.findById(task_id);
    }

    @Override
    public int update(Task task) {
        return taskMapper.update(task);
    }

    @Override
    @Transactional
    public int delete(String task_id) {
        //删除已经布置的作业
        stuTaskService.delete(task_id);
        return taskMapper.deleteById(task_id);
    }

    @Override
    public int add(Task task) {
        int result=taskMapper.add(task);
        String course_id = task.getCourse_id();
        Course course = courseService.findById(course_id);
        task.setCourse(course);
        StuTask stuTask=null;
        //添加作业后给选修该课程的学生发布作业
        //获取选修了该课程的所有学生
        ArrayList<Student> students=new ArrayList<>();
        students=stuCourseService.getStudentsByCourseId(task.getCourse_id());
        for (Student student : students) {
            stuTask=new StuTask();
            stuTask.setStu_id(student.getStu_id());
            stuTask.setStudent(student);
            stuTask.setCourse(course);
            stuTask.setCourse_id(course.getCourse_id());
            stuTask.setTeac_id(course.getTeac_id());
            stuTask.setTask(task);
            stuTask.setTask_id(task.getTask_id());
            result+=stuTaskService.add(stuTask);
        }
        return result;
    }




}
