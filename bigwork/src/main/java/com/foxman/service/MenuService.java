package com.foxman.service;

import com.foxman.pojo.Menu;

import java.util.ArrayList;

/**
 * @Package: com.foxman.service
 * @ClassName: MenuService
 * @Author: Foxman
 * @Date: 2020/2/10 13:30
 * @Version: 1.0
 */
public interface MenuService {
    ArrayList<Menu> getMenuList(Object loginStu);
}
