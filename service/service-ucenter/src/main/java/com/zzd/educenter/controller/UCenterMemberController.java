package com.zzd.educenter.controller;

import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.common.util.JwtUtils;
import com.zzd.educenter.entity.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.educenter.entity.UcenterMemberEntity;
import com.zzd.educenter.service.UcenterMemberService;

import javax.servlet.http.HttpServletRequest;


/**
 * 会员表
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-10-05 22:18:57
 */
@RestController
@CrossOrigin
@RequestMapping("/educenter/member")
public class UCenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    /**
     * 登录
     */

    @PostMapping("login")
    public R login(@RequestBody UcenterMemberEntity ucenterMemberEntity){
        System.out.println(ucenterMemberEntity);
        String token = ucenterMemberService.login(ucenterMemberEntity);

        return R.ok(token);
    }

    @PostMapping("register")
    public R register(@RequestBody RegisterVO registerVO){

        ucenterMemberService.register(registerVO);

        return R.ok(null);
    }

    @GetMapping("info")
    public R getMemberInfo(HttpServletRequest request) {

        String id = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMemberEntity memberEntity = ucenterMemberService.getById(id);

        return R.ok(memberEntity);
    }

}
