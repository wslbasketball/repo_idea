package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/30 20:52
 * @Project_Name lagou_edu_home_parent
 */
public interface CourseService {

    /**
     * 1.多条件课程列表查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 2.新增课程以及讲师信息
     */
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 3.回显课程信息：(根据课程ID查询具体的课程信息以及关联的讲师信息)
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 4.更新课程以及讲师信息
     */
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 5.修改课程状态
     */
    public void updateCourseStatus(int courseId,int status);

}
