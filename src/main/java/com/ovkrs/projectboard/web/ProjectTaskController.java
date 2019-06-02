package com.ovkrs.projectboard.web;

import com.ovkrs.projectboard.domain.ProjectTask;
import com.ovkrs.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
   @Autowired
   private ProjectTaskService projectTaskService;

   @PostMapping("")
   public ResponseEntity<?> addPTToBoard(@RequestBody ProjectTask projectTask){

       ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask); // save the request projectTask in db
       return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
   }
}