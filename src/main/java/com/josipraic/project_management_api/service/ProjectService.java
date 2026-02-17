package com.josipraic.project_management_api.service;

import com.josipraic.project_management_api.dto.ProjectCreateRequest;
import com.josipraic.project_management_api.dto.ProjectResponse;
import com.josipraic.project_management_api.dto.ProjectUpdateRequest;
import com.josipraic.project_management_api.entity.Project;
import com.josipraic.project_management_api.mapper.ProjectMapper;
import com.josipraic.project_management_api.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectResponse create(ProjectCreateRequest request) {
        if (projectRepository.existsByNameIgnoreCase(request.name())) {
            throw new IllegalArgumentException("Project with this name allready exists");
        }

        Project project = ProjectMapper.toEntity(request);
        Project saved = projectRepository.save(project);

        return ProjectMapper.toResponse(saved);
    }

    public ProjectResponse getById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        return ProjectMapper.toResponse(project);
    }

    public Page<ProjectResponse> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable)
                .map(ProjectMapper::toResponse);
    }

    public ProjectResponse update(Long id, ProjectUpdateRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        if (!project.getName().equalsIgnoreCase(request.name())
                && projectRepository.existsByNameIgnoreCase(request.name())) {
            throw new IllegalArgumentException("Project with this name already exists");
        }

        ProjectMapper.updateEntity(project, request);

        return ProjectMapper.toResponse(project);
    }

    public void delete(Long id) {
        if(!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}
