package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(111, "spring boot course", "this is Springboot course"));
        list.add(new Course(222, "Core java course", "creating the application using java"));
    }

    public List<Course> getCourses() {
        return list;
    }

    public Course getCourse(long courseId) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }

        return c;
    }

    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    public Course updateCourse(long courseId, Course updateCourse) {
        for (Course course : list) {
            if (course.getId() == courseId) {
                course.setTitle(updateCourse.getTitle());// Update course title

                course.setDescription(updateCourse.getDescription()); // Update course description
                return course;
            }
        }
        return null; // If course with the given ID is not found, return null
    }

    public boolean deleteCourse(long courseId) {
        Course c1 = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c1 = course;
                break;
            }
        }
            if (c1 != null) {
                list.remove(c1);
                return true;
            }
            return false;
        }
        public Course updateCourseTitle(long courseId,Course course){
        for(Course updateTitle:list){
            if(updateTitle.getId()==courseId){
                updateTitle.setTitle(course.getTitle());
                return  updateTitle;
            }
        }
        return null;
        }
    }








