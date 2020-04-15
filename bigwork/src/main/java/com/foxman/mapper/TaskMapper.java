package com.foxman.mapper;

import com.foxman.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: TaskMapper
 * @Author: Foxman
 * @Date: 2020/3/6 11:23
 * @Version: 1.0
 */
@Mapper
public interface TaskMapper {
    List<Task> findPage(String queryString);

    Task findById(String task_id);

    int update(Task task);

    int deleteById(String task_id);

    int add(Task task);

    List<Task> findPage2(HashMap map);
    
}
