package com.zzd.msm.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.msm.service.MsmService;
import com.zzd.msm.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author ZZD
 * @Date 2020/10/5 19:02
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/edumsm/msm")
public class MsmController {

    @Autowired
    private  MsmService msmService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("{phone}")
    public R sendMsm(@PathVariable  String phone) {
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            return R.ok(null);
        }
        code = RandomUtils.getFourBitRandom();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
       boolean isSend =  msmService.send(map,phone);

       if (isSend){
           redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
           return R.ok(null);
       }
       return R.failed("短信发送失败");
    }
}
