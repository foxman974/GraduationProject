package com.foxman.service.impl;


import com.foxman.entity.MD5Utils;
import com.foxman.entity.PageResult;
import com.foxman.mapper.StudentMapper;
import com.foxman.pojo.Student;
import com.foxman.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.ecut.service.impl
 * @ClassName: StudentServiceImpl
 * @Author: Foxman
 * @Date: 2020/1/15 10:35
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllStudent() {
        System.out.println("com.ecut.service.impl.StudentServiceImpl.queryAllStudent");
        return studentMapper.selectAllStudent();
    }

    @Override
    public Student checkStudent(Student student) {
        student.setStu_pwd(MD5Utils.md5(student.getStu_pwd()));
        return studentMapper.selectStudent(student);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 方案二：使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage,pageSize);
        // 2：查询数据
        List<Student> list = studentMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Student findById(String stu_id) {
        return studentMapper.findById(stu_id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int delete(String stu_id) {
        //删除学生之前删除关联数据
        //1.回答问题数据
        //2.缺勤数据
        //3.作业数据
        //4.平时成绩数据
        return studentMapper.deleteById(stu_id);
    }

    @Override
    public int add(Student student) {
        String stu_pwd= MD5Utils.md5(student.getStu_code());
        student.setStu_pwd(stu_pwd);
        return studentMapper.add(student);
    }

    @Override
    public ArrayList<HashMap<String, String>> findAll() {
        ArrayList<Student> students=studentMapper.findAll();
        ArrayList<HashMap<String,String>> studentMaps=new ArrayList<>();
        HashMap<String,String> stuMap=null;
        for (Student student : students) {
            stuMap=new HashMap<>();
            stuMap.put("label",student.getStu_name()+student.getStu_code());
            stuMap.put("value",student.getStu_id());
            studentMaps.add(stuMap);
        }
        return studentMaps;
    }

    @Override
    public Student checkStudentByCodeAndPwd(String stu_code, String stu_pwd) {
        HashMap<String,String> map=new HashMap<>();
        stu_pwd=MD5Utils.md5(stu_pwd);
        map.put("stu_code",stu_code);
        map.put("stu_pwd",stu_pwd);

        return studentMapper.checkStudentByCodeAndPwd(map);
    }

    @Override
    public Student restPwd(Student student) {
        student=studentMapper.checkStudentByCodeAndNameAndBirthday(student);
        if (student != null) {
            student.setStu_pwd(MD5Utils.md5(student.getStu_code()));
            int result=studentMapper.update(student);
            if(result>0){
                return student;
            }
        }
        return null;
    }


}
