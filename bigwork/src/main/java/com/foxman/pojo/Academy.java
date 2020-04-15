package com.foxman.pojo;

import java.util.ArrayList;

/**
 * @Package: com.foxman.pojo
 * @ClassName: Academy
 * @Author: Foxman
 * @Date: 2020/2/12 17:39
 * @Version: 1.0
 */
public class Academy {
    private String academy_id;//学院序号
    private String academy_code;//学院编码
    private String academy_name;//学院名称
    private ArrayList<Major> majors;//院系专业

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    public String getAcademy_code() {
        return academy_code;
    }

    public void setAcademy_code(String academy_code) {
        this.academy_code = academy_code;
    }

    public String getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(String academy_id) {
        this.academy_id = academy_id;
    }

    public String getAcademy_name() {
        return academy_name;
    }

    public void setAcademy_name(String academy_name) {
        this.academy_name = academy_name;
    }
}
