package sda.remote.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.remote.springboot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
