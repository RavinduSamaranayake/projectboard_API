package com.ovkrs.projectboard.service;

import com.ovkrs.projectboard.domain.ProjectTask;
import com.ovkrs.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    //we can save and update the project task using this function
    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){

        if(projectTask.getStatus()== null || projectTask.getStatus()== ""){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);

    }


    public Iterable<ProjectTask> getAll(){

        return projectTaskRepository.findAll();

    }

    public ProjectTask getById(Long id){

        //  return projectTaskRepository.findById(id);  this is not work because of findById is optional so
        //  we create abstract method in ProjectTaskRepository
        return projectTaskRepository.getProjectTaskById(id);
    }


    // delete project Task
    public void deleteProjectTask(Long id){
        ProjectTask projectTask = getById(id);
        projectTaskRepository.delete(projectTask);
    }

}