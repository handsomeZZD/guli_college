package com.zzd.eduservice.entity.vo.front;

import lombok.Data;

/**
 * @Author ZZD
 * @Date 2020/10/8 20:51
 * @Email 1396896729@qq.com
 * @description
 */
@Data
public class CourseFrontVo {
    private String title;
    private String teacherId;
    private String subjectParentId;
    private String subjectId;
    private String buyCountSort;
    private String gmtCreatSort;
    private String priceSort;
}
