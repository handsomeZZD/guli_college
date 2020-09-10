package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduSubjectDao;
import com.zzd.eduservice.entity.EduSubjectEntity;
import com.zzd.eduservice.service.EduSubjectService;


@Service("eduSubjectService")
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectDao, EduSubjectEntity> implements EduSubjectService {


}