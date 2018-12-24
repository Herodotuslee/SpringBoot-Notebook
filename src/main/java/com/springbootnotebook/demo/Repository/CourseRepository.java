package com.springbootnotebook.demo.Repository;

import com.springbootnotebook.demo.Model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {
    public List<Course> findByName(String name);
    public List<Course> findByDescription(String name);
}
