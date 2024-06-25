package com.diversitech.coursesService.service;

import com.diversitech.coursesService.model.Course;
import com.diversitech.coursesService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService{

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

    @Value("${api.classes-service.class-url}")
    private String classServiceUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callClassService() {
        String url = classServiceUrl + "/endpoint";
        return restTemplate.getForObject(url, String.class);
    }
}

