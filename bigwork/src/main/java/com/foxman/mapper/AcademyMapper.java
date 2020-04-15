package com.foxman.mapper;

import com.foxman.pojo.Academy;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: AcademyMapper
 * @Author: Foxman
 * @Date: 2020/2/12 17:45
 * @Version: 1.0
 */
@Mapper
public interface AcademyMapper {
    List<Academy> findPage(String queryString);

    Academy findById(String id);

    int update(Academy academy);

    int deleteById(String academy_id);

    int add(Academy academy);

    ArrayList<Academy> findAll();
}
