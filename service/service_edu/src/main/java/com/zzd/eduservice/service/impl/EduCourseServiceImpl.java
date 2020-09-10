package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduCourseDao;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.service.EduCourseService;


@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseDao, EduCourseEntity> implements EduCourseService {


}