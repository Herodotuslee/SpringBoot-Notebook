package com.springbootnotebook.demo.Service;

import com.springbootnotebook.demo.Model.Course;
import com.springbootnotebook.demo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService  {

    @Autowired
    private CourseRepository  courseRepository;

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;

    }

    public Optional<Course> getCourse(String id){
        return courseRepository.findById(id);
    }

//    public List<Course> getCourseByName(String name){
//        return courseRepository.findByName(name);
//
//    }

    public void addCourse(Course corse){
        courseRepository.save(corse);
    }

    public void updateCourse( Course course){

        courseRepository.save(course);

    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);

    }


}

