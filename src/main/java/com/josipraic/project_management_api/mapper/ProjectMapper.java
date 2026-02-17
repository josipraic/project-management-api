package com.josipraic.project_management_api.mapper;

import com.josipraic.project_management_api.dto.ProjectCreateRequest;
import com.josipraic.project_management_api.dto.ProjectResponse;
import com.josipraic.project_management_api.dto.ProjectUpdateRequest;
import com.josipraic.project_management_api.entity.Project;

public class ProjectMapper {

    private ProjectMapper() {}

    public static Project toEntity(ProjectCreateRequest request) {
        if(request == null) return null;

        return Project.builder()
                .name(request.name())
                .description(request.description())
                .status(request.status())
                .build();
    }

    public static void updateEntity(Project project, ProjectUpdateRequest request) {
        project.setName(request.name());
        project.setDescription(request.description());
        project.setStatus(request.status());
    }

    public static ProjectResponse toResponese(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStatus(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }
}
