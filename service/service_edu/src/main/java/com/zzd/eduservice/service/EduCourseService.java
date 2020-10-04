package com.zzd.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.entity.vo.CoursePublishVo;
import com.zzd.eduservice.entity.vo.CourseVO;
import com.zzd.eduservice.exception.GuliException;

/**
 * 课程
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
public interface EduCourseService extends IService<EduCourseEntity> {

    EduCourseEntity addCourse(CourseVO course) throws GuliException;

    CourseVO getCourseInfo(String id);

    void updateCourse(CourseVO courseVO);

    CoursePublishVo getCoursePublish(String courseId);

    void removeCourse(String id);
}

