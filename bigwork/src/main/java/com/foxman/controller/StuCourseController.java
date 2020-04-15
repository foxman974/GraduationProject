package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Course;
import com.foxman.pojo.Student;
import com.foxman.service.CourseService;
import com.foxman.service.StuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @Package: com.foxman.controller
 * @ClassName: StuCourseController
 * @Author: Foxman
 * @Date: 2020/3/9 11:43
 * @Version: 1.0
 */
@Controller
@RequestMapping("stuCourse")
public class StuCourseController {
    @Autowired
    private StuCourseService stuCourseService;

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
    public PageResult findPage(HttpSession session,@RequestBody QueryPageBean queryPageBean) {
        Student student = (Student)session.getAttribute("loginUser");
        PageResult pageResult = courseService.pageQuery2(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),student);
        return pageResult;
    }
    @RequestMapping("chooseCourse")
    @ResponseBody
    public Result chooseCourse(HttpSession session, @RequestBody ArrayList<Course> courseList){
        Student student = (Student)session.getAttribute("loginUser");
        int result=stuCourseService.chooseCourse(student,courseList);
        if (result>0){
            return new Result(true,"选课成功");
        }
        return new Result(false,"选课失败");
    }
}
