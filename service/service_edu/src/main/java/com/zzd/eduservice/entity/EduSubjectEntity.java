package com.zzd.eduservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程科目
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@Data
@TableName("edu_subject")
public class EduSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 课程类别ID
	 */
	@TableId
	private String id;
	/**
	 * 类别名称
	 */
	private String title;
	/**
	 * 父ID
	 */
	private String parentId;
	/**
	 * 排序字段
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;

}
