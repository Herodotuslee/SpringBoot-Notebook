package com.springbootnotebook.demo.Service;

import com.springbootnotebook.demo.Model.Topic;
import com.springbootnotebook.demo.Repository.TopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


//    for business logic
@Service
public class TopicService {

    @Autowired
    private TopRepository topRepository;
// JSON needs to use " "
//    multiable : add new ArrayList
//    private List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic("Spring","Spring Framework","Description"),
//                    new Topic("Spring3","Spring Framework","Description"),
//            new Topic("Spring1","Spring Framework","Description")));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topRepository.findAll()
                .forEach(topics::add);
        return topics;

    };

    public Optional<Topic> getTopic(String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topRepository.findById(id);
    }

    public void addTopic(Topic topic){
//        topics.add(topic);
        topRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
//        for(int i=0;i<topics.size();i++){
//            Topic t= topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i,topic);
//                return;
//            }
//        }
        topRepository.save(topic);

    }

    public void deleteTopic(String id){
//        topics.removeIf(t-> t.getId().equals(id));
        topRepository.deleteById(id);

    }


}

