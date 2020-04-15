package com.foxman.service;


import com.foxman.entity.PageResult;
import com.foxman.pojo.Teacher;

/**
 * @Package: com.ecut.service
 * @ClassName: TeacherService
 * @Author: Foxman
 * @Date: 2020/1/22 14:00
 * @Version: 1.0
 */
public interface TeacherService {
    Teacher checkTeacher(Teacher teacher);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Teacher findById(String teac_id);

    int update(Teacher teacher);

    int delete(String teac_id);

    int add(Teacher teacher);

    Teacher restPwd(Teacher teacher);
}
