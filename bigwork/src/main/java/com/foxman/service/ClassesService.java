package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Classes;

/**
 * @Package: com.foxman.service
 * @ClassName: ClassesService
 * @Author: Foxman
 * @Date: 2020/2/15 10:26
 * @Version: 1.0
 */
public interface ClassesService {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Classes findById(String class_id);

    int update(Classes classes);

    int delete(String class_id);

    int add(Classes classes);
}
