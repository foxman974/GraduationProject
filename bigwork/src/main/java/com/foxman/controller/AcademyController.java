package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Academy;
import com.foxman.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.controller
 * @ClassName: AcademyController
 * @Author: Foxman
 * @Date: 2020/2/12 17:33
 * @Version: 1.0
 */
@Controller
@RequestMapping("academy")
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @RequestMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        List<HashMap<String,Object>> academies= null;
        try {
            academies = academyService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (academies!=null && academies.size()>0){
            return new Result(true,"查询所有学院数据成功",academies);
        }else {
            return new Result(false,"查询所有学院数据失败");
        }
    }
    @RequestMapping("queryAll2")
    @ResponseBody
    public Result queryAll2(){
        List<HashMap<String,Object>> academies= null;
        try {
            academies = academyService.findAll2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (academies!=null && academies.size()>0){
            return new Result(true,"查询所有学院数据成功",academies);
        }else {
            return new Result(false,"查询所有学院数据失败");
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
        PageResult pageResult = academyService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param academy_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String academy_id) {
        Academy academy = academyService.findById(academy_id);
        return new Result(true, "表单回显成功", academy);
    }

    /**
     * 编辑
     *
     * @param academy
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Academy academy) {
        int result = academyService.update(academy);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param academy_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String academy_id) {
        int result = academyService.delete(academy_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Academy academy) {
        int result = academyService.add(academy);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }

    }

}
