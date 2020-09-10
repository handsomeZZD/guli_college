package com.zzd.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ZZD
 * @Date 2020/9/9 19:04
 * @Email 1396896729@qq.com
 * @description
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
