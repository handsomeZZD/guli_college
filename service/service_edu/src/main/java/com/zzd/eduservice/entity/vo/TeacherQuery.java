package com.zzd.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZZD
 * @Date 2020/9/3 20:18
 * @Email 1396896729@qq.com
 * @description 查询讲师的条件类
 */
@Data
@ApiModel
public class TeacherQuery {
    @ApiModelProperty("讲师名字，模糊查询")
    private String name;
    @ApiModelProperty("讲师级别")
    private Integer level;
    @ApiModelProperty("查询开始时间  example:2019-01-01 10:10:10")
    private String begin;
    @ApiModelProperty("讲师级别 example:2019-01-01 10:10:10")
    private String end;
}
