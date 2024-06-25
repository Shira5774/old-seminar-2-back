package com.diversitech.coursesService.controller;

import com.diversitech.coursesService.model.Course;
import com.diversitech.coursesService.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/call-class-service")
    public String callClassService() {
        return courseService.callClassService();
    }

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
//        return courseService.getCourseById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping("/courses")
    public Course getCourseById(@RequestParam Integer courseId) {
        return courseService.getCourseById(courseId).orElse(null);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course courseDetails) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }


//    @GetMapping("/{classes-service}")
//    public ResponseEntity<List<Classes>> getClassesByCourseId(@RequestParam Integer courseId) {
//        List<Classes> classes = courseService.getClassesByCourseId(courseId);
//        if (classes.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(classes);
//    }
//
//    @GetMapping("/{classes-service}")
//    public ResponseEntity<List<CourseDocuments>> getDocumentsByCourseId(@RequestParam Integer courseId) {
//        List<CourseDocuments> documents = courseService.getCourseDocumentsByCourseId(courseId);
//        if (documents.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(documents);
//    }
}






