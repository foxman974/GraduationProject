package com.foxman.service;

import com.foxman.entity.PageResult;
import com.foxman.pojo.StuAnswerQuestion;

/**
 * @Package: com.foxman.service
 * @ClassName: StuAnswerQuestionSerivce
 * @Author: Foxman
 * @Date: 2020/4/11 11:50
 * @Version: 1.0
 */
public interface StuAnswerQuestionSerivce {
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    int add(StuAnswerQuestion stuAnswerQuestion);
}
