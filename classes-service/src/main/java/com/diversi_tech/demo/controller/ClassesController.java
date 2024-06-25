package com.diversi_tech.demo.controller;

import com.diversi_tech.demo.model.Classes;
import com.diversi_tech.demo.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Classes")
public class ClassesController {

    @Autowired
    ClassesService classesService;

    @GetMapping("/{id}")
    public Optional<Classes> GetClassesByCourse(@PathVariable int id) {
        return classesService.GetClassesByCourse(id);
    }

    @PostMapping()
    public void addClass(@RequestBody Classes classes) {
        classesService.AddClass(classes);
    }

    @PutMapping("/{id}")
    public void UpdateClass(@PathVariable int id, @RequestBody Classes classes) {
        classesService.UpdateClass(id, classes);
    }

    @DeleteMapping("/{id}")
    public void DeleteClass(@PathVariable int id) {
        classesService.DeleteClass(id);
    }

    @GetMapping("/endpoint")
    public String endpoint() {
        return "Response from class Service";
    }
}
