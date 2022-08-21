package com.faboda.fab.controller;

import com.faboda.fab.model.Faculty;
import com.faboda.fab.repository.FacultyRepository;
import com.faboda.fab.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    FacultyService facultyService;

    @GetMapping
    @CrossOrigin("http://localhost:3000")
    private List<Faculty> faculties() {
        return (List<Faculty>) facultyRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> saveFaculty(@RequestBody @Validated Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return ResponseEntity.ok("faculty has been created");

    }




}
