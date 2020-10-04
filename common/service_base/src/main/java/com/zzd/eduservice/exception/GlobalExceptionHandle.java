package com.zzd.eduservice.exception;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ZZD
 * @Date 2020/9/4 14:09
 * @Email 1396896729@qq.com
 * @description
 */
@ControllerAdvice
public class GlobalExceptionHandle {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(){
       return R.failed("服务器出错");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        return R.failed(e.getMsg());
    }


}
