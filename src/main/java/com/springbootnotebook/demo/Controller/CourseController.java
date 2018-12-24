package com.springbootnotebook.demo.Controller;

import com.springbootnotebook.demo.Model.Course;
import com.springbootnotebook.demo.Model.Topic;
import com.springbootnotebook.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


//   because one topic has many courses,
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        List<Course> courses =new ArrayList<>();
        return courseService.getAllCourses();
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        System.out.println("yo");
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    //    doesnt work
    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id){
        course.setTopic((new Topic(topicId,"","")));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
