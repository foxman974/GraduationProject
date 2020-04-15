package com.foxman.controller;

import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.StuTask;
import com.foxman.pojo.Student;
import com.foxman.pojo.Teacher;
import com.foxman.service.StuTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Package: com.foxman.controller
 * @ClassName: StuTaskController
 * @Author: Foxman
 * @Date: 2020/3/6 14:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("stuTask")
public class StuTaskController {
    @Autowired
    private StuTaskService stuTaskService;

    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(HttpSession session,@RequestBody QueryPageBean queryPageBean) {
        Student student=(Student)session.getAttribute("loginUser");
        PageResult pageResult = stuTaskService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),student.getStu_code());
        return pageResult;
    }
    @RequestMapping("findPage1")
    @ResponseBody
    public PageResult findPage1(HttpSession session,@RequestBody QueryPageBean queryPageBean) {
        Student student=(Student)session.getAttribute("loginUser");
        PageResult pageResult = stuTaskService.pageQuery1(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),student.getStu_code());
        return pageResult;
    }
    @RequestMapping("findPage2")
    @ResponseBody
    public PageResult findPage2(HttpSession session,@RequestBody QueryPageBean queryPageBean) {
        Student student=(Student)session.getAttribute("loginUser");
        PageResult pageResult = stuTaskService.pageQuery2(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),student.getStu_code());
        return pageResult;
    }
    /**
     * 分页查询1(带参数)
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage3")
    @ResponseBody
    public PageResult findPage3(HttpSession session, @RequestBody QueryPageBean queryPageBean) {
        Teacher teacher = (Teacher) session.getAttribute("loginUser");
        if (teacher != null) {
            return stuTaskService.pageQuery3(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),teacher);
        }else{
            return null;
        }

    }
    /**
     * 分页查询1(带参数)
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage4")
    @ResponseBody
    public PageResult findPage4(HttpSession session, @RequestBody QueryPageBean queryPageBean) {
        Teacher teacher = (Teacher) session.getAttribute("loginUser");
        if (teacher != null) {
            return stuTaskService.pageQuery4(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString(),teacher);
        }else{
            return null;
        }

    }

    //上传答案
    @RequestMapping("upload")
    @ResponseBody
    public Result upload(HttpSession session,  @RequestParam Map map, @RequestParam("file") MultipartFile upload) throws IOException {
        System.out.println("上传成功。。。");
        Student student=(Student)session.getAttribute("loginUser");
        String stu_id=student.getStu_id();
        String task_id=null;
        String task_code=null;
        String course_id=null;
        if (map.size() > 0) {
            course_id=map.get("course_id").toString();
            task_id=map.get("task_id").toString();
            task_code=map.get("task_code").toString();
        }
        String path = System.getProperty("user.dir");
        // 创建file对象
        File file = new File(path+"\\src\\main\\resources\\static\\uploads\\answer");
        // 判断是否存在
        if(!file.exists()) {
            // 创建目录
            file.mkdirs();
        }
        String filename=student.getStu_code()+"_"+task_code+"_answer.jpg";
        StuTask stuTask=new StuTask();
        stuTask.setTask_id(task_id);
        stuTask.setStu_id(stu_id);
        stuTask.setCourse_id(course_id);
        stuTask.setStuTask_answer(filename);
        int result = stuTaskService.update(stuTask);
        // 使用upload对象中方法就直接上传文件
        upload.transferTo(new File(file, filename));
        return new Result(true,"文件上传成功");
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody StuTask stuTask){
        int result=stuTaskService.update(stuTask);
        if (result >0) {
            return new Result(true,"批阅成功！");
        }else{
            return new Result(false,"系统忙，请稍后！！！");
        }
    }
    @RequestMapping("findByAnswer")
    @ResponseBody
    public Result findByAnswer(String stuTask_answer){
        StuTask stuTask=stuTaskService.findByAnswer(stuTask_answer);
        if (stuTask != null) {
            return new Result(true,"数据回显成功",stuTask);
        }
        return new Result(false,"数据回显失败");
    }

}
