package com.zzd.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.entity.vo.CourseVO;
import com.zzd.eduservice.entity.vo.chapter.ChapterVo;
import com.zzd.eduservice.entity.vo.front.CourseFrontVo;
import com.zzd.eduservice.entity.vo.front.CourseWebVo;
import com.zzd.eduservice.service.EduChapterService;
import com.zzd.eduservice.service.EduCourseService;
import com.zzd.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ZZD
 * @Date 2020/10/9 10:30
 * @Email 1396896729@qq.com
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/coursefront")
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;
    //根据条件，分页查询课程

    @Autowired
    private EduChapterService chapterService;
    @GetMapping("{page}/{limit}")
    public R getCourseList(@PathVariable Long page, @PathVariable Long limit , CourseFrontVo courseFrontVo) {
        Page<EduCourseEntity> p = new Page<>(page,limit);
        QueryWrapper<EduCourseEntity> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(courseFrontVo.getTitle())) {
            queryWrapper.like("title",courseFrontVo.getTitle());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getTeacherId())) {
            queryWrapper.eq("teacher_id",courseFrontVo.getTeacherId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectId())) {
            queryWrapper.eq("subject_id",courseFrontVo.getSubjectId());
        }

        if (!StringUtils.isEmpty(courseFrontVo.getSubjectParentId())) {
            queryWrapper.eq("subject_parent_id",courseFrontVo.getSubjectParentId());
        }
        if (!StringUtils.isEmpty(courseFrontVo.getBuyCountSort())) {
            queryWrapper.orderByDesc("buy_count");
        }
        if (!StringUtils.isEmpty(courseFrontVo.getGmtCreatSort())) {
            queryWrapper.orderByDesc("gmt_create");
        }

        if (!StringUtils.isEmpty(courseFrontVo.getPriceSort())) {
            queryWrapper.orderByDesc("price");
        }
        Page<EduCourseEntity> result = courseService.page(p, queryWrapper);
        return R.ok(result);

    }
    @GetMapping("/{id}")
    @ApiOperation("获取课程的信息，含课程描述")
    public R info(@PathVariable("id") String id){

        CourseWebVo courseWebVo = courseService.getWebCourse(id);
        List<ChapterVo> chapterList = chapterService.getChapterVideo(courseWebVo.getId());
        Map<String,Object> res = new HashMap<>();
        res.put("courseWebVo",courseWebVo);
        res.put("chapterList",chapterList);
        return R.ok(res);
    }
}
