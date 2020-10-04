
package com.zzd.eduservice.client;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.impl.VodClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @Author ZZD
 * @Date 2020/9/30 14:58
 * @Email 1396896729@qq.com
 * @description
 */

@Component
@FeignClient(name = "service-vod",fallback = VodClientImpl.class)
public interface VodClient {
    @DeleteMapping("/eduvod/video/{id}")
    public R removeVideo(@PathVariable("id") String id);
}

