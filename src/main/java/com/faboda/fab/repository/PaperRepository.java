package com.faboda.fab.repository;

import com.faboda.fab.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper,Integer> {


}
