package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduChapterDao;
import com.zzd.eduservice.entity.EduChapterEntity;
import com.zzd.eduservice.service.EduChapterService;


@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterDao, EduChapterEntity> implements EduChapterService {


}