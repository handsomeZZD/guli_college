package com.zzd.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程简介
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@Data
@TableName("edu_course_description")
public class EduCourseDescriptionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 课程ID
	 */
	@TableId(type = IdType.INPUT)
	private String id;
	/**
	 * 课程简介
	 */
	private String description;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;

}
