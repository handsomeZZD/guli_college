package com.zzd.eduservice.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author ZZD
 * @Date 2020/9/12 15:47
 * @Email 1396896729@qq.com
 * @description
 */
@Data
public class SubjectVO {
    String id;
    String name;
    List<SubjectVO> children;

    public SubjectVO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
