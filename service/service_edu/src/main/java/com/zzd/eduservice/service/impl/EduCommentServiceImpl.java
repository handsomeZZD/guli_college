package com.zzd.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.UCenterClient;
import com.zzd.eduservice.dao.EduCourseDao;
import com.zzd.eduservice.dao.EduTeacherDao;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.entity.client.ucenter.UcenterMemberEntity;
import com.zzd.eduservice.exception.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduCommentDao;
import com.zzd.eduservice.entity.EduCommentEntity;
import com.zzd.eduservice.service.EduCommentService;

import javax.servlet.http.HttpServletRequest;


@Service("eduCommentService")
public class EduCommentServiceImpl extends ServiceImpl<EduCommentDao, EduCommentEntity> implements EduCommentService {


    @Autowired
    private UCenterClient uCenterClient;



    @Override
    public void saveComment(EduCommentEntity eduComment, HttpServletRequest request) {
        //判断用户是否登录
        R memberInfo = uCenterClient.getMemberInfo(request);

        if (memberInfo.getCode()==-1) {
            /*throw new GuliException("用户未登录");*/
            return;
        }

        UcenterMemberEntity memberEntity = (UcenterMemberEntity)memberInfo.getData();

        if ( eduComment!= null) {
            eduComment.setMemberId(memberEntity.getId());
            eduComment.setAvatar(memberEntity.getAvatar());
            eduComment.setNickname(memberEntity.getNickname());
        }

        this.save(eduComment);


    }
}