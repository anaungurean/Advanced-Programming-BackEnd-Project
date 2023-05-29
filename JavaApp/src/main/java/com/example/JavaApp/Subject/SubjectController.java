package com.example.JavaApp.Subject;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@CrossOrigin(origins = "http://localhost:3000")

public class SubjectController {

    private final SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    @Operation(summary = "List the subjects", description = "Used to list the subjects to select the subject for which will be taken the quiz")
//    public List<Subject> getAllSubjects() {
//          return subjectService.getAllSubjects();
//    } // pt java
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    } //de eliminat


    @PostMapping("/create")
    @Operation(summary = "Add a new subject" )
    public ResponseEntity<String> createSubject(@RequestBody Subject subject) {
        try {
            subjectService.addSubject(subject);
            return ResponseEntity.ok("Subject created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create subject");
        }
    }

}
