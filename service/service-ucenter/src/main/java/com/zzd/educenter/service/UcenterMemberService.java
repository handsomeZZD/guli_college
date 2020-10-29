package com.zzd.educenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.educenter.entity.RegisterVO;
import com.zzd.educenter.entity.UcenterMemberEntity;

import java.util.Map;

/**
 * 会员表
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-10-05 22:18:57
 */
public interface UcenterMemberService extends IService<UcenterMemberEntity> {

    String login(UcenterMemberEntity ucenterMemberEntity);

    void register(RegisterVO registerVO);
}

