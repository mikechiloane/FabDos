package com.faboda.fab.controller;


import com.faboda.fab.model.Paper;
import com.faboda.fab.repository.ModuleRepository;
import com.faboda.fab.services.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/")
public class PaperController {

    @Autowired
    PaperService paperService;

    @Autowired
    ModuleRepository moduleRepository;

    @PostMapping("/{ModuleID}/paper")
    public ResponseEntity<String> uploadFile(@PathVariable(value = "ModuleID") Long moduleID, @RequestParam("file") MultipartFile file, Paper paperRequest) {
        paperService.storePaper(file,moduleID);

        return ResponseEntity.ok("Upload Done");
    }

}
