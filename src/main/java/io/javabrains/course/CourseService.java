package io.javabrains.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

//    database
    @Autowired
    private CourseRepository courseRepository;
// HARDCODED LIST commented (EMBEDED DATABASE)
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("1", "Java", "This is a Java topic"),
//            new Topic("2", "Javascript", "This is a Javascript topic"),
//            new Topic("3", "SQL", "This is a SQL topic")
//    ));

    public List<Course> getAllCourses(String id){
//        return topics;
        List<Course> newCourses = new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(newCourses::add);
        return newCourses;
    }
    public Optional<Course> getCourse(String id){
//        for(Topic tmp : topics){
//            if(tmp.getId().equals(id)){
//                return tmp;
//            }
//        }
//        return null;
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
//        topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for(int i = 0; i< topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        for(int i = 0; i< topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(t);
//                return;
//            }
//        }
        courseRepository.deleteById(id);
    }
}
