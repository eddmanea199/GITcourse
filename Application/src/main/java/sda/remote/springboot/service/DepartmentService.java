package sda.remote.springboot.service;

import org.springframework.stereotype.Service;
import sda.remote.springboot.model.Department;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(int id);
    void deleteDepartmentById(int id);
}
