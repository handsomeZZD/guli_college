package com.zzd.msm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.JsonObject;
import com.zzd.msm.service.MsmService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @Author ZZD
 * @Date 2020/10/5 19:04
 * @Email 1396896729@qq.com
 * @description
 */
@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public boolean send(HashMap<String, Object> map, String phone) {

        System.out.println(phone);

        if (StringUtils.isEmpty(phone)){
            return false;
        }

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GDVJBAGbNKzuB4zK1dT", "XV6oreiX5mjgw508ChRsjQq6qguhW6");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ZBLOG个人博客");
        request.putQueryParameter("TemplateCode", "SMS_204116563");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }

    }
}
