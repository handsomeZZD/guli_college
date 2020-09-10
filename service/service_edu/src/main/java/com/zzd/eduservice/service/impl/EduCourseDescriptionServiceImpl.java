package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduCourseDescriptionDao;
import com.zzd.eduservice.entity.EduCourseDescriptionEntity;
import com.zzd.eduservice.service.EduCourseDescriptionService;


@Service("eduCourseDescriptionService")
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionDao, EduCourseDescriptionEntity> implements EduCourseDescriptionService {


}