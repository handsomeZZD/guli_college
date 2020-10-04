package com.zzd.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.eduservice.entity.EduSubjectEntity;
import com.zzd.eduservice.entity.vo.SubjectVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 课程科目
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
public interface EduSubjectService extends IService<EduSubjectEntity> {

    //读取excel文件的课程
    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    //获取课程。树结构
    List<SubjectVO> getTree();
}

