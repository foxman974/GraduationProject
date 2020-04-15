package com.foxman.mapper;


import com.foxman.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.ecut.mapper
 * @ClassName: TeacherMapper
 * @Author: Foxman
 * @Date: 2020/1/22 13:59
 * @Version: 1.0
 */
@Mapper
public interface TeacherMapper {
    Teacher selectTeacher(Teacher teacher);

    List<Teacher> findPage(String queryString);

    Teacher findById(String teac_id);

    int update(Teacher teacher);

    int deleteById(String teac_id);

    int add(Teacher teacher);

    int deleteByAcademyId(String academy_id);

    void deleteByMajorId(String major_id);

    Teacher checkTeacherByCodeAndNameAndBirthday(Teacher teacher);
}























