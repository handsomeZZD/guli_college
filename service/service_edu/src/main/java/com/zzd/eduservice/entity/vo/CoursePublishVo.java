package com.zzd.eduservice.entity.vo;

import lombok.Data;

/**
 * @Author ZZD
 * @Date 2020/9/17 19:56
 * @Email 1396896729@qq.com
 * @description
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;
}
