package com.zzd.eduservice.controller;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.entity.vo.CoursePublishVo;
import com.zzd.eduservice.entity.vo.CourseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduCourseEntity;
import com.zzd.eduservice.service.EduCourseService;



/**
 * 课程
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@RestController
@RequestMapping("eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 获取课程发布前的类，（CoursePublishVo类）
     */
    @GetMapping("publish/{courseId}")
    public R list(@PathVariable String courseId){

       CoursePublishVo publishVo = eduCourseService.getCoursePublish(courseId);

       return R.ok(publishVo);

    }

   /* @GetMapping("{id}")
    @ApiOperation("获取课程的信息，含课程描述")
    public R info(@PathVariable String id){

        EduCourseEntity entity = eduCourseService.getById(id);

        return R.ok(entity);
    }*/



    @GetMapping("/{id}")
    @ApiOperation("获取课程的信息，含课程描述")
    public R info(@PathVariable("id") String id){

       CourseVO courseInfo = eduCourseService.getCourseInfo(id);
        return R.ok(courseInfo);
    }

    /**
     * 课程分页查询，
     */
    @GetMapping("{curPage}/{pageSize}")
    public R list(@PathVariable Long curPage,@PathVariable Long pageSize, EduCourseEntity courseEntity){

        Page<EduCourseEntity> page = new Page<>(curPage,pageSize);
        QueryWrapper<EduCourseEntity> wrapper = new QueryWrapper<>();
        if (courseEntity!=null){
            if (courseEntity.getTitle()!=null && courseEntity.getTitle()!="") {
                wrapper.like("title",courseEntity.getTitle());
            }
            if (courseEntity.getSubjectParentId()!=null&& courseEntity.getSubjectParentId()!="") {
                wrapper.eq("subject_parent_id", courseEntity.getSubjectParentId());
            }
            if (courseEntity.getSubjectId()!=null && courseEntity.getSubjectId()!="") {
                wrapper.eq("subject_id",courseEntity.getSubjectId());
            }

            if (courseEntity.getTeacherId()!=null && courseEntity.getTeacherId()!="") {
                wrapper.eq("teacher_id", courseEntity.getTeacherId());
            }

        }
        Page<EduCourseEntity> entityPage = eduCourseService.page(page,wrapper);

        return R.ok(entityPage);

    }

    /**
     * 保存
     */
    @PostMapping
    public R save(@RequestBody CourseVO course){

        EduCourseEntity courseEntity = eduCourseService.addCourse(course);

        return R.ok(courseEntity);
    }

    /**
     * 修改
     */
    @ApiOperation("修改课程")
    @PutMapping
    public R update(@RequestBody CourseVO courseVO){

        eduCourseService.updateCourse(courseVO);

        return R.ok(null);
    }
    @ApiOperation("课程发布后修改课程状态")
    @PutMapping("{id}")
    public R updateStatues(@PathVariable String id){
        EduCourseEntity courseEntity = eduCourseService.getById(id);
        courseEntity.setStatus("Normal");
        eduCourseService.updateById(courseEntity);
        return R.ok(null);
    }
    /**
     * 删除
     */
    @ApiOperation("删除课程的相关信息")
    @DeleteMapping("{id}")
    public R delete(@PathVariable String id){

        eduCourseService.removeCourse(id);
        return R.ok(null);
    }

}
