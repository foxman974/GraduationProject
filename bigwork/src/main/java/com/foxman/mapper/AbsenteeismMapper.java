package com.foxman.mapper;

import com.foxman.pojo.Absenteeism;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: AsenteeismMapper
 * @Author: Foxman
 * @Date: 2020/2/19 11:31
 * @Version: 1.0
 */
@Mapper
public interface AbsenteeismMapper {
    List<Absenteeism> findPage(String queryString);

    Absenteeism findById(String abs_id);

    int update(Absenteeism absenteeism);

    int deleteById(String abs_id);

    int add(Absenteeism absenteeism);

}
