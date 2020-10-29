package com.zzd.educenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.common.util.JwtUtils;
import com.zzd.common.util.Md5Utils;
import com.zzd.educenter.entity.RegisterVO;
import com.zzd.eduservice.exception.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.educenter.dao.UcenterMemberDao;
import com.zzd.educenter.entity.UcenterMemberEntity;
import com.zzd.educenter.service.UcenterMemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;


@Service("ucenterMemberService")
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberDao, UcenterMemberEntity> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public String login(UcenterMemberEntity ucenterMemberEntity) {
        //判断账号密码是否为空
        if (StringUtils.isEmpty(ucenterMemberEntity.getMobile()) || StringUtils.isEmpty(ucenterMemberEntity.getPassword())) {
            throw new GuliException("账号密码错误登录失败");
        }
        //查询手机号是否存在
        QueryWrapper<UcenterMemberEntity> queryWrapper = new QueryWrapper();
        queryWrapper.eq("mobile",ucenterMemberEntity.getMobile());

        UcenterMemberEntity member = baseMapper.selectOne(queryWrapper);

        if (StringUtils.isEmpty(member)) {
            throw new GuliException("手机号码不存在");
        }

        String pwd = Md5Utils.encrypt(ucenterMemberEntity.getPassword());

        if (!pwd.equals(member.getPassword())) {
            throw new GuliException("密码错误");
        }
        if (member.getIsDisabled() == -1) {
            throw new GuliException("账号被禁用");
        }
        String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());

        return jwtToken;
    }

    @Override
    public void register(RegisterVO registerVO) {
        //判断如果是否为空
        String code = registerVO.getCode();
        String mobile = registerVO.getMobile();
        String nickName = registerVO.getNickname();
        String password = registerVO.getPassword();

        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(mobile) || StringUtils.isEmpty(nickName) || StringUtils.isEmpty(password)) {
            throw new GuliException("注册失败,注册资料不能为空。");
        }

        //判断验证码是否正确
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)) {
            throw new GuliException("注册失败,验证码不正确");
        }

        //判断手机号是否存在
        QueryWrapper<UcenterMemberEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("mobile",mobile);

        Integer count = baseMapper.selectCount(queryWrapper);

        if (count>0) {
            throw new GuliException("注册失败,手机号码已存在");
        }

        //将用户存到数据库 密码用md5加密
        UcenterMemberEntity memberEntity = new UcenterMemberEntity();

        memberEntity.setNickname(nickName);
        memberEntity.setMobile(mobile);
        memberEntity.setPassword(Md5Utils.encrypt(password));
        memberEntity.setAvatar("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601972463202&di=9d5463eaaa77fc4b53005f87c2b1cca5&imgtype=0&src=http%3A%2F%2Fpic.qqtn.com%2Fup%2F2018-1%2F15156507832635831.jpg");

        baseMapper.insert(memberEntity);
    }

}