package com.zzd.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.eduservice.entity.EduSubjectEntity;
import com.zzd.eduservice.entity.excel.SubjectData;
import com.zzd.eduservice.exception.GuliException;
import com.zzd.eduservice.service.EduSubjectService;
import lombok.SneakyThrows;

/**
 * @Author ZZD
 * @Date 2020/9/12 9:23
 * @Email 1396896729@qq.com
 * @description
 *  easyExcel的监听器 一行一行读取数据
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @SneakyThrows
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        //判断文件空
        if (subjectData==null) {
            throw new GuliException("文件内容为空");
        }
        //获取第一列的值 一级目录
        EduSubjectEntity existOne = existOne(subjectData.getFirstSubjectName());

        //判断有没有重复的一级目录
        if (existOne ==null) {
            EduSubjectEntity subject = new EduSubjectEntity();

            subject.setParentId("0");
            subject.setTitle(subjectData.getFirstSubjectName());

            eduSubjectService.save(subject);
        }

        String pid  = existOne.getId();
        //获取第二列的值 二级目录
        EduSubjectEntity existTwo = existTwo(subjectData.getSecondSubjectName(), pid);
        //二级目录是否重复
        if (existTwo==null) {
            existTwo = new EduSubjectEntity();
            existTwo.setTitle(subjectData.getSecondSubjectName());
            existTwo.setParentId(pid);
            eduSubjectService.save(existTwo);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }


    /**
     * @params title字段
     * @return
     *
     * 判断是否 已经存在一/二级目录
     */
    private EduSubjectEntity existOne(String name) {
        QueryWrapper<EduSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name).eq("parent_id",0);

       return eduSubjectService.getOne(wrapper);
    }

    private EduSubjectEntity existTwo(String name,String pid) {
        QueryWrapper<EduSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name).eq("parent_id",pid);

        return eduSubjectService.getOne(wrapper);
    }



}
