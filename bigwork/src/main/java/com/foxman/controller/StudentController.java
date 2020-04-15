package com.foxman.controller;


import com.foxman.entity.MD5Utils;
import com.foxman.entity.PageResult;
import com.foxman.entity.QueryPageBean;
import com.foxman.entity.Result;
import com.foxman.pojo.Student;
import com.foxman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.ecut.controller
 * @ClassName: StudentController
 * @Author: Foxman
 * @Date: 2020/1/15 10:38
 * @Version: 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = studentService.pageQuery(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;
    }

    /**
     * 根据id查询
     *
     * @param stu_id
     * @return Result
     */
    @RequestMapping("findById")
    @ResponseBody
    public Result findById(String stu_id) {
        Student student= studentService.findById(stu_id);
        return new Result(true, "表单回显成功", student);
    }

    /**
     * 编辑
     *
     * @param student
     * @return Result
     */
    @RequestMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Student student) {
        int result = studentService.update(student);
        if (result > 0) {
            return new Result(true, "修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param stu_id
     * @return Result
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String stu_id) {
        int result = studentService.delete(stu_id);
        if (result > 0) {
            return new Result(true, "删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Student student) {
        int result = studentService.add(student);
        if (result > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(true, "添加失败");
        }
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public Result queryAll(){
        ArrayList<HashMap<String,String>> list=null;
        try {
            list=studentService.findAll();
            if (list!=null && list.size()>0){
                return new Result(true,"查询所有学生数据成功",list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"查询所有学生数据成功");
    }
    //上传头像
    @RequestMapping("changePortrait")
    @ResponseBody
    public Result upload(@RequestParam Map map, @RequestParam("file") MultipartFile upload) throws IOException {
        //System.out.println("上传成功。。。");
        //Student student=(Student)session.getAttribute("loginUser");
        //String stu_id=student.getStu_id();
        String stu_code=null;
        if (map.size() > 0) {
            stu_code=map.get("code").toString();
        }
        String path = System.getProperty("user.dir");
        // 创建file对象
        File file = new File(path+"\\src\\main\\resources\\static\\uploads\\headPortrait");
        // 判断是否存在
        if(!file.exists()) {
            // 创建目录
            file.mkdirs();
        }
        String filename=stu_code+"_headPortrait.jpg";
        //int result = studentService.update(stu_id,course_id,filename);
        // 使用upload对象中方法就直接上传文件
        upload.transferTo(new File(file, filename));
        return new Result(true,"头像上传成功");
    }

    @RequestMapping("editPwd")
    @ResponseBody
    public Result editPwd(@RequestBody() Map map){
        String stu_code=map.get("code").toString();
        String stu_pwd= map.get("oldPwd").toString();
        String newPwd=MD5Utils.md5(map.get("newPwd").toString());
        Student student=studentService.checkStudentByCodeAndPwd(stu_code,stu_pwd);
        int result=0;
        if (student!=null){
            student.setStu_pwd(newPwd);
            result=studentService.update(student);
            if (result >0) {
                return new Result(true,"密码修改成功，请重新登录！");
            }
        }else{
            return new Result(false,"原密码输入错误，请重新输入！");
        }

        return  new Result(false,"系统忙请稍后再试！");
    }
}
