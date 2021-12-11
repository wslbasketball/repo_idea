package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wsl
 * @Date 2021/12/1 23:10
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    //8.根据课程ID查询关联的章节信息以及章节下关联的课时信息
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){

        //调用service
        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true,200,"查询章节-课时信息成功",list);
        return responseResult;
    }

    //9.回显章节对应的课程信息
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
        
        Course course = courseContentService.findCourseByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true,200,"回显章节对应的课程信息成功",course);
        return responseResult;
    }

    //10.新增&修改章节信息
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        //判断是否携带章节ID，有id为修改操作，没id为新增操作
        if (courseSection.getId() == null){
            //新增操作
            courseContentService.saveSection(courseSection);

            ResponseResult responseResult = new ResponseResult(true,200,"新增章节信息成功",null);
            return responseResult;
        } else {
            //修改操作
            courseContentService.updateSection(courseSection);

            ResponseResult responseResult = new ResponseResult(true,200,"修改章节信息成功",null);
            return responseResult;
        }
    }

    //11.修改章节状态
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id,int status){

        courseContentService.updateSectionStatus(id,status);

        //使用map集合封装：响应数据
        Map<String,Object> map = new HashMap<>();
        map.put("status", status);

        ResponseResult responseResult = new ResponseResult(true,200,"修改章节状态成功",map);
        return responseResult;
    }

    //12.新增&修改课时信息
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson){

        //判断是否携带课时id,如果携带，为修改操作，不携带，为新增操作
        if (courseLesson.getId() == null){
            //新增操作
            courseContentService.saveLesson(courseLesson);

            ResponseResult responseResult = new ResponseResult(true,200,"新增课时信息成功",null);
            return responseResult;
        } else {
            //修改操作
            courseContentService.updateLesson(courseLesson);

            ResponseResult responseResult = new ResponseResult(true,200,"修改课时信息成功",null);
            return responseResult;
        }
    }

    //13.修改课时状态
    @RequestMapping("/updateLessonStatus")
    public ResponseResult updateLessonStatus(int id,int status){

        courseContentService.updateLessonStatus(id,status);

        //使用map集合封装对象：数据响应
        Map<String,Object> map = new HashMap<>();
        map.put("status", status);

        //返回结果
        ResponseResult responseResult = new ResponseResult(true,200,"修改课时状态成功",map);
        return responseResult;
    }

}
