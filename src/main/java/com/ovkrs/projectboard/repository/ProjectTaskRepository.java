package com.ovkrs.projectboard.repository;

import com.ovkrs.projectboard.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask , Long> {

    ProjectTask getProjectTaskById(Long id);
}