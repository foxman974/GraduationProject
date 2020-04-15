package com.foxman.service.impl;

import com.foxman.entity.PageResult;
import com.foxman.mapper.AbsenteeismCategoryMapper;
import com.foxman.pojo.AbsenteeismCategory;
import com.foxman.service.AbsenteeismCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: AbsenteeismCategoryServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/19 9:55
 * @Version: 1.0
 */
@Service
public class AbsenteeismCategoryServiceImpl implements AbsenteeismCategoryService {
    @Autowired
    private AbsenteeismCategoryMapper absenteeismCategoryMapper;
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        // 1：初始化参数
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询数据
        List<AbsenteeismCategory> list = absenteeismCategoryMapper.findPage(queryString);
        // 3：封装PageHelp对应的结果集
        PageInfo<AbsenteeismCategory> pageInfo = new PageInfo<>(list);
        // 封装数据
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public AbsenteeismCategory findById(String abC_id) {
        return absenteeismCategoryMapper.findById(abC_id);
    }

    @Override
    public int update(AbsenteeismCategory absenteeismCategory) {
        return absenteeismCategoryMapper.update(absenteeismCategory);
    }

    @Override
    public int delete(String abC_id) {
        return absenteeismCategoryMapper.deleteById(abC_id);
    }

    @Override
    public int add(AbsenteeismCategory absenteeismCategory) {
        return absenteeismCategoryMapper.add(absenteeismCategory);
    }

    @Override
    public ArrayList<HashMap<String, String>> findAll() {
        ArrayList<HashMap<String,String>> list =new ArrayList<>();
        ArrayList<AbsenteeismCategory> absenteeismCategories = absenteeismCategoryMapper.findAll();
        HashMap<String,String> abC=null;
        for (AbsenteeismCategory absenteeismCategory : absenteeismCategories) {
            abC=new HashMap<>();
            abC.put("label",absenteeismCategory.getAbC_category());
            abC.put("value1",absenteeismCategory.getAbC_id()+"");
            list.add(abC);
        }
        return list;
    }
}
