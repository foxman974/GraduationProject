package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.StuAnswerQuestionMapper;
import com.foxman.mapper.UsualGradeMapper;
import com.foxman.pojo.StuAnswerQuestion;
import com.foxman.pojo.UsualGrade;
import com.foxman.service.StuAnswerQuestionSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: StuAnswerQuestionSerivceImpl
 * @Author: Foxman
 * @Date: 2020/4/11 11:52
 * @Version: 1.0
 */
@Service
public class StuAnswerQuestionSerivceImpl implements StuAnswerQuestionSerivce {

    @Autowired
    private StuAnswerQuestionMapper stuAnswerQuestionMapper;
    @Autowired
    private UsualGradeMapper usualGradeMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<StuAnswerQuestion> list = stuAnswerQuestionMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<StuAnswerQuestion> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int add(StuAnswerQuestion stuAnswerQuestion) {
        if (stuAnswerQuestion.getQue_getPoint()!=null && stuAnswerQuestion.getQue_getPoint().length()>0){
            UsualGrade usualGrade=new UsualGrade();
            usualGrade.setStu_id(stuAnswerQuestion.getStu_id());
            usualGrade.setCourse_id(stuAnswerQuestion.getCourse_id());
            usualGrade.setQue_point(stuAnswerQuestion.getQue_getPoint());
            usualGradeMapper.update(usualGrade);
        }

        return stuAnswerQuestionMapper.insert(stuAnswerQuestion);
    }
}
