package sda.remote.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.remote.springboot.model.Project;
import sda.remote.springboot.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String viewHomePage(Model model){
        model.addAttribute("ListProjects",projectService.getAllProjects());
        return "projects";
    }
    @GetMapping("/showNewProjectForm")
    public String showNewProjectForm(Model model){
        Project project=new Project();
        model.addAttribute("project",project);
        return "add-project";
    }
    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute("project") Project project){
        projectService.saveProject(project);
        return "redirect:/project";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model){
        Project project= projectService.getProjectById(id);

        model.addAttribute("project",project);
        return "update-project";
    }
    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable(value = "id") int id){
        this.projectService.deleteProjectById(id);
        return "redirect:/project";
    }
}
