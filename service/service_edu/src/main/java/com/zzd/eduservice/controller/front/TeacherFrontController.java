package com.zzd.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.service.EduCourseService;
import com.zzd.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author ZZD
 * @Date 2020/10/8 19:09
 * @Email 1396896729@qq.com
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacherfront")
public class TeacherFrontController {
    @Autowired
    private EduTeacherService teacherService;
    @Autowired
    private EduCourseService courseService;
    @GetMapping("{page}/{limit}")
    public R getTeacher(@PathVariable Long page,@PathVariable long limit) {
        Page<EduTeacherEntity> p = new Page<>(page,limit);
        return R.ok(teacherService.page(p)) ;

    }

    @GetMapping("{id}")
    public R info(@PathVariable String id) {

        HashMap<String, Object> map = new HashMap<>();

        EduTeacherEntity teacher = teacherService.getById(id);

        QueryWrapper<EduCourseEntity> teacherWrapper = new QueryWrapper();

        teacherWrapper.eq("teacher_id",id);

        List<EduCourseEntity> courseList = courseService.list(teacherWrapper);

        map.put("teacher",teacher);
        map.put("courseList",courseList);

        return R.ok(map);


    }


}
