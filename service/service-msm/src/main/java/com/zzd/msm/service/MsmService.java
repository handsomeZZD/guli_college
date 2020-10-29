package com.zzd.msm.service;

import java.util.HashMap;

/**
 * @Author ZZD
 * @Date 2020/10/5 19:04
 * @Email 1396896729@qq.com
 * @description
 */
public interface MsmService {
    boolean send(HashMap<String, Object> map, String phone);
}
