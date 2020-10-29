package com.zzd.educms.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.educms.entity.CrmBannerEntity;
import com.zzd.educms.service.CrmBannerService;



/**
 * 首页banner表
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-10-04 22:27:37
 */
@RestController
@RequestMapping("educms/admin/banner")
public class BannerAdminController {
    @Autowired
    private CrmBannerService crmBannerService;

    /**
     * 列表
     */
    @GetMapping
    public R list(){
        List<CrmBannerEntity> list = crmBannerService.list();
        return R.ok(list);
    }

    /**
     * 分页
     */
    @GetMapping("{page}/{limit}")
    public R page(@PathVariable  Long page,@PathVariable Long limit){
        Page<CrmBannerEntity> pageBanner = new Page<CrmBannerEntity>(page,limit);
        Page<CrmBannerEntity> entityPage = crmBannerService.page(pageBanner);
        return R.ok(entityPage);

    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    public R info(@PathVariable("id") String id){

        CrmBannerEntity bannerEntity = crmBannerService.getById(id);

        return R.ok(bannerEntity);
    }

    /**
     * 保存
     */
    @PostMapping
    public R save(@RequestBody CrmBannerEntity crmBanner){

        crmBannerService.save(crmBanner);

        return R.ok(null);

    }

    /**
     * 修改
     */
    @PutMapping
    public R update(@RequestBody CrmBannerEntity crmBanner){

        crmBannerService.updateById(crmBanner);
        return R.ok(null);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id")
    public R delete(@PathVariable String id){
        crmBannerService.removeById(id);
        return R.ok(null);
    }

}
