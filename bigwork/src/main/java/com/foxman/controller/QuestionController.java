package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Question;
import com.foxman.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Package: com.foxman.controller
 * @ClassName: QuestionController
 * @Author: Foxman
 * @Date: 2020/3/10 10:56
 * @Version: 1.0
 */
@Controller
@RequestMapping("que")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Question question){
        int result = questionService.insert(question);
        if (result>0){
            return new Result(true,"添加成功！");
        }
        return new Result(false,"添加失败！");

    }
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = questionService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }
    /**
     * 根据id查询
     *
     * @param que_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String que_id) {
        Question question = questionService.findById(que_id);
        return new Result(true, "表单回显成功", question);
    }
    /**
     * 根据课程id查询
     *
     * @param course_id
     * @return Result
     */
    @RequestMapping("findByCourseId")
    @ResponseBody
    public Result findByCourseId(String course_id) {
        ArrayList<Map<String,String>>  questions= questionService.findByCourseId(course_id);
        return new Result(true, "查询成功", questions);
    }
    /**
     * 编辑
     *
     * @param question
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Question question) {
        int result = questionService.update(question);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param que_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String que_id) {
        int result = questionService.delete(que_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

}
