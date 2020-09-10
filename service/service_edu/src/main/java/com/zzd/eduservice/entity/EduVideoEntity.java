package com.zzd.eduservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程视频
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@Data
@TableName("edu_video")
public class EduVideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 视频ID
	 */
	@TableId
	private String id;
	/**
	 * 课程ID
	 */
	private String courseId;
	/**
	 * 章节ID
	 */
	private String chapterId;
	/**
	 * 节点名称
	 */
	private String title;
	/**
	 * 云端视频资源
	 */
	private String videoSourceId;
	/**
	 * 原始文件名称
	 */
	private String videoOriginalName;
	/**
	 * 排序字段
	 */
	private Integer sort;
	/**
	 * 播放次数
	 */
	private Long playCount;
	/**
	 * 是否可以试听：0收费 1免费
	 */
	private Integer isFree;
	/**
	 * 视频时长（秒）
	 */
	private Float duration;
	/**
	 * Empty未上传 Transcoding转码中  Normal正常
	 */
	private String status;
	/**
	 * 视频源文件大小（字节）
	 */
	private Long size;
	/**
	 * 乐观锁
	 */
	private Long version;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;

}
