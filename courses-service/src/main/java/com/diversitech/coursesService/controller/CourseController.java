package com.diversitech.coursesservice.controller;

import com.diversitech.coursesservice.model.Classes;
import com.diversitech.coursesservice.model.Course;
import com.diversitech.coursesservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.Document;
import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {


    @Autowired
    private RestTemplate restTemplate;

    private final CourseService courseService;
    @Value("${external-apis.documents-service.urls.path.docByCourseIdPath}")
    private String documentsServicePath;
    @Value("${external-apis.documents-service.urls.host}")
    private String documentsHost;

    @Value("${external-apis.classes-service.urls.path.classesByCourseIdPath}")
    private String classesByCourseIdPath;
    @Value("${external-apis.classes-service.urls.host}")
    private String classesHost;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
//
//    @GetMapping("/call-class-service")
//    public String callClassService() {
//        String res = courseService.fetchFromClassService();
//        System.out.println(res);
//        return res;
//    }
//
//    @GetMapping("/call-document-service")
//    public String callDocumentService() {
//        String res = courseService.fetchFromDocumentService();
//        System.out.println(res);
//        return res;
//    }

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


//
//    @GetMapping("/{courseId}/classes")
//    public ResponseEntity<List<Classes>> getClassesByCourseId(@PathVariable int courseId) {
//        String classServiceUrl = classesHost + classesByCourseIdPath + courseId;
//        ResponseEntity<List<Classes>> response = restTemplate.getForEntity(classServiceUrl, (Class<List<Classes>>)(Class<?>)List.class);
//        return response;
//    }
    @GetMapping("/{courseId}/classes")
    public ResponseEntity<List<Classes>> getClassesByCourseId(@PathVariable int courseId) {
    String classServiceUrl = classesHost + classesByCourseIdPath + courseId;
    ResponseEntity<List<Classes>> response = restTemplate.exchange(classServiceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Classes>>() {});
    return response;
}
    @GetMapping("/{courseId}/documents")
    public ResponseEntity<List<Document>> getCourseDocuments(@PathVariable Long courseId) {
        String documentServiceUrl = documentsHost + documentsServicePath + courseId;
        ResponseEntity<List<Document>> response = restTemplate.getForEntity(documentServiceUrl, (Class<List<Document>>)(Class<?>)List.class);
        return response;
    }
//    public ResponseEntity<List<CourseDocuments>> getDocumentsByCourseId(@RequestParam Integer courseId) {
//        List<CourseDocuments> documents = courseService.getCourseDocumentsByCourseId(courseId);
//        if (documents.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(documents);
//    }
}






