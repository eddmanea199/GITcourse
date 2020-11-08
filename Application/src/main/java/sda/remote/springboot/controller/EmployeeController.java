package sda.remote.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.remote.springboot.model.Employee;
import sda.remote.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@Secured({"ROLE_EMPLOYEE","ROLE_DEPARTMENT","ROLE_PROJECT"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String viewHomePage(Model model){
        model.addAttribute("ListEmployees",employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "add-employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") int id, Model model){
        Employee employee= employeeService.getEmployeeById(id);

        model.addAttribute("employee",employee);
        return "update-employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
}
