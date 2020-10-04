package com.zzd.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @Author ZZD
 * @Date 2020/9/30 12:23
 * @Email 1396896729@qq.com
 * @description
 */
public class InitVodClient {

    public static DefaultAcsClient initVodClient(String accessKeyId,String accessKeySecret) {
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);

        return new DefaultAcsClient(profile);
    }
}
