package com.foxman.mapper;

import com.foxman.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: MenuMapper
 * @Author: Foxman
 * @Date: 2020/2/12 16:37
 * @Version: 1.0
 */
@Mapper
public interface MenuMapper {

    ArrayList<Menu> getMenuList(String keyword);

    List<Menu> findChildenMenu(Integer parentMenuId);
}
