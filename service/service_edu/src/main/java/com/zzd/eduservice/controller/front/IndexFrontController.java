package com.zzd.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.service.EduCourseService;
import com.zzd.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ZZD
 * @Date 2020/10/4 22:59
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/front")
public class IndexFrontController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping
    @Cacheable(value = "courseAndTeacher",key = "'courseAndTeacherList'")
    public R getIndexData() {
        QueryWrapper<EduCourseEntity> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.orderByDesc("view_count").last("limit 8");

        List<EduCourseEntity> eduList = courseService.list(courseQueryWrapper);

        QueryWrapper<EduTeacherEntity> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.orderByDesc("level").last("limit 4");

        List<EduTeacherEntity> teacherList = teacherService.list(teacherQueryWrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("eduList",eduList);
        data.put("teacherList",teacherList);

        return R.ok(data);
    }

}
