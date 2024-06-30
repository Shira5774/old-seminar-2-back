package com.diversitech.coursesservice.service;

import com.diversitech.coursesservice.model.Course;
import com.diversitech.coursesservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(int id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());
        course.setUpdated_at(new Date());
        return courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }

    private RestTemplate restTemplate;

    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchFromClassService(){
        String classUrl = "http://localhost:8081/api/classes";
        return restTemplate.getForObject(classUrl, String.class);
    }

    public String fetchFromDocumentService(){
        String documentUrl = "http://localhost:8082/api/document";
        return restTemplate.getForObject(documentUrl, String.class);
    }

//    @Value("${custom.classes-service.url}")
//    private String classServiceUrl;
//
//    public String callClassService() {
//        String url = classServiceUrl + "/endpoint";
//        return restTemplate.getForObject(url, String.class);
//    }
}
