package sda.remote.employeesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.remote.employeesapi.model.Department;
import sda.remote.employeesapi.service.DepartmentService;

import java.util.List;

@CrossOrigin
@RestController
public class DepartmentRestController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return service.getDepartments();
    }

    @PostMapping("/departments/addnew")
    public void addDepartment(@RequestBody Department department){ service.addDepartment(department);
    }

    @PutMapping("/departments/{id}/edit")
    public void updateDepartment(@PathVariable("id") Integer id,@RequestBody Department department){
        service.updateDepartment(department);
    }

    @DeleteMapping("/departments/{id}/delete")
    public void deleteDepartment(@PathVariable("id") Integer id){
        service.deleteDepartment(id);
    }


}
