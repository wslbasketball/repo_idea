package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/11/30 20:39
 * @Project_Name lagou_edu_home_parent
 */
public interface CourseMapper {

    /**
     * 1.多条件课程列表查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 2.新增课程信息
     */
    public void saveCourse(Course course);

    /**
     * 3.新增讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 4.回显课程信息：(根据课程ID查询具体的课程信息以及关联的讲师信息)
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 5.更新课程信息
     */
    public void updateCourse(Course course);

    /**
     * 6.更新讲师信息
     */
    public void updateTeacher(Teacher teacher);

    /**
     * 7.修改课程状态
     */
    public void updateCourseStatus(Course course);

}
