package com.zzd.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.eduservice.entity.excel.SubjectData;
import com.zzd.eduservice.entity.vo.SubjectVO;
import com.zzd.eduservice.listener.SubjectExcelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzd.eduservice.dao.EduSubjectDao;
import com.zzd.eduservice.entity.EduSubjectEntity;
import com.zzd.eduservice.service.EduSubjectService;
import org.springframework.web.multipart.MultipartFile;


@Service("eduSubjectService")
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectDao, EduSubjectEntity> implements EduSubjectService {

    @Autowired
    private EduSubjectDao eduSubjectDao;


    /**
     * 读取excle文件
     */
    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 返回课程的树
     */
    @Override
    public List<SubjectVO> getTree() {

        ArrayList<SubjectVO> list = new ArrayList<>();
        QueryWrapper<EduSubjectEntity> wrapper = new QueryWrapper<>();
        //父id为0时 说明是一级目录
        wrapper.eq("parent_id",0);

        List<EduSubjectEntity> oneSubject = eduSubjectDao.selectList(wrapper);
        //加载一级的目录
        for (EduSubjectEntity one : oneSubject) {
            SubjectVO vo1 = new SubjectVO(one.getId(), one.getTitle());
            List<EduSubjectEntity> twoSubject = eduSubjectDao.selectList(new QueryWrapper<EduSubjectEntity>().eq("parent_id", one.getId()));
            //加载二级目录
            ArrayList<SubjectVO> vo2 = new ArrayList<>();
            for (EduSubjectEntity two : twoSubject) {
                vo2.add(new SubjectVO(two.getId(),two.getTitle()));
            }
            //二级目录挂载到一级
            vo1.setChildren(vo2);
            list.add(vo1);
        }

        return list;
    }
}