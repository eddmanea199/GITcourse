package sda.remote.employeesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.remote.employeesapi.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
