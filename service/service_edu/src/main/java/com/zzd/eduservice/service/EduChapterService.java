package com.zzd.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.eduservice.entity.EduChapterEntity;
import com.zzd.eduservice.entity.vo.chapter.ChapterVo;

import java.util.List;
import java.util.Map;

/**
 * 课程
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
public interface EduChapterService extends IService<EduChapterEntity> {

    List<ChapterVo> getChapterVideo(String courseId);
}

