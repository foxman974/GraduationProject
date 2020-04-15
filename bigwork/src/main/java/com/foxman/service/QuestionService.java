package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.Question;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Package: com.foxman.service
 * @ClassName: QuestionService
 * @Author: Foxman
 * @Date: 2020/3/10 11:00
 * @Version: 1.0
 */
public interface QuestionService {
    int insert(Question question);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    Question findById(String que_id);

    int update(Question question);

    int delete(String que_id);

    ArrayList<Map<String, String>> findByCourseId(String course_id);
}
