package com.zzd.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zzd.eduservice.dao.*;
import com.zzd.eduservice.entity.*;
import com.zzd.eduservice.entity.vo.CoursePublishVo;
import com.zzd.eduservice.entity.vo.CourseVO;
import com.zzd.eduservice.entity.vo.front.CourseWebVo;
import com.zzd.eduservice.exception.GuliException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.service.EduCourseService;
import org.springframework.transaction.annotation.Transactional;


@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseDao, EduCourseEntity> implements EduCourseService {

    @Autowired
    EduCourseDescriptionDao descriptionDao;

    @Autowired
    EduSubjectDao subjectDao;

    @Autowired
    EduVideoDao eduVideoDao;

    @Autowired
    EduChapterDao eduChapterDao;
    /**
     * @params 添加课程
     * @return
     */
    @Override
    @Transactional(rollbackFor = GuliException.class)
    public EduCourseEntity addCourse(CourseVO courseVo) {
        EduCourseEntity courseEntity = new EduCourseEntity();
        BeanUtils.copyProperties(courseVo, courseEntity);
        //获取当前课程的父id
        EduSubjectEntity subjectEntity = subjectDao.selectById(courseVo.getSubjectId());
        courseEntity.setSubjectParentId(subjectEntity.getParentId());
        int insert = baseMapper.insert(courseEntity);
        if (insert == 0) {
            throw new GuliException("添加课程失败");
        }
        //将课程描述添加到表中
        String cid = courseEntity.getId();
        EduCourseDescriptionEntity descriptionEntity = new EduCourseDescriptionEntity();
        descriptionEntity.setId(cid);
        descriptionEntity.setDescription(courseVo.getDescription());
        int insert1 = descriptionDao.insert(descriptionEntity);
        if (insert1 == 0) {
            throw new GuliException("课程添加失败");
        }

        return courseEntity;
    }

    @Override
    //获取课程信息，将课程类，和课程描述类。封装到CourseVO中
    public CourseVO getCourseInfo(String id) {
        CourseVO courseVO = new CourseVO();
        //查询课程
        EduCourseEntity courseEntity = baseMapper.selectById(id);
        BeanUtils.copyProperties(courseEntity,courseVO);
        //查询课程描述
        EduCourseDescriptionEntity descriptionEntity = descriptionDao.selectById(id);
        courseVO.setDescription(descriptionEntity.getDescription());
        return courseVO;
    }

    @Override
    //修改课程
    public void updateCourse(CourseVO courseVO) {
        //修改课程
        EduCourseEntity courseEntity = new EduCourseEntity();
        BeanUtils.copyProperties(courseVO,courseEntity);
        baseMapper.updateById(courseEntity);
        //修改课程描述1
        EduCourseDescriptionEntity descriptionEntity = new EduCourseDescriptionEntity();
        BeanUtils.copyProperties(courseVO,descriptionEntity);
        descriptionDao.updateById(descriptionEntity);
    }

    //获取课程发布前的信息
    @Override
    public CoursePublishVo getCoursePublish(String courseId) {
       return baseMapper.getCoursePublish(courseId);
    }


    //删除课程的所有相关信息
    @Override
    public void removeCourse(String courseId) {
        //删除小节
        eduVideoDao.delete(new UpdateWrapper<EduVideoEntity>().eq("course_id",courseId));
        //删除章节
        eduChapterDao.delete(new UpdateWrapper<EduChapterEntity>().eq("course_id",courseId));
        //删除描述
        descriptionDao.deleteById(courseId);
        //删除课程
        baseMapper.deleteById(courseId);
    }

    @Override
    public CourseWebVo getWebCourse(String id) {
        return baseMapper.getWebCourse(id);
    }
}