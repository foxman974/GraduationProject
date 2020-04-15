package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Course;
import com.foxman.pojo.Teacher;
import com.foxman.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.foxman.controller
 * @ClassName: CourseController
 * @Author: Foxman
 * @Date: 2020/2/12 17:33
 * @Version: 1.0
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = courseService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPageByTeacId")
    @ResponseBody
    public PageResult findPageByTeacId(HttpSession session, @RequestBody QueryPageBean queryPageBean) {
        Teacher teacher=(Teacher)session.getAttribute("loginUser");
        PageResult pageResult = courseService.pageQuery3(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),teacher);
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param course_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String course_id) {
        Course course = courseService.findById(course_id);
        return new Result(true, "表单回显成功", course);
    }

    /**
     * 编辑
     *
     * @param course
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Course course) {
        int result = courseService.update(course);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param course_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String course_id) {
        int result = courseService.delete(course_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Course course) {
        int result = courseService.add(course);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        ArrayList<HashMap<String,String>> list =null;
        try {
            list = courseService.findAll();
            if (list!=null && list.size()>0){
                return new Result(true,"查询所有课程成功",list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"查询所有课程成功");
    }
}
