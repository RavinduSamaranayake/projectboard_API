package com.ovkrs.projectboard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "summary cannot be blank ") //validation the summary field
    private String summary;
    @NotBlank(message = "accept criteria cannot be blank ") //validation the accept criteria field
    private String acceptCriteria;
    private String status;

    public ProjectTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAcceptCriteria() {
        return acceptCriteria;
    }

    public void setAcceptCriteria(String acceptCriteria) {
        this.acceptCriteria = acceptCriteria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
