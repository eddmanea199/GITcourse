package sda.remote.employeesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.remote.employeesapi.model.Employee;
import sda.remote.employeesapi.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployees(){
          return repository.findAll();
    }

    public void addEmployee(Employee employee){
           repository.save(employee);
    }

    public void updateEmployee(Employee employee){
           repository.save(employee);
    }

    public void deleteEmployee(Integer id){
           repository.deleteById(id);
    }
}
