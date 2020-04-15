package com.foxman.mapper;

import com.foxman.pojo.StuTask;
import com.foxman.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.foxman.mapper
 * @ClassName: StuTaskMapper
 * @Author: Foxman
 * @Date: 2020/3/6 14:14
 * @Version: 1.0
 */
@Mapper
public interface StuTaskMapper {
    List<StuTask> findPage(HashMap map);

    int update(StuTask stuTask);

    List<StuTask> findPage1(HashMap<String, String> map);

    List<StuTask> findPage2(HashMap<String, String> map);

    int add(StuTask stuTask);

    List<Task> findPage3(HashMap map);

    StuTask findByAnswer(String stuTask_anwser);

    int delete(String task_id);
}
