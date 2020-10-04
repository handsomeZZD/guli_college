package com.zzd.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author ZZD
 * @Date 2020/9/13 10:10
 * @Email 1396896729@qq.com
 * @description
 */
@Data
@ApiModel
public class CourseVO {

    @ApiModelProperty("课程id")
    private String id;
    @ApiModelProperty("课程讲师id")
    private String teacherId;
    @ApiModelProperty("课程分类id")
    private String subjectId;
    @ApiModelProperty("课程分类父id")
    private String subjectParentId;
    @ApiModelProperty("课程标题")
    private String title;
    @ApiModelProperty("课程价格")
    private BigDecimal price;
    @ApiModelProperty("课程总课时")
    private Integer lessNum;
    @ApiModelProperty("课程封面图片")
    private String cover;
    @ApiModelProperty("课程描述")
    private String description;
}
