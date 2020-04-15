package com.foxman.controller;

import com.foxman.entity.Result;
import com.foxman.pojo.Menu;
import com.foxman.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @Package: com.foxman.controller
 * @ClassName: MenuController
 * @Author: Foxman
 * @Date: 2020/2/10 13:20
 * @Version: 1.0
 */
@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("getMenu")
    @ResponseBody
    public Result getMenu(HttpSession session) {
        Object loginStu = session.getAttribute("loginUser");
        ArrayList<Menu> menuList = menuService.getMenuList(loginStu);

        return new Result(false, "获取菜单", menuList);
    }
}
