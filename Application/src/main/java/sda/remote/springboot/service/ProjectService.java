package sda.remote.springboot.service;

import org.springframework.stereotype.Service;
import sda.remote.springboot.model.Project;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> getAllProjects();
    void saveProject(Project project);
    Project getProjectById(int id);
    void deleteProjectById(int id);
}
