package com.zzd.eduservice.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.entity.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zzd.eduservice.entity.EduSubjectEntity;
import com.zzd.eduservice.service.EduSubjectService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 课程科目
 *
 * @author zzd
 * @email zhongzuda@qq.com
 * @date 2020-09-02 22:02:58
 */
@RestController
@RequestMapping("eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 列表
     */
    @GetMapping("/tree")
    public R list(){
       List<SubjectVO> data =  eduSubjectService.getTree();
        return R.ok(data);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String id){


        return "ok";
    }

    /**
     * 保存
     */
    @PostMapping
    public R save(MultipartFile file){
        System.out.println("eduSubjectService"+ eduSubjectService);
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok(null);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String update(@RequestBody EduSubjectEntity eduSubject){


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
