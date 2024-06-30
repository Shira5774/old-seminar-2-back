package com.diversitech.classesservice.controller;

import com.diversitech.classesservice.model.Classes;
//import com.diversitech.classesservice.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

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
    public List<Classes> classesList = new ArrayList<>();

    public ClassesController() {

        // Create instances of Classes and add them to the list
        Classes classes1 = new Classes(1, 101, "Class A", "Introduction to Programming", new Date(), new Date());
        Classes classes2 = new Classes(2, 102, "Class B", "Data Structures and Algorithms", new Date(), new Date());
        Classes classes3 = new Classes(3, 103, "Class C", "Database Management", new Date(), new Date());

        classesList.add(classes1);
        classesList.add(classes2);
        classesList.add(classes3);
    }

    @GetMapping
    public List<Classes> GetClassesByCourseId(@RequestParam String course_id) {

        return classesList;
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