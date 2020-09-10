package com.zzd.oss.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZZD
 * @Date 2020/9/9 19:07
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    @PostMapping("")
    public R uploadFile(MultipartFile file) {

       String url =  ossService.uploadFileAvatar(file);
        System.out.println(url);
        Map<String,Object> data = new HashMap<>();
        data.put("url",url);
       return R.ok(data);
    }
}
