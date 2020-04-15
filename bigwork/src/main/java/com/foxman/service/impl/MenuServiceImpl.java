package com.foxman.service.impl;

import com.foxman.mapper.MenuMapper;
import com.foxman.pojo.Menu;
import com.foxman.pojo.Student;
import com.foxman.pojo.Teacher;
import com.foxman.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Package: com.foxman.service.impl
 * @ClassName: MenuServiceImpl
 * @Author: Foxman
 * @Date: 2020/2/10 13:32
 * @Version: 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ArrayList<Menu> getMenuList(Object loginStu) {
        String keyword = "";
        if (loginStu instanceof Student) {
            keyword="teacher";
        }else if(loginStu instanceof Teacher){
            keyword="student";
        }else{
            return null;
        }
        ArrayList<Menu> menus=menuMapper.getMenuList(keyword);
        return menus;
    }
}
