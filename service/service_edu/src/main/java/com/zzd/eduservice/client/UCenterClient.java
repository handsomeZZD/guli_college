package com.zzd.eduservice.client;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.impl.UCenterClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ZZD
 * @Date 2020/10/18 17:29
 * @Email 1396896729@qq.com
 * @description
 */
@Component
@FeignClient(value = "service-ucenter",fallback = UCenterClientImpl.class)
public interface UCenterClient {
    @GetMapping("/educenter/member/info")
    R getMemberInfo(HttpServletRequest request);
}
