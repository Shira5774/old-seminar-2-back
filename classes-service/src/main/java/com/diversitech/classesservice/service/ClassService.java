//package com.diversitech.classesservice.service;
//
//import com.diversitech.classesservice.model.Classes;
//import com.diversitech.classesservice.repository.ClassRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClaתבדקיssService {
//
//    @Autowired
//    private ClassRepository classRepository;
//
//    private final RestTemplate restTemplate;
//
//    public ClassService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
////    public String fetchFromCourseService() {
////        String courseUrl = "http://localhost:8080/api/courses";
////        return restTemplate.getForObject(courseUrl, String.class);
////    }
//
//
//    public List<Classes> GetClassesByCourse(int course_id) {
//        return classRepository.findByCourseId(course_id);
//    }
//
//    public void AddClass(Classes classes) {
//        classRepository.save(classes);
//    }
//
//    public void updateClass(int id, Classes classes) {
//        Classes existingClass = classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class not found"));
//        existingClass.setClass_name(classes.getClass_name());
//        existingClass.setDescription(classes.getDescription());
//        existingClass.setStart_date(classes.getStart_date());
//        existingClass.setEnd_date(classes.getEnd_date());
//        classRepository.save(existingClass);
//    }
//
//    public void DeleteClass(int id) {
//        classRepository.deleteById(id);
//    }
//
//}