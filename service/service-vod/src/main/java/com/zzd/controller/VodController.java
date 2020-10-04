package com.zzd.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ZZD
 * @Date 2020/9/19 21:59
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {
    @Autowired
    VodService vodService;

    @PostMapping
    public R  uploadVideo(MultipartFile file) {
       String videoId =  vodService.uploadVideo(file);
        return R.ok(videoId);
    }
    @DeleteMapping("{id}")
    public R removeVideo(@PathVariable String id) {
        vodService.removeVideo(id);

        return R.ok(null);
    }
}
