package com.foxman.mapper;

import com.foxman.pojo.StuAnswerQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: StuAnswerQuestionMapper
 * @Author: Foxman
 * @Date: 2020/4/11 11:53
 * @Version: 1.0
 */
@Mapper
public interface StuAnswerQuestionMapper {
    List<StuAnswerQuestion> findPage(String queryString);

    int insert(StuAnswerQuestion stuAnswerQuestion);
}
