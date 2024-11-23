package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to the courses application";
    }

    //Get the Courses
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse( @RequestBody Course course){
        return this.courseService.addCourse(course);

    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable long courseId,@RequestBody Course course){
        Course updatedCourse = courseService.updateCourse(courseId, course);
        if (updatedCourse != null) {
            return updatedCourse;
        } else {
            throw new RuntimeException("Course with ID " + courseId + " not found");
        }
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable long courseId){
        boolean deleteCourse=courseService.deleteCourse(courseId);
        if(deleteCourse){
            return "courseId has been deleted successfully";
        } else {
            return "course has not been deleted";
        }
    }

    @PatchMapping("/courses/{courseId}")
    public Course updateCourseTitle(@PathVariable long courseId,@RequestBody Course course){
        Course updatedCourseTitle = courseService.updateCourseTitle(courseId, course);
        if (updatedCourseTitle != null) {
            return updatedCourseTitle;
        } else {
            throw new RuntimeException("Course with ID " + courseId + " not found");
        }
    }


}
