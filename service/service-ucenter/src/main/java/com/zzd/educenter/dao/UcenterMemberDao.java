package com.zzd.educenter.dao;

import com.zzd.educenter.entity.UcenterMemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员表
 * 
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-10-05 22:18:57
 */
@Mapper
public interface UcenterMemberDao extends BaseMapper<UcenterMemberEntity> {
	
}
