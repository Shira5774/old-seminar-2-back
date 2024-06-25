package com.diversi_tech.demo.service;

import com.diversi_tech.demo.model.Classes;
import com.diversi_tech.demo.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    public Optional<Classes> GetClassesByCourse(int id) {
        return classesRepository.findById(id);
    }
    public void AddClass(Classes classes) {
        classesRepository.save(classes);
    }
    public void UpdateClass(int id,Classes classes) {
        classesRepository.save(classes);
    }
    public void DeleteClass(int id) {
        classesRepository.deleteById(id);
    }

    @Value("${api.courses-service.course-url}")
    private String classUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public ClassesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callService2() {
        String url = classUrl + "/class";
        return restTemplate.getForObject(url, String.class);
    }
}
