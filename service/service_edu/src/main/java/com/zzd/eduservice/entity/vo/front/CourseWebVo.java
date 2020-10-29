package com.zzd.eduservice.entity.vo.front;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author ZZD
 * @Date 2020/10/9 13:02
 * @Email 1396896729@qq.com
 * @description
 */
@Data
public class CourseWebVo {
    @ApiModelProperty("课程id")
    private String id;

    @ApiModelProperty("课程讲师id")
    private String teacherId;

    @ApiModelProperty("课程姓名")
    private String teacherName;

    @ApiModelProperty("课程头像")
    private String avatar;


    @ApiModelProperty("讲师资历")
    private String intro;

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

    @ApiModelProperty("销量")
    private Long buyCount;

    @ApiModelProperty("浏览量")
    private Long viewCount;


    private String subjectLevelOneId;

    private String subjectLevelOne;

    private String subjectLevelTwoId;

    private String subjectLevelTwo;
}
