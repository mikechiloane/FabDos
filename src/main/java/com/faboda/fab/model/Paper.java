package com.faboda.fab.model;

import javax.persistence.*;

@Entity
@Table(name = "Paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "paper_name", unique = true)
    private String paperName;

    @Column(name = "paper_type", nullable = true)
    private String paperType;

    @Column(name = "paper_date", nullable = true)
    private String paperDate;

    @Lob
    @Column(name = "document_data")
    private byte [] data;

    @ManyToOne
    @JoinColumn(name = "module_id",nullable = false)
    private Module module;

    public Paper(String paperName, String paperType, byte [] data) {
        this.paperName = paperName;
        this.paperType = paperType;
        this.data = data;
    }

    public Paper() {
    }


    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperDate() {
        return paperDate;
    }

    public void setPaperDate(String paperDate) {
        this.paperDate = paperDate;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}