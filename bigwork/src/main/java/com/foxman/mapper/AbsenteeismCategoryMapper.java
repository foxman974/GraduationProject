package com.foxman.mapper;

import com.foxman.pojo.AbsenteeismCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: AbsenteeismCategoryMapper
 * @Author: Foxman
 * @Date: 2020/2/19 9:58
 * @Version: 1.0
 */
@Mapper
public interface AbsenteeismCategoryMapper {
    List<AbsenteeismCategory> findPage(String queryString);

    AbsenteeismCategory findById(String abC_id);

    int update(AbsenteeismCategory absenteeismCategory);

    int deleteById(String abC_id);

    int add(AbsenteeismCategory absenteeismCategory);

    ArrayList<AbsenteeismCategory> findAll();
}
