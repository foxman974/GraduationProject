package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.AcademyMapper;
import com.foxman.mapper.ClassesMapper;
import com.foxman.mapper.MajorMapper;
import com.foxman.mapper.TeacherMapper;
import com.foxman.pojo.Academy;
import com.foxman.pojo.Major;
import com.foxman.service.MajorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: MajorServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/14 10:46
 * @Version: 1.0
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {

        // 方案二：使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage,pageSize);
        // 2：查询数据
        List<Major> list = majorMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Major> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Major findById(String major_id) {
        Major major = majorMapper.findById(major_id);
        Academy academy = academyMapper.findById(major.getAcademy_id()+"");
        major.setAcademy(academy);
        return major;
    }

    @Override
    public int update(Major major) {

        return majorMapper.update(major);
    }

    @Override
    public int delete(String major_id) {
        //删除专业之前先删除班级和教师
        //1.删除教师
        teacherMapper.deleteByMajorId(major_id);
        //2.删除班级
        classesMapper.deleteByMajorId(major_id);
        return majorMapper.deleteById(major_id);
    }

    @Override
    public int add(Major major) {
        return majorMapper.add(major);
    }
}
