package com.zzd.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author ZZD
 * @Date 2020/9/12 9:15
 * @Email 1396896729@qq.com
 * @description
 */

@Data
public class SubjectData{

    @ExcelProperty(value = "一级分类",index = 0)
    private String firstSubjectName;

    @ExcelProperty(value = "二级分类",index = 1)
    private String secondSubjectName;
}
