package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Task;
import com.foxman.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.controller
 * @ClassName: TaskController
 * @Author: Foxman
 * @Date: 2020/3/6 11:16
 * @Version: 1.0
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        List<HashMap<String,Object>> academies= null;
        try {
            academies = taskService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (academies!=null && academies.size()>0){
            return new Result(true,"查询所有作业数据成功",academies);
        }else {
            return new Result(false,"查询所有作业数据失败");
        }
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

        PageResult pageResult = taskService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }


    /**
     * 根据id查询
     *
     * @param task_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String task_id) {
        Task task = taskService.findById(task_id);
        return new Result(true, "表单回显成功", task);
    }

    /**
     * 编辑
     *
     * @param task
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Task task) {
        int result = taskService.update(task);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param task_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String task_id) {
        int result = taskService.delete(task_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Task task) {
        int result = taskService.add(task);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }


}
