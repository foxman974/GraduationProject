package com.foxman.pojo;

/**
 * @Package: com.foxman.pojo
 * @ClassName: AbsenteeismCategory
 * @Author: Foxman
 * @Date: 2020/2/14 10:29
 * @Version: 1.0
 */
public class AbsenteeismCategory {

    private String abC_id;//缺勤类型序号
    private String abC_code;//缺勤类型编号
    private String abC_category;//缺勤类型
    private String abC_deductMarks;//扣分

    public String getAbC_id() {
        return abC_id;
    }

    public void setAbC_id(String abC_id) {
        this.abC_id = abC_id;
    }

    public String getAbC_code() {
        return abC_code;
    }

    public void setAbC_code(String abC_code) {
        this.abC_code = abC_code;
    }

    public String getAbC_category() {
        return abC_category;
    }

    public void setAbC_category(String abC_category) {
        this.abC_category = abC_category;
    }

    public String getAbC_deductMarks() {
        return abC_deductMarks;
    }

    public void setAbC_deductMarks(String abC_deductMarks) {
        this.abC_deductMarks = abC_deductMarks;
    }
}
