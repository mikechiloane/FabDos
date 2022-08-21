package com.faboda.fab.controller;

import com.faboda.fab.exceptions.ResourceNotFound;
import com.faboda.fab.model.Module;
import com.faboda.fab.repository.FacultyRepository;
import com.faboda.fab.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping()
    @RequestMapping("/api")
    private List<Module> modules() {
        return (List<Module>) moduleRepository.findAll();
    }

    @PostMapping
    @RequestMapping("/faculty/{facultyID}/module")
    private Module saveModule(@PathVariable(value = "facultyID") Long facultyID, @RequestBody @Validated Module moduleRequest) {

        return facultyRepository.findById(facultyID).map(
                        faculty -> {
                            moduleRequest.setFaculty(faculty);
                            return moduleRepository.save(moduleRequest);
                        })
                .orElseThrow(() -> new ResourceNotFound("resource not found"));


    }

}
