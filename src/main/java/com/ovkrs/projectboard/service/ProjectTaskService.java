package com.ovkrs.projectboard.service;

import com.ovkrs.projectboard.domain.ProjectTask;
import com.ovkrs.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){

        if(projectTask.getStatus()== null || projectTask.getStatus()== ""){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);

    }


}