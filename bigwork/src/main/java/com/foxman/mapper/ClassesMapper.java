package com.foxman.mapper;

import com.foxman.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: ClassesMapper
 * @Author: Foxman
 * @Date: 2020/2/15 10:28
 * @Version: 1.0
 */
@Mapper
public interface ClassesMapper {
    List<Classes> findPage(String queryString);

    int add(Classes classes);

    Classes findById(String class_id);

    int update(Classes classes);

    int deleteById(String class_id);

    int deleteByAcademyId(String academy_id);

    void deleteByMajorId(String major_id);
}
