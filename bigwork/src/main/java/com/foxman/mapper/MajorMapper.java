package com.foxman.mapper;

import com.foxman.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: MajorMapper
 * @Author: Foxman
 * @Date: 2020/2/14 10:48
 * @Version: 1.0
 */
@Mapper
public interface MajorMapper {
    List<Major> findPage(String queryString);

    int add(Major major);

    Major findById(String major_id);

    int update(Major major);

    int deleteById(String major_id);

    int deleteByAcademyId(String academy_id);
}
