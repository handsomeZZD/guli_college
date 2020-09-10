package com.zzd.eduservice.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author ZZD
 * @Date 2020/9/7 20:03
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
@Api
public class EduLoginController {


    @PostMapping("/login")
    @ApiOperation("获取token值")
    public R login(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("token","admin");
       return R.ok(data);
    }

    @GetMapping("/info")
    public R info(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("roles","[admin]");
        data.put("name","admin");
        data.put("avatar","https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3582194852,1481557220&fm=26&gp=0.jpg");

        return R.ok(data);
    }
}
