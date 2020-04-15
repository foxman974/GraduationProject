package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Major;
import com.foxman.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.foxman.controller
 * @ClassName: MajorController
 * @Author: Foxman
 * @Date: 2020/2/12 17:33
 * @Version: 1.0
 */
@Controller
@RequestMapping("major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = majorService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param major_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String major_id) {
        Major major= majorService.findById(major_id);

        return new Result(true, "表单回显成功", major);
    }

    /**
     * 编辑
     *
     * @param major
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Major major) {
        int result = majorService.update(major);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param major_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String major_id) {
        int result = majorService.delete(major_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Major major) {
        int result = majorService.add(major);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }
}
