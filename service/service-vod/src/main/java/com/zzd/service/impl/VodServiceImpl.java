package com.zzd.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.zzd.eduservice.exception.GuliException;
import com.zzd.service.VodService;
import com.zzd.utils.InitVodClient;
import com.zzd.utils.VodConstant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Author ZZD
 * @Date 2020/9/19 22:04
 * @Email 1396896729@qq.com
 * @description
 */
@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadVideo(MultipartFile file) {
       try {
           String title = file.getName();
           String filename = file.getOriginalFilename();
           InputStream inputStream = file.getInputStream();
           UploadStreamRequest request = new UploadStreamRequest(VodConstant.ACCESS_KEY_ID, VodConstant.ACCESS_KEY_SECRET, title, filename, inputStream);

           UploadVideoImpl uploader = new UploadVideoImpl();
           UploadStreamResponse response = uploader.uploadStream(request);
           return response.getVideoId();


       }catch (Exception e){
           e.printStackTrace();
       }

        return "";
    }

    @Override
    public void removeVideo(String id) {
        DeleteVideoRequest request = new DeleteVideoRequest();

        request.setVideoIds(id);

        try {
            InitVodClient.initVodClient(VodConstant.ACCESS_KEY_ID,VodConstant.ACCESS_KEY_SECRET).getAcsResponse(request);
        } catch (ClientException e) {
            throw new GuliException("-1");
        }
    }
}
