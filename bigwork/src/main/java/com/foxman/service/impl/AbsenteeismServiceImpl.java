package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.AbsenteeismCategoryMapper;
import com.foxman.mapper.AbsenteeismMapper;
import com.foxman.mapper.UsualGradeMapper;
import com.foxman.pojo.Absenteeism;
import com.foxman.pojo.AbsenteeismCategory;
import com.foxman.pojo.UsualGrade;
import com.foxman.service.AbsenteeismService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: AbsenteeismServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/19 11:30
 * @Version: 1.0
 */
@Service
public class AbsenteeismServiceImpl implements AbsenteeismService {
    @Autowired
    private AbsenteeismMapper absenteeismMapper;
    @Autowired
    private UsualGradeMapper usualGradeMapper;
    @Autowired
    private AbsenteeismCategoryMapper absenteeismCategoryMapper;
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<Absenteeism> list = absenteeismMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<Absenteeism> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());

    }

    @Override
    public Absenteeism findById(String abs_id) {
        return absenteeismMapper.findById(abs_id);
    }

    @Override
    public int update(Absenteeism absenteeism) {
        return absenteeismMapper.update(absenteeism);
    }

    @Override
    public int delete(String abs_id) {
        return absenteeismMapper.deleteById(abs_id);
    }

    @Override
    public int add(Absenteeism absenteeism) {
        AbsenteeismCategory abc = absenteeismCategoryMapper.findById(absenteeism.getAbC_id());
        if (absenteeism.getAbsenteeismCategory().getAbC_deductMarks()!=null &&
                absenteeism.getAbsenteeismCategory().getAbC_deductMarks().length()>0){
            UsualGrade usualGrade=new UsualGrade();
            usualGrade.setStu_id(absenteeism.getStu_id());
            usualGrade.setCourse_id(absenteeism.getCourse_id());
            usualGrade.setAbs_point(abc.getAbC_deductMarks());
            usualGradeMapper.update(usualGrade);

        }
        return absenteeismMapper.add(absenteeism);
    }

}
