package com.faboda.fab.repository;
import com.faboda.fab.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {

    List<Module> findAllByFacultyId(Long facultyID);


}
