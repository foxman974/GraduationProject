package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.StuAnswerQuestion;
import com.foxman.service.StuAnswerQuestionSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.foxman.controller
 * @ClassName: StuAnswerQuestionController
 * @Author: Foxman
 * @Date: 2020/4/8 11:21
 * @Version: 1.0
 */
@Controller
@RequestMapping("stuAnswerQuestion")
public class StuAnswerQuestionController {
    @Autowired
    private StuAnswerQuestionSerivce stuAnswerQuestionSerivce;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = stuAnswerQuestionSerivce.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody StuAnswerQuestion stuAnswerQuestion){
        int result=stuAnswerQuestionSerivce.add(stuAnswerQuestion);
        if(result>0){
            return new Result(true,"新增学生回答记录成功！");
        }
        return new Result(false,"新增失败");
    }


}
