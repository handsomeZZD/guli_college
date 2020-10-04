package com.zzd.eduservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@Data
@TableName("edu_chapter")
public class EduChapterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 章节ID
	 */
	@TableId
	private String id;
	/**
	 * 课程ID
	 */
	private String courseId;
	/**
	 * 章节名称
	 */
	private String title;
	/**
	 * 显示排序
	 */
	private Integer sort;
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
