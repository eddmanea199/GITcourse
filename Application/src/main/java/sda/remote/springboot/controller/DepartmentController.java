package sda.remote.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.remote.springboot.model.Department;
import sda.remote.springboot.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String viewHomePage(Model model){
        model.addAttribute("ListDepartments",departmentService.getAllDepartments());
        return "departments";
    }
    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model){
        Department department=new Department();
        model.addAttribute("department",department);
        return "add-department";
    }
    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.saveDepartment(department);
        return "redirect:/department";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model){
        Department department= departmentService.getDepartmentById(id);

        model.addAttribute("department",department);
        return "update-department";
    }
    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable(value = "id") int id){
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/department";
    }
}
