package com.foxman.mapper;


import com.foxman.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.ecut.mapper
 * @ClassName: StudentMapper
 * @Author: Foxman
 * @Date: 2020/1/15 10:31
 * @Version: 1.0
 */
@Mapper
public interface StudentMapper {
    //查询所有学生
    List<Student> selectAllStudent();


    Student selectStudent(Student student);

    List<Student> findPage(String queryString);

    Student findById(String stu_id);

    int update(Student student);

    int deleteById(String stu_id);

    int add(Student student);

    ArrayList<Student> findAll();

    void deleteByClassId(String class_id);

    Student checkStudentByCodeAndPwd(HashMap<String, String> map);

    Student checkStudentByCodeAndNameAndBirthday(Student student);
}
