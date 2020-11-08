package sda.remote.employeesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.remote.employeesapi.model.Project;
import sda.remote.employeesapi.service.ProjectService;

import java.util.List;

@CrossOrigin
@RestController
public class ProjectRestController {

    @Autowired
    private ProjectService service;

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return service.getProjects();
    }

    @PostMapping("/projects/addnew")
    public void addProject(@RequestBody Project project){
        service.addProject(project);
    }

    @PutMapping("/projects/{id}/edit")
    public void updateProject(@PathVariable("id") Integer id,@RequestBody Project project){
        service.updateProject(project);
    }

    @DeleteMapping("/projects/{id}/delete")
    public void deleteProject(@PathVariable("id") Integer id){ service.deleteProject(id);
    }
}
