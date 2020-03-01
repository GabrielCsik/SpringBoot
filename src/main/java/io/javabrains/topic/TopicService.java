package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

//    database
    @Autowired
    private TopicRepository topicRepository;
// HARDCODED LIST commented (EMBEDED DATABASE)
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("1", "Java", "This is a Java topic"),
//            new Topic("2", "Javascript", "This is a Javascript topic"),
//            new Topic("3", "SQL", "This is a SQL topic")
//    ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> newTopics = new ArrayList<>();
        topicRepository.findAll().forEach(newTopics::add);
        return newTopics;
    }
    public Optional<Topic> getTopic(String id){
//        for(Topic tmp : topics){
//            if(tmp.getId().equals(id)){
//                return tmp;
//            }
//        }
//        return null;
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        for(int i = 0; i< topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        for(int i = 0; i< topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(t);
//                return;
//            }
//        }
        topicRepository.deleteById(id);
    }
}
