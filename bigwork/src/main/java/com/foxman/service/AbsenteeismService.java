package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Absenteeism;

/**
 * @Package: com.foxman.service
 * @ClassName: AbsenteeismService
 * @Author: Foxman
 * @Date: 2020/2/19 11:29
 * @Version: 1.0
 */
public interface AbsenteeismService {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Absenteeism findById(String abs_id);

    int update(Absenteeism absenteeism);

    int delete(String abs_id);

    int add(Absenteeism absenteeism);

}
