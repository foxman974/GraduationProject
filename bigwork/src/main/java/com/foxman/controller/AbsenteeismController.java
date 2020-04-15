package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Absenteeism;
import com.foxman.service.AbsenteeismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.foxman.controller
 * @ClassName: AbsenteeismController
 * @Author: Foxman
 * @Date: 2020/2/19 9:51
 * @Version: 1.0
 */
@Controller
@RequestMapping("absenteeism")
public class AbsenteeismController {

    @Autowired
    private AbsenteeismService absenteeismService;
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = absenteeismService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param abs_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String abs_id) {
        Absenteeism absenteeism = absenteeismService.findById(abs_id);
        return new Result(true, "表单回显成功", absenteeism);
    }

    /**
     * 编辑
     *
     * @param absenteeism
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Absenteeism absenteeism) {
        int result = absenteeismService.update(absenteeism);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param abs_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String abs_id) {
        int result = absenteeismService.delete(abs_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Absenteeism absenteeism) {
        int result = absenteeismService.add(absenteeism);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }
    }


}
