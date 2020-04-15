package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.AbsenteeismCategory;
import com.foxman.service.AbsenteeismCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.controller
 * @ClassName: AbsenteeismCategoryController
 * @Author: Foxman
 * @Date: 2020/2/19 9:51
 * @Version: 1.0
 */
@Controller
@RequestMapping("absenteeismCategory")
public class AbsenteeismCategoryController {

    @Autowired
    private AbsenteeismCategoryService absenteeismCategoryService;
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = absenteeismCategoryService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param abC_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String abC_id) {
        AbsenteeismCategory absenteeismCategory = absenteeismCategoryService.findById(abC_id);
        return new Result(true, "表单回显成功", absenteeismCategory);
    }

    /**
     * 编辑
     *
     * @param absenteeismCategory
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody AbsenteeismCategory absenteeismCategory) {
        int result = absenteeismCategoryService.update(absenteeismCategory);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param abC_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String abC_id) {
        int result = absenteeismCategoryService.delete(abC_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody AbsenteeismCategory absenteeismCategory) {
        int result = absenteeismCategoryService.add(absenteeismCategory);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }
    @RequestMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        ArrayList<HashMap<String,String>> list=null;
        try {
            list= absenteeismCategoryService.findAll();
            if (list!=null && list.size()>0){
                return new Result(true,"查询所有缺勤类型成功",list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"查询所有缺勤类型失败");

    }
}
