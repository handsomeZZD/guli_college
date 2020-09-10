package com.zzd.eduservice.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("eduservice/educourse")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String, Object> params){


         return "ok";
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id") String id){


        return "ok";
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public String save(@RequestBody EduCourseEntity eduCourse){


        return "ok";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String update(@RequestBody EduCourseEntity eduCourse){


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
