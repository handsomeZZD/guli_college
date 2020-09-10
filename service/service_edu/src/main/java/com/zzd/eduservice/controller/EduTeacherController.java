package com.zzd.eduservice.controller;

import java.util.List;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzd.eduservice.entity.vo.TeacherQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduTeacherEntity;
import com.zzd.eduservice.service.EduTeacherService;



/**
 * 讲师
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */

@RestController
@RequestMapping("/eduservice/eduteacher")
@Slf4j
@Api("讲师的控制类")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 列表
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/list")
    public R list(){
        log.error("错误错误错误错误错误错错误错误错误");
        List<EduTeacherEntity> list = eduTeacherService.list();
        return R.ok(list);

    }

    @ApiOperation("分页查询，可附带查询条件")
    @GetMapping("/{curPage}/{pageSize}")
    public R list(@PathVariable Long curPage, @PathVariable Long pageSize,TeacherQuery teacherQuery){

        Page<EduTeacherEntity> page = new Page<>(curPage,pageSize);
        QueryWrapper<EduTeacherEntity> wrapper = new QueryWrapper<>();
        if (teacherQuery!=null){
            String name = teacherQuery.getName();
            Integer level = teacherQuery.getLevel();
            String begin = teacherQuery.getBegin();
            String end = teacherQuery.getEnd();

            if (name!=null) {
                wrapper.like("name",name);
            }
            if (level!=null) {
                wrapper.eq("level",level);
            }
            if (begin!=null) {
                wrapper.ge("gmt_create",begin);
            }
            if (end!=null) {
                wrapper.le("gmt_create",end);
            }
        }

        wrapper.orderByDesc("gmt_create");

        Page<EduTeacherEntity> teacherEntityPage = eduTeacherService.page(page,wrapper);

        return R.ok(teacherEntityPage);


    }

    /**
     * 信息
     */
    @ApiOperation("根据id查询讲师")
    @GetMapping("/{id}")
    public R info(@PathVariable("id") String id){

        EduTeacherEntity teacherEntity = eduTeacherService.getById(id);

        return R.ok(teacherEntity);
    }

    /**
     * 保存
     */
    @ApiOperation("添加讲师")
    @PostMapping("")
    public R add(@RequestBody EduTeacherEntity eduTeacher){

        boolean save = eduTeacherService.save(eduTeacher);

        if (save){
            return R.ok(null);
        }

        return R.failed("添加失败");
    }

    /**
     * 修改
     */
    @ApiOperation("修改讲师")
    @PutMapping("/{id}")
    public R update(@PathVariable String id,@RequestBody EduTeacherEntity eduTeacher){

        System.out.println(id);
        if (id==null){
            return R.failed("请输入讲师id");
        }
        eduTeacher.setId(id);
        System.out.println(eduTeacher);
        boolean b = eduTeacherService.updateById(eduTeacher);

        if (b){
            return R.ok(null);
        }

        return R.failed("修改失败");

    }

    /**
     * 删除
     */
    @ApiOperation("删除讲师")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable String id){

        boolean b = eduTeacherService.removeById(id);

        if (b){
            return R.ok(null);

        }
        return R.failed("删除失败");
    }

}
