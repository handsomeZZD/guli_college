package com.zzd.eduservice.controller;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduCommentEntity;
import com.zzd.eduservice.service.EduCommentService;

import javax.servlet.http.HttpServletRequest;


/**
 * 评论
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@RestController
@RequestMapping("eduservice/comment")
@CrossOrigin
public class EduCommentController {
    @Autowired
    private EduCommentService eduCommentService;

    /**
     * 分页查找课程评论
     */
    @GetMapping("{page}/{limit}")
    public R page(@PathVariable Long page,@PathVariable Long limit ,EduCommentEntity commentEntity){
        Page<EduCommentEntity> p = new Page(page,limit);
        QueryWrapper<EduCommentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",commentEntity.getCourseId());
        Page<EduCommentEntity> entityPage = eduCommentService.page(p, queryWrapper);
        return R.ok(entityPage);
    }


    /**
     * 添加课程评论
     */
    @PostMapping
    public R save(@RequestBody EduCommentEntity eduComment,HttpServletRequest request){
        eduCommentService.saveComment(eduComment,request);
        return R.ok(null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String update(@RequestBody EduCommentEntity eduComment){


        return "ok";
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String delete(@RequestBody String[] ids){

        return "ok";
    }

}
