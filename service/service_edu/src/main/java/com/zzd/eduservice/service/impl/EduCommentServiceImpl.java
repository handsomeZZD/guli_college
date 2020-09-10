package com.zzd.eduservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduCommentDao;
import com.zzd.eduservice.entity.EduCommentEntity;
import com.zzd.eduservice.service.EduCommentService;


@Service("eduCommentService")
public class EduCommentServiceImpl extends ServiceImpl<EduCommentDao, EduCommentEntity> implements EduCommentService {


}