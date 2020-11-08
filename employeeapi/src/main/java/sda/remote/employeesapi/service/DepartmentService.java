package sda.remote.employeesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.remote.employeesapi.model.Department;
import sda.remote.employeesapi.model.Employee;
import sda.remote.employeesapi.repository.DepartmentRepository;
import sda.remote.employeesapi.repository.EmployeeRepository;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> getDepartments(){
        return repository.findAll();
    }

    public void addDepartment(Department department){
        repository.save(department);
    }

    public void updateDepartment(Department department){
        repository.save(department);
    }

    public void deleteDepartment(Integer id){
        repository.deleteById(id);
    }
}
