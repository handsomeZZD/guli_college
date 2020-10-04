package com.zzd.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.zzd.oss.service.OssService;
import com.zzd.oss.utils.ConstantPropertiesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @Author ZZD
 * @Date 2020/9/9 19:05
 * @Email 1396896729@qq.com
 * @description
 */
@Service
@Api
public class OssServiceImpl implements OssService {
    @Override

    @ApiOperation("上传文件到阿里oss")
    public String uploadFileAvatar(MultipartFile file) {
        // Endpoint。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month =calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);



        fileName = "avatar/"+year+"/"+month+"/"+day+"/"+uuid+fileName;


        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName,fileName, inputStream);
            String url = "https://" + bucketName + "." + endpoint +  "/"+fileName;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }



    }
}
