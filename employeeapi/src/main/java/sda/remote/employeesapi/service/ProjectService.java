package sda.remote.employeesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.remote.employeesapi.model.Project;
import sda.remote.employeesapi.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    public List<Project> getProjects(){
        return repository.findAll();
    }

    public void addProject(Project project){
        repository.save(project);
    }

    public void updateProject(Project project){
        repository.save(project);
    }

    public void deleteProject(Integer id){
        repository.deleteById(id);
    }
}
