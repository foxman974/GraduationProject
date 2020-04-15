package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Teacher;
import com.foxman.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.ecut.controller
 * @ClassName: TeacherController
 * @Author: Foxman
 * @Date: 2020/1/22 14:00
 * @Version: 1.0
 */
@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = teacherService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param teac_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String teac_id) {
        Teacher teacher= teacherService.findById(teac_id);
        return new Result(true, "表单回显成功", teacher);
    }

    /**
     * 编辑
     *
     * @param teacher
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Teacher teacher) {
        int result = teacherService.update(teacher);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param teac_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String teac_id) {
        int result = teacherService.delete(teac_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    /**
     * 新增
     * @param teacher
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Teacher teacher) {
        int result = teacherService.add(teacher);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }
}
