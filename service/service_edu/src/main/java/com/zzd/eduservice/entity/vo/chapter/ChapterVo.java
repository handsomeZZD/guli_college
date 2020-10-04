package com.zzd.eduservice.entity.vo.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZZD
 * @Date 2020/9/15 19:16
 * @Email 1396896729@qq.com
 * @description
 */
@Data
public class ChapterVo {
    private String id;
    private String title;

    List<VideoVo> children = new ArrayList<VideoVo>();
}
