package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.AbsenteeismCategory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.service
 * @ClassName: AbsenteeismCategoryService
 * @Author: Foxman
 * @Date: 2020/2/19 9:54
 * @Version: 1.0
 */
public interface AbsenteeismCategoryService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    AbsenteeismCategory findById(String abC_id);

    int update(AbsenteeismCategory absenteeismCategory);

    int delete(String abC_id);

    int add(AbsenteeismCategory absenteeismCategory);

    ArrayList<HashMap<String, String>> findAll();
}
