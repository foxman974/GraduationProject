package com.foxman.mapper;

import com.foxman.pojo.UsualGrade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: UsualGradeMapper
 * @Author: Foxman
 * @Date: 2020/4/13 16:03
 * @Version: 1.0
 */
@Mapper
public interface UsualGradeMapper {
    void insert(UsualGrade usualGrade);
    void update(UsualGrade usualGrade);

    List<UsualGrade> findPage(String queryString);

    List<UsualGrade> findAll();

}
