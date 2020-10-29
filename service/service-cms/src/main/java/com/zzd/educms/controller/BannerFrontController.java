package com.zzd.educms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.educms.entity.CrmBannerEntity;
import com.zzd.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ZZD
 * @Date 2020/10/4 22:34
 * @Email 1396896729@qq.com
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/educms/bannerfront")
public class BannerFrontController {
    @Autowired
    private CrmBannerService bannerService;

    @Cacheable(value = "banner",key = "'selectBannerList'")
    @GetMapping
    public R getAllBanner() {
        QueryWrapper<CrmBannerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 4");
        List<CrmBannerEntity> list = bannerService.list(queryWrapper);
        return R.ok(list);
    }

}
