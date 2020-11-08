package sda.remote.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.remote.springboot.model.Employee;
import sda.remote.springboot.model.Project;
import sda.remote.springboot.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        this.projectRepository.save(project);
    }

    @Override
    public Project getProjectById(int id) {
        Optional<Project> optional=projectRepository.findById(id);
        Project project=null;
        if (optional.isPresent())
        {
            project=optional.get();
        }
        else{
            throw new RuntimeException("Project not found for id ::"+id);
        }
        return project;
    }

    @Override
    public void deleteProjectById(int id) {

    }
}
