package com.zzd.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.eduservice.dao.EduVideoDao;
import com.zzd.eduservice.entity.EduVideoEntity;
import com.zzd.eduservice.entity.vo.chapter.ChapterVo;
import com.zzd.eduservice.entity.vo.chapter.VideoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduChapterDao;
import com.zzd.eduservice.entity.EduChapterEntity;
import com.zzd.eduservice.service.EduChapterService;


@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterDao, EduChapterEntity> implements EduChapterService {

    @Autowired
    EduVideoDao videoDao;

    @Override
    public List<ChapterVo> getChapterVideo(String courseId) {
        //查询课程章节
        QueryWrapper<EduChapterEntity> chapterWrapper = new QueryWrapper<>();
        chapterWrapper.eq("course_id",courseId);
        List<EduChapterEntity> chapterEntities = baseMapper.selectList(chapterWrapper);
        //查询课程小结
        QueryWrapper<EduVideoEntity> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id",courseId);
        List<EduVideoEntity> videoEntities = videoDao.selectList(videoWrapper);
        ArrayList<ChapterVo> chapterVos = new ArrayList<>();

        //将课程小节(VideoVo)封装到课程章节中(ChapterVo)
        for (EduChapterEntity chapterEntity : chapterEntities) {
            ChapterVo vo1 = new ChapterVo();
            BeanUtils.copyProperties(chapterEntity,vo1);
            ArrayList<VideoVo> videoVos = new ArrayList<>();
            for (EduVideoEntity videoEntity : videoEntities) {
                if (videoEntity.getChapterId().equals(chapterEntity.getId())){
                    VideoVo vo2 = new VideoVo();
                    BeanUtils.copyProperties(videoEntity,vo2);
                    videoVos.add(vo2);
                }
            }
            vo1.setChildren(videoVos);
            chapterVos.add(vo1);
        }
        return chapterVos;
    }
}