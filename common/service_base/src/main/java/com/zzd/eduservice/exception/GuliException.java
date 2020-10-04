package com.zzd.eduservice.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Author ZZD
 * @Date 2020/9/12 9:33
 * @Email 1396896729@qq.com
 * @description 异常
 */
@Data
public class GuliException extends RuntimeException{

    private String msg;
    public GuliException() {
    }

    public GuliException(String msg) {
        this.msg = msg;
    }
}
