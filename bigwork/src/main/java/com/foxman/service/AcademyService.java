package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Academy;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service
 * @ClassName: AcademyService
 * @Author: Foxman
 * @Date: 2020/2/12 17:37
 * @Version: 1.0
 */
public interface AcademyService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Academy findById(String id);

    int update(Academy academy);

    int delete(String academy_id);

    int add(Academy academy);

    List<HashMap<String,Object>> findAll();
    List<HashMap<String,Object>> findAll2();
}
