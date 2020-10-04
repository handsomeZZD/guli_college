package com.zzd.eduservice.dao;

import com.zzd.eduservice.entity.EduCourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzd.eduservice.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@Mapper
public interface EduCourseDao extends BaseMapper<EduCourseEntity> {
	//获取发布课程前的信息
	public CoursePublishVo getCoursePublish(String courseId);
}
