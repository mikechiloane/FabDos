package com.faboda.fab.model;

import javax.persistence.*;


@Entity
@Table(name="Modules")
public class Module {
    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_name",nullable = false)
    private String moduleName;
    @Column(name = "module_code",nullable = false)
    private String moduleCode;
    @Column(name = "module_semester",nullable = false)
    private String semester;

    @ManyToOne
    @JoinColumn(name = "faculty_id",nullable = false)
    private Faculty faculty;


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }


    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
