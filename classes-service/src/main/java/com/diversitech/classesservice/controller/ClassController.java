package com.diversitech.classesservice.controller;

import com.diversitech.classesservice.model.Classes;
//import com.diversitech.classesservice.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

//    private final ClassService classService;
//
//    @Autowired
//    public ClassController(ClassService classService) {
//        this.classService = classService;
//    }

//    @GetMapping("/call-course-service")
//    public String callCourseService() {
//        String res = classService.fetchFromCourseService();
//        System.out.println(res);
//        return res;
//    }


    @GetMapping("")
    public List<Classes> GetClassesByCourse(@PathVariable int course_id) {

        return null;
    }

    @PostMapping()
    public void addClass(@RequestBody Classes classes) {
//        classService.AddClass(classes);
    }

    @PutMapping("/{id}")
    public void UpdateClass(@PathVariable int id, @RequestBody Classes classes) {
//        classService.updateClass(id, classes);
    }

    @DeleteMapping("/{id}")
    public void DeleteClass(@PathVariable int id) {
//        classService.DeleteClass(id);
    }
}