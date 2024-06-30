package controller;

import models.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import service.DocumentsService;


@RestController
@RequestMapping("/api/documents")
public class DocumentsController {

//        @Autowired
//        private DocumentsService documentsService;

        @GetMapping(" ")
        public List<Documents> getDocuments() {
            return documentsService.getAllDocuments();
        }

        @GetMapping("/{documentId}")
        public ResponseEntity<Documents> getDocumentById(@PathVariable int documentId) {
            Optional<Documents> documents = Optional.ofNullable(documentsService.getDocumentsById(documentId));
            if (documents.isPresent()) {
                return ResponseEntity.ok(documents.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
            // Endpoint to create a new document
            @PostMapping
            public void createDocument(@RequestBody Documents documents)
            {
//                documentsService.CreateDocument(documents);
            }

//            @PutMapping("/{documenetId}")
//            public ResponseEntity<Documents> updateDocuments(@PathVariable int documentId, @RequestBody Documents updatedDocuments) {
//                Optional<Documents> documents = Optional.ofNullable(documentsService.getDocumentsById(documentId));
//                if (documents.isPresent()) {
//                   updatedDocuments.setDocuments_id(documentId); // Ensure the ID is set correctly
//                   Documents savedDocuments = documentsService.saveDocuments(updatedDocuments);
//                   return ResponseEntity.ok(savedDocuments);
//               } else {
//                   return ResponseEntity.notFound().build();
//               }
//            }

            @DeleteMapping("/{documentId}")
             public ResponseEntity<Void> deleteDocuments(@PathVariable int documentId) {
                Optional<Documents> documents = Optional.ofNullable(documentsService.getDocumentsById(documentId));
                if (documents.isPresent()) {
                  documentsService.deleteDocuments(documentId);
                  return ResponseEntity.noContent().build();
               } else {
                  return ResponseEntity.notFound().build();
               }
             }

         }



