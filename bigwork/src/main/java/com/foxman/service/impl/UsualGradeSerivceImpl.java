package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.UsualGradeMapper;
import com.foxman.pojo.Course;
import com.foxman.pojo.UsualGrade;
import com.foxman.service.AcademyService;
import com.foxman.service.StuAnswerQuestionSerivce;
import com.foxman.service.StuTaskService;
import com.foxman.service.UsualGradeSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: UsualGradeSerivceImpl
 * @Author: Foxman
 * @Date: 2020/4/13 15:56
 * @Version: 1.0
 */
@Service
public class UsualGradeSerivceImpl implements UsualGradeSerivce {
    @Autowired
    private StuAnswerQuestionSerivce stuAnswerQuestionSerivce;
    @Autowired
    private StuTaskService stuTaskService;
    @Autowired
    private AcademyService academyService;
    @Autowired
    private UsualGradeMapper usualGradeMapper;

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<UsualGrade> list1 = usualGradeMapper.findAll();
        double grade1=0;
        double grade2=0;
        double grade3=0;
        double grade4=0;
        double grade5=0;
        Course course=null;
        for (UsualGrade usualGrade : list1) {//统计成绩
            course=usualGrade.getCourse();
            grade1=Double.parseDouble(usualGrade.getAbs_point())*Double.parseDouble(course.getCourse_checking());
            grade2=Double.parseDouble(usualGrade.getQue_point())*Double.parseDouble(course.getCourse_answer());
            grade3=Double.parseDouble(usualGrade.getTask_point())*Double.parseDouble(course.getCourse_task());
            grade4=Double.parseDouble(usualGrade.getOther_point());
            grade5=grade1+grade2+grade3+grade4;
            usualGrade.setAll_point(grade5+"");
            usualGradeMapper.update(usualGrade);//更新到数据库
        }
        List<UsualGrade> list2 = usualGradeMapper.findPage(queryString);

        // 3：封装PageHelp对应的结果集
        PageInfo<UsualGrade> pageInfo = new PageInfo<>(list2);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
