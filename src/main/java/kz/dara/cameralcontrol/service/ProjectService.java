package kz.dara.cameralcontrol.service;

import kz.dara.cameralcontrol.model.Project;
import kz.dara.cameralcontrol.repository.primaryDataSourse.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project Project) {
        return projectRepository.save(Project);
    }

    public Project getProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public Project updateProject(Project Project) {
        return projectRepository.save(Project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
