package sda.remote.employeesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.remote.employeesapi.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
