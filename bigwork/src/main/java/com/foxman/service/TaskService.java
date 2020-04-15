package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Task;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service
 * @ClassName: TaskService
 * @Author: Foxman
 * @Date: 2020/3/6 11:21
 * @Version: 1.0
 */
public interface TaskService {
    List<HashMap<String, Object>> findAll();

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Task findById(String task_id);

    int update(Task task);

    int delete(String task_id);

    int add(Task task);

    //PageResult pageQuery1(Integer currentPage, Integer pageSize, String queryString, Teacher teacher);

    //PageResult pageQuery2(Integer currentPage, Integer pageSize, String queryString, Teacher teacher);
}
