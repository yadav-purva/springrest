package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(long courseId);
public Course addCourse(Course course);
public Course updateCourse(long courseId,Course course);
public boolean deleteCourse(long courseId);
public Course updateCourseTitle(long courseId, Course course);

}
