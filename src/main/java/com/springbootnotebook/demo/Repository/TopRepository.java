package com.springbootnotebook.demo.Repository;

import com.springbootnotebook.demo.Model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopRepository  extends  CrudRepository<Topic,String>{

}
