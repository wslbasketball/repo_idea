package com.lagou.service.impI;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/1 23:08
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class CourseContentServiceImpI implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    //8.根据课程ID查询关联的章节信息以及章节下关联的课时信息
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        List<CourseSection> list = courseContentMapper.findSectionAndLessonByCourseId(courseId);
        return list;
    }

    //9.回显章节对应的课程信息
    @Override
    public Course findCourseByCourseId(Integer courseId) {
        Course course = courseContentMapper.findCourseByCourseId(courseId);
        return course;
    }

    //10.新增章节信息
    @Override
    public void saveSection(CourseSection courseSection) {
        //补全信息
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        //调用courseContentMapper方法
        courseContentMapper.saveSection(courseSection);
    }

    //11.更新章节信息
    @Override
    public void updateSection(CourseSection courseSection) {
        //补全信息
        courseSection.setUpdateTime(new Date());

        //调用courseContentMapper方法
        courseContentMapper.updateSection(courseSection);
    }

    //12.修改章节状态
    @Override
    public void updateSectionStatus(int id, int status) {
        //封装章节状态信息
        CourseSection courseSection = new CourseSection();
        courseSection.setUpdateTime(new Date());
        courseSection.setStatus(status);
        courseSection.setId(id);

        //调用courseContentMapper方法
        courseContentMapper.updateSectionStatus(courseSection);
    }

    //13.新增课时信息
    @Override
    public void saveLesson(CourseLesson courseLesson) {
        //补全信息
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);

        //调用courseContentMapper方法
        courseContentMapper.saveLesson(courseLesson);
    }

    //14.更新课时信息
    @Override
    public void updateLesson(CourseLesson courseLesson) {
        //补全信息
        courseLesson.setUpdateTime(new Date());

        //调用courseContentMapper方法
        courseContentMapper.updateLesson(courseLesson);
    }

    //15.修改课时状态
    @Override
    public void updateLessonStatus(int id, int status) {
        //封装课时状态信息
        CourseLesson courseLesson = new CourseLesson();
        courseLesson.setUpdateTime(new Date());
        courseLesson.setStatus(status);
        courseLesson.setId(id);

        //调用courseContentMapper方法
        courseContentMapper.updateLessonStatus(courseLesson);
    }


}
