package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.QuestionMapper;
import com.foxman.pojo.Question;
import com.foxman.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: QuestionServiceImpl
 * @Author: Foxman
 * @Date: 2020/3/10 11:00
 * @Version: 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int insert(Question question) {
        return questionMapper.add(question);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<Question> list = questionMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Question findById(String que_id) {
        return questionMapper.findById(que_id);
    }

    @Override
    public int update(Question question) {
        return questionMapper.update(question);
    }

    @Override
    public int delete(String que_id) {
        //删除已回答的该问题

        return questionMapper.delete(que_id);
    }

    @Override
    public ArrayList<Map<String, String>> findByCourseId(String course_id) {
        ArrayList<Question> questionList=questionMapper.findByCourseId(course_id);
        ArrayList<Map<String,String>> questions =new ArrayList<>();
        HashMap<String,String> map=null;
        for (Question question : questionList) {
            map=new HashMap<>();
            map.put("label",question.getQue_code().toString());
            map.put("value1",question.getQue_id().toString());
            questions.add(map);
        }
        return questions;
    }
}
