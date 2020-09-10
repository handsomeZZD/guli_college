package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduVideoDao;
import com.zzd.eduservice.entity.EduVideoEntity;
import com.zzd.eduservice.service.EduVideoService;


@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoDao, EduVideoEntity> implements EduVideoService {


}