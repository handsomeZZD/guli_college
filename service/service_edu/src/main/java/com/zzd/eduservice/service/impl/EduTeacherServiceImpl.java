package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduTeacherDao;
import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.service.EduTeacherService;


@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherDao, EduTeacherEntity> implements EduTeacherService {



}