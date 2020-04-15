package com.foxman.mapper;

import com.foxman.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: QuestionMapper
 * @Author: Foxman
 * @Date: 2020/3/10 11:01
 * @Version: 1.0
 */
@Mapper
public interface QuestionMapper {
    int add(Question question);

    int delete(String que_id);

    int update(Question question);

    Question findById(String que_id);

    List<Question> findPage(String queryString);

    ArrayList<Question> findByCourseId(String course_id);
}
