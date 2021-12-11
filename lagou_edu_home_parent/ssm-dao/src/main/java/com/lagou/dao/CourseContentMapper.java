package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/1 22:38
 * @Project_Name lagou_edu_home_parent
 */
public interface CourseContentMapper {

    /**
     * 8.根据课程ID查询关联的章节信息以及章节下关联的课时信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 9.回显章节对应的课程信息
     */
    public Course findCourseByCourseId(Integer courseId);

    /**
     * 10.新增章节信息
     */
    public void saveSection(CourseSection courseSection);

    /**
     * 11.更新章节信息
     */
    public void updateSection(CourseSection courseSection);

    /**
     * 12.修改章节状态
     */
    public void updateSectionStatus(CourseSection courseSection);

    /**
     * 13.新增课时信息
     */
    public void saveLesson(CourseLesson courseLesson);

    /**
     * 14.更新课时信息
     */
    public void updateLesson(CourseLesson courseLesson);

    /**
     * 15.修改课时状态
     */
    public void updateLessonStatus(CourseLesson courseLesson);
}
