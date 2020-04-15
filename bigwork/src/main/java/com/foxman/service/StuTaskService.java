package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.StuTask;
import com.foxman.pojo.Teacher;

/**
 * @Package: com.foxman.service
 * @ClassName: StuTaskService
 * @Author: Foxman
 * @Date: 2020/3/6 14:11
 * @Version: 1.0
 */
public interface StuTaskService {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString,String stu_code);

    int update(StuTask stuTask);

    PageResult pageQuery1(Integer currentPage, Integer pageSize, String queryString, String stu_code);

    PageResult pageQuery2(Integer currentPage, Integer pageSize, String queryString, String stu_code);

    int add(StuTask stuTask);

    PageResult pageQuery3(Integer currentPage, Integer pageSize, String queryString, Teacher teacher);

    PageResult pageQuery4(Integer currentPage, Integer pageSize, String queryString, Teacher teacher);

    StuTask findByAnswer(String stuTask_answer);

    int delete(String task_id);
}
