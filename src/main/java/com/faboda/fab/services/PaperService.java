package com.faboda.fab.services;


import com.faboda.fab.exceptions.ResourceNotFound;
import com.faboda.fab.model.Paper;
import com.faboda.fab.repository.ModuleRepository;
import com.faboda.fab.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PaperService {

    @Autowired
    PaperRepository paperRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public Paper storePaper(MultipartFile File, Long moduleID) {
        String paperName = StringUtils.cleanPath(File.getOriginalFilename());

        try {

            if (paperName.contains("..")) {
                throw new ResourceNotFound("File Not Valid");
            }

            Paper dbPaper = new Paper(paperName, File.getContentType(),File.getBytes());
            moduleRepository.findById(moduleID).map(
                    module->{
                        dbPaper.setModule(module);
                        return paperRepository.save(dbPaper);
                    }
            );

        } catch (IOException e) {
            throw new ResourceNotFound(e.getMessage());
        }

        return null;
    }






}
