package kz.dara.cameralcontrol.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.dara.cameralcontrol.model.Project;
import kz.dara.cameralcontrol.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/project", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Project", description = "Project management resource")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody Project Project) {
        return projectService.createProject(Project);
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @GetMapping
    public Page<Project> getAllProjects(Pageable pageable) {
        return projectService.getAllProjects(pageable);
    }

    @PutMapping
    public Project updateProject(@RequestBody Project Project) {
        return projectService.updateProject(Project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }


}
