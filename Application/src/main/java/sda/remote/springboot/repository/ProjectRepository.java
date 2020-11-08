package sda.remote.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.remote.springboot.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
