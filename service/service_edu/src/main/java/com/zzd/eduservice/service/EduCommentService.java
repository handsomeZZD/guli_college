package com.zzd.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.eduservice.entity.EduCommentEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 评论
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
public interface EduCommentService extends IService<EduCommentEntity> {

    void saveComment(EduCommentEntity eduComment, HttpServletRequest request);
}

