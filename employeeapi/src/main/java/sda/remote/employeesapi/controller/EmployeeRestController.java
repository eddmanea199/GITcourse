package sda.remote.employeesapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.remote.employeesapi.model.Employee;
import sda.remote.employeesapi.service.EmployeeService;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
       return service.getEmployees();
    }

    @PostMapping("/employees/addnew")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @PutMapping("/employees/{id}/edit")
    public void updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}/delete")
    public void deleteEmployee(@PathVariable("id") Integer id){
        service.deleteEmployee(id);
    }
}
