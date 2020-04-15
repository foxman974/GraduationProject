package com.foxman.service;


import com.foxman.entity.PageResult;
import com.foxman.pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.ecut.service
 * @ClassName: StudentService
 * @Author: Foxman
 * @Date: 2020/1/15 10:34
 * @Version: 1.0
 */
public interface StudentService {

    //查询所有学生

    List<Student> queryAllStudent();
    //登录
    Student checkStudent(Student student);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Student findById(String teac_id);

    int update(Student student);

    int delete(String stu_id);

    int add(Student student);

    ArrayList<HashMap<String, String>> findAll();

    Student checkStudentByCodeAndPwd(String stu_code, String stu_pwd);

    Student restPwd(Student student);
}
