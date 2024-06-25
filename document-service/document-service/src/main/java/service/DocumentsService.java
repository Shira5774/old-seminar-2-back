package service;

import models.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.web.client.RestTemplate;
import repositroy.IRepositroyDocumens;


@Service
public class DocumentsService {


    @Autowired
    private IRepositroyDocumens documentsRepository;

    public Documents getDocumentsById(int documents_id) {
        return documentsRepository.findById(documents_id).orElse(null);
    }

    public List<Documents> getAllDocuments() {
        return documentsRepository.findAll();
    }
    public Documents saveDocuments(Documents documents) {
        return documentsRepository.save(documents);
    }

    public void deleteDocuments(int id) {
        documentsRepository.deleteById(id);
    }

    public void CreateDocument(Documents documents) {
    }

    @Value("${api.courses-service.course-url}")
    private String documentUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public DocumentsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callService2() {
        String url = documentUrl + "/document";
        return restTemplate.getForObject(url, String.class);
    }
}


