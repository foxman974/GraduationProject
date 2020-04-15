package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.AcademyMapper;
import com.foxman.mapper.ClassesMapper;
import com.foxman.mapper.MajorMapper;
import com.foxman.mapper.TeacherMapper;
import com.foxman.pojo.Academy;
import com.foxman.pojo.Classes;
import com.foxman.pojo.Major;
import com.foxman.service.AcademyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: AcademyServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/12 17:38
 * @Version: 1.0
 */
@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 使用mybatis的分页插件
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<Academy> list = academyMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Academy> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Academy findById(String id) {
        return academyMapper.findById(id);
    }

    @Override
    public int update(Academy academy) {
        return academyMapper.update(academy);
    }

    @Override
    public int delete(String academy_id) {
        //删除学院同时删除包含的专业班级教师
        //1.删除包含班级
        int res1=classesMapper.deleteByAcademyId(academy_id);
        //2.删除包含教师
        int res2=teacherMapper.deleteByAcademyId(academy_id);
        //3.删除包含专业
        int res3=majorMapper.deleteByAcademyId(academy_id);
        return academyMapper.deleteById(academy_id);
    }

    @Override
    public int add(Academy academy) {
        return academyMapper.add(academy);
    }

    @Override
    public List<HashMap<String, Object>> findAll() {
        ArrayList<Academy> academies = academyMapper.findAll();
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = null;

        for (Academy academy : academies) {
            HashMap<String, String> map1 = null;
            ArrayList<HashMap<String, String>> majors = new ArrayList<>();
            for (Major major : academy.getMajors()) {
                map1=new HashMap<>();
                map1.put("value",major.getMajor_id()+"");
                map1.put("label",major.getMajor_name());
                majors.add(map1);
            }
            map = new HashMap<>();
            map.put("label", academy.getAcademy_name());
            map.put("value", academy.getAcademy_id());
            map.put("children",majors);
            list.add(map);
        }
        return list;
    }
    @Override
    public List<HashMap<String, Object>> findAll2() {
        ArrayList<Academy> academies = academyMapper.findAll();
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = null;

        for (Academy academy : academies) {
            HashMap<String, Object> map1 = null;
            ArrayList<HashMap<String, Object>> majors = new ArrayList<>();
            for (Major major : academy.getMajors()) {
                map1=new HashMap<>();
                ArrayList<HashMap<String, String>> classes = new ArrayList<>();
                HashMap<String, String> map2 = null;
                for (Classes aClass : major.getClasses()) {
                    map2=new HashMap<>();
                    map2.put("value",aClass.getClass_id()+"");
                    map2.put("label",aClass.getClass_name());
                    classes.add(map2);
                }
                map1.put("value",major.getMajor_id()+"");
                map1.put("label",major.getMajor_name());
                map1.put("children",classes);
                majors.add(map1);
            }
            map = new HashMap<>();
            map.put("label", academy.getAcademy_name());
            map.put("value", academy.getAcademy_id());
            map.put("children",majors);
            list.add(map);
        }
        return list;
    }
}
