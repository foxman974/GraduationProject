package com.foxman.service.impl;


import com.foxman.entity.MD5Utils;
import com.foxman.entity.PageResult;
import com.foxman.mapper.TeacherMapper;
import com.foxman.pojo.Teacher;
import com.foxman.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.ecut.service.impl
 * @ClassName: TeacherServiceImpl
 * @Author: Foxman
 * @Date: 2020/1/22 14:00
 * @Version: 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public Teacher checkTeacher(Teacher teacher) {
        teacher.setTeac_pwd(MD5Utils.md5(teacher.getTeac_pwd()));
        return teacherMapper.selectTeacher(teacher);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 方案二：使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage,pageSize);
        // 2：查询数据
        List<Teacher> list = teacherMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Teacher findById(String teac_id) {

        return teacherMapper.findById(teac_id);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int delete(String teac_id) {
        return teacherMapper.deleteById(teac_id);
    }

    @Override
    public int add(Teacher teacher) {
        teacher.setTeac_pwd(MD5Utils.md5(teacher.getTeac_code()));
        return teacherMapper.add(teacher);
    }

    @Override
    public Teacher restPwd(Teacher teacher) {
        teacher=teacherMapper.checkTeacherByCodeAndNameAndBirthday(teacher);
        if (teacher != null) {
            teacher.setTeac_pwd(MD5Utils.md5(teacher.getTeac_code()));
            int result=teacherMapper.update(teacher);
            if (result>0){
                return teacher;
            }
        }
        return null;
    }
}
