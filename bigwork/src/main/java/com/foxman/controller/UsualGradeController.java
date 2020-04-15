package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.service.UsualGradeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.foxman.controller
 * @ClassName: UsualGradeController
 * @Author: Foxman
 * @Date: 2020/4/13 15:55
 * @Version: 1.0
 */
@RequestMapping("usualGrade")
@Controller
public class UsualGradeController {
    @Autowired
    private UsualGradeSerivce usualGradeSerivce;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = usualGradeSerivce.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

}
