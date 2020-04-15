package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Classes;
import com.foxman.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.foxman.controller
 * @ClassName: ClassesController
 * @Author: Foxman
 * @Date: 2020/2/12 17:33
 * @Version: 1.0
 */
@Controller
@RequestMapping("classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = classesService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param class_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String class_id) {
        Classes classes= classesService.findById(class_id);
        return new Result(true, "表单回显成功", classes);
    }

    /**
     * 编辑
     *
     * @param classes
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Classes classes) {
        int result = classesService.update(classes);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param class_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String class_id) {
        int result = classesService.delete(class_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    /**
     * 新增
     * @param classes
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Classes classes) {
        int result = classesService.add(classes);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }
}
