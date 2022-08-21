package com.faboda.fab.services;


import com.faboda.fab.model.Faculty;
import com.faboda.fab.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    public void saveFaculty(Faculty faculty) {
        try {
            facultyRepository.save(faculty);
        }

        catch (Exception ex) {
        }
    }



}
