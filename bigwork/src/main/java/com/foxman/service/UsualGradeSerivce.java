package com.foxman.service;

import com.foxman.entity.PageResult;

/**
 * @Package: com.foxman.service
 * @ClassName: UsualGradeSerivce
 * @Author: Foxman
 * @Date: 2020/4/13 15:56
 * @Version: 1.0
 */
public interface UsualGradeSerivce {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
}
