package sda.remote.springboot.service;

import org.springframework.stereotype.Service;
import sda.remote.springboot.model.Employee;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee>getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
}
