package com.ovkrs.projectboard.web;

import com.ovkrs.projectboard.domain.ProjectTask;
import com.ovkrs.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
   @Autowired
   private ProjectTaskService projectTaskService;

   @PostMapping("")
   public ResponseEntity<?> addPTToBoard(@Valid  @RequestBody ProjectTask projectTask, BindingResult result){

       // validation the result
       if(result.hasErrors()){
           Map<String,String> errormap = new HashMap<>();

           for (FieldError error: result.getFieldErrors()){

               // map the error messages and error fields
               errormap.put(error.getField(), error.getDefaultMessage());

           }
           return new ResponseEntity<Map<String , String>>(errormap, HttpStatus.BAD_REQUEST);

       }
       ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask); // save the request projectTask in db
       return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED); // return the complete project entity

   }

   @GetMapping("/all")
    public Iterable<ProjectTask> getAllPTs(){
       return projectTaskService.getAll();
   }

   @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
       ProjectTask projectTask = projectTaskService.getById(pt_id);
       return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK); // return the complete project entity

   }

}