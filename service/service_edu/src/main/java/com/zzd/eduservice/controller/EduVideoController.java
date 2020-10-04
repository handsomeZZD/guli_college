package com.zzd.eduservice.controller;

import com.baomidou.mybatisplus.extension.api.R;
/*import com.zzd.eduservice.client.VodClient;*/
import com.zzd.eduservice.client.VodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduVideoEntity;
import com.zzd.eduservice.service.EduVideoService;



/**
 * 课程视频
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@RestController
@CrossOrigin
@RequestMapping("eduservice/video")
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient vodClient;
    /**
     * 信息
     */
    @GetMapping("{videoId}")
    public R info(@PathVariable("videoId") String videoId){

        EduVideoEntity videoEntity = eduVideoService.getById(videoId);
        return R.ok(videoEntity);
    }

    /**
     * 保存
     */
    @PostMapping
    public R save(@RequestBody EduVideoEntity entity){

        eduVideoService.save(entity);
        System.out.println(entity);

        return R.ok(null);
    }

    /**
     * 修改
     */
    @PutMapping
    public R update(@RequestBody EduVideoEntity eduVideo){

        eduVideoService.updateById(eduVideo);
        return R.ok(null);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable String id){

        EduVideoEntity videoEntity = eduVideoService.getById(id);

        String videoSourceId = videoEntity.getVideoSourceId();

        if (videoSourceId != null) {
            vodClient.removeVideo(videoSourceId);
        }
        eduVideoService.removeById(id);
        return R.ok(null);
    }

}
