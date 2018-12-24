package com.springbootnotebook.demo.Controller;

import com.springbootnotebook.demo.Model.Topic;
import com.springbootnotebook.demo.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
            return topicService.getAllTopics();
        }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

//    doesnt work
    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,String id){
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="topics/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }

}

