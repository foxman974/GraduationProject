package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Major;

/**
 * @Package: com.foxman.service
 * @ClassName: MajorService
 * @Author: Foxman
 * @Date: 2020/2/14 10:45
 * @Version: 1.0
 */

public interface MajorService {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Major findById(String major_id);

    int update(Major major);

    int delete(String major_id);

    int add(Major major);
}
