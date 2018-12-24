package com.springbootnotebook.demo.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


//tell the jpa
@Entity
public class Topic {

//    tell the jpa choose this one as primary key
    @Id
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "topic")
    private List<Course> courses;


    public Topic(){

    }

    public Topic(String id, String name,String description){
       super();
       this.id=id;
       this.name=name;
       this.description=description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
