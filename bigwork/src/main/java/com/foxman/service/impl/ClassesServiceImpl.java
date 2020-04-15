package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.ClassesMapper;
import com.foxman.mapper.StudentMapper;
import com.foxman.pojo.Classes;
import com.foxman.service.ClassesService;
import com.foxman.service.MajorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: ClassesServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/15 10:27
 * @Version: 1.0
 */
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private MajorService majorService;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 方案二：使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage,pageSize);
        // 2：查询数据
        List<Classes> list = classesMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Classes> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Classes findById(String class_id) {
        Classes classes=classesMapper.findById(class_id);

        return classes;
    }

    @Override
    public int update(Classes classes) {

        return classesMapper.update(classes);
    }

    @Override
    public int delete(String class_id) {
        //删除班级之前删除所有学生
        //1.删除所有学生
        studentMapper.deleteByClassId(class_id);
        return classesMapper.deleteById(class_id);
    }

    @Override
    public int add(Classes classes) {
        //Major major = majorMapper.findById(classes.getMajor_id() + "");
        //classes.setAcademy_id(major.getAcademy_id());

        return classesMapper.add(classes);
    }
}
