package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.StuTaskMapper;
import com.foxman.mapper.UsualGradeMapper;
import com.foxman.pojo.StuTask;
import com.foxman.pojo.Task;
import com.foxman.pojo.Teacher;
import com.foxman.pojo.UsualGrade;
import com.foxman.service.StuTaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: StuTaskServiceImpl
 * @Author: Foxman
 * @Date: 2020/3/6 14:11
 * @Version: 1.0
 */
@Service
public class StuTaskServiceImpl implements StuTaskService {
    @Autowired
    private StuTaskMapper stuTaskMapper;
    @Autowired
    private UsualGradeMapper usualGradeMapper;
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString , String stu_code) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        HashMap<String,String> map=new HashMap<>();
        map.put("queryString",queryString);
        map.put("stu_code",stu_code);
        List<StuTask> list = stuTaskMapper.findPage(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<StuTask> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int update(StuTask stuTask) {
        if(stuTask.getStuTask_grade()!=null && stuTask.getStuTask_grade().length()>0){
            UsualGrade usualGrade=new UsualGrade();
            usualGrade.setCourse_id(stuTask.getCourse_id());
            usualGrade.setStu_id(stuTask.getStu_id());
            usualGrade.setTask_point(stuTask.getStuTask_grade());
            usualGradeMapper.update(usualGrade);
        }
        return  stuTaskMapper.update(stuTask);
    }

    @Override
    public PageResult pageQuery1(Integer currentPage, Integer pageSize, String queryString, String stu_code) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        HashMap<String,String> map=new HashMap<>();
        map.put("queryString",queryString);
        map.put("stu_code",stu_code);
        List<StuTask> list = stuTaskMapper.findPage1(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<StuTask> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult pageQuery2(Integer currentPage, Integer pageSize, String queryString, String stu_code) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        HashMap<String,String> map=new HashMap<>();
        map.put("queryString",queryString);
        map.put("stu_code",stu_code);
        List<StuTask> list = stuTaskMapper.findPage2(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<StuTask> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int add(StuTask stuTask) {
        return stuTaskMapper.add(stuTask);
    }
    @Override
    public PageResult pageQuery3(Integer currentPage, Integer pageSize, String queryString, Teacher teacher) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        String teac_id=teacher.getTeac_id();
        HashMap map=new HashMap();
        map.put("teac_id",teac_id);
        map.put("queryString",queryString);
        List<Task> list = stuTaskMapper.findPage2(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<Task> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult pageQuery4(Integer currentPage, Integer pageSize, String queryString, Teacher teacher) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        String teac_id=teacher.getTeac_id();
        HashMap map=new HashMap();
        map.put("teac_id",teac_id);
        map.put("queryString",queryString);
        List<Task> list = stuTaskMapper.findPage3(map);
        // 3：封装PageHelp对应的结果集
        PageInfo<Task> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public StuTask findByAnswer(String stuTask_answer) {
        return stuTaskMapper.findByAnswer(stuTask_answer);
    }

    @Override
    public int delete(String task_id) {

        return stuTaskMapper.delete(task_id);
    }
}
