package com.zzd.eduservice.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.VodClient;
import com.zzd.eduservice.entity.EduVideoEntity;
import com.zzd.eduservice.entity.vo.chapter.ChapterVo;
import com.zzd.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduChapterEntity;
import com.zzd.eduservice.service.EduChapterService;



/**
 * 课程
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@RestController
@RequestMapping("eduservice/chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient vodClient;

    /**
     * 列表
     */
    @GetMapping("{courseId}")
    public R list(@PathVariable String courseId){

       List<ChapterVo> list = eduChapterService.getChapterVideo(courseId);

       return R.ok(list);
    }


    /**
     * 信息
     */
    @GetMapping("info/{id}")
    public R info(@PathVariable("id") String id){
        EduChapterEntity chapterEntity = eduChapterService.getById(id);
        return R.ok(chapterEntity);
    }

    /**
     * 保存
     */
    @PostMapping
    public R save(@RequestBody EduChapterEntity eduChapter){

        System.out.println(eduChapter);
        eduChapterService.save(eduChapter);
        return R.ok(null);
    }

    /**
     * 修改
     */
    @PutMapping
    public R update(@RequestBody EduChapterEntity eduChapter){

        eduChapterService.updateById(eduChapter);

        return R.ok(null);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable String id){
        //先删除章节底下的视频
        EduChapterEntity chapterEntity = eduChapterService.getById(id);

        QueryWrapper<EduVideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", chapterEntity.getCourseId());

        List<EduVideoEntity> list = eduVideoService.list(queryWrapper);

        for (EduVideoEntity entity : list) {
           if (entity.getVideoSourceId()!=null) {
               vodClient.removeVideo(entity.getVideoSourceId());
           }
            eduVideoService.removeById(entity.getId());
        }


        eduChapterService.removeById(id);
        return R.ok(null);
    }

}
