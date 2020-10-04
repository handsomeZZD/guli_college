package com.zzd.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ZZD
 * @Date 2020/9/19 22:04
 * @Email 1396896729@qq.com
 * @description
 */
public interface VodService {
    String uploadVideo(MultipartFile file);

    void removeVideo(String id);
}
