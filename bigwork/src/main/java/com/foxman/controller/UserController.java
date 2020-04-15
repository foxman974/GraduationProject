package com.foxman.controller;

import com.foxman.entity.Result;
import com.foxman.entity.UserLogin;
import com.foxman.pojo.Student;
import com.foxman.pojo.Teacher;
import com.foxman.service.StudentService;
import com.foxman.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Package: com.foxman.controller
 * @ClassName: UserController
 * @Author: Foxman
 * @Date: 2020/3/7 9:56
 * @Version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("login")
    @ResponseBody
    public Result login(@RequestBody UserLogin userLogin, HttpSession session){
        String role=userLogin.getRole();
        if ("学生".equals(role)){
            Student student=new Student();
            student.setStu_pwd(userLogin.getPwd());
            student.setStu_code(userLogin.getCode());
            student = studentService.checkStudentByCodeAndPwd(student.getStu_code(),student.getStu_pwd());
            if (student!=null){

                session.setAttribute("loginUser",student);
            }else{
                return new Result(false,"用户名或密码错误，请重新输入后再试！");
            }
        }else if("教师".equals(role)){
            Teacher teacher=new Teacher();
            teacher.setTeac_code(userLogin.getCode());
            teacher.setTeac_pwd(userLogin.getPwd());
            teacher = teacherService.checkTeacher(teacher);
            if (teacher!=null){
                session.setAttribute("loginUser",teacher);
            }else{
                return new Result(false,"用户名或密码错误，请重新输入后再试！");
            }
        }else{
            return new Result(false,"请选择您的角色！");
        }
        return new Result(true,"登录成功");
    }
    //退出登录
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session){
        try {
            session.removeAttribute("loginUser");
            return new Result(true,"注销成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"系统忙请稍后再试！");
        }

    }
    @RequestMapping("/getLoginUser")
    @ResponseBody
    public Result getLoginUser(HttpSession session, HttpServletResponse response) {
        Object loginUser =session.getAttribute("loginUser");
        if (loginUser==null){
            return new Result(false, "User Not Login ");
        }
        if (loginUser instanceof Student){
            Student student=(Student)loginUser;

            Cookie cookie=new Cookie("code",student.getStu_code());
            response.addCookie(cookie);
            return new Result(true, "student",loginUser);

        }else if (loginUser instanceof Teacher){
            Teacher teacher=(Teacher)loginUser;
            Cookie cookie=new Cookie("code",teacher.getTeac_code());
            response.addCookie(cookie);
            return new Result(true, "teacher",loginUser);
        }
        return new Result(false,"系统忙，请稍后再试");
    }

    @RequestMapping("restPwd")
    @ResponseBody
    public Result restPwd(@RequestBody Map<String,String> map){
        String code=null;
        String name=null;
        String birthday=null;
        String role=null;
        if (map!=null&&map.size()>0){
            code=map.get("code");
            name=map.get("name");
            birthday=map.get("birthday");
            role=map.get("role");
        }
        if ("学生".equals(role)){
           Student student=new Student();
           student.setStu_code(code);
           student.setStu_name(name);
           student.setStu_birthday(birthday);
           student=studentService.restPwd(student);
           if (student!=null){
               return new Result(true,"密码重置成功，请直接登录！");
           }else{
               return new Result(false,"未找到该用户，请重新输入信息！");
           }

        }else if("教师".equals(role)) {
            Teacher teacher=new Teacher();
            teacher.setTeac_code(code);
            teacher.setTeac_name(name);
            teacher.setTeac_birthday(birthday);
            teacher=teacherService.restPwd(teacher);
            if (teacher!=null){
                return new Result(true,"密码重置成功，请直接登录！");
            }else{
                return new Result(false,"未找到该用户，请重新输入信息！");
            }
        }else{
            return new Result(false,"请选择您的角色！");
        }
    }
}
