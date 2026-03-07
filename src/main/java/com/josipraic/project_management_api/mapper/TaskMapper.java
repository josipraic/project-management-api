package com.josipraic.project_management_api.mapper;

import com.josipraic.project_management_api.dto.TaskCreateRequest;
import com.josipraic.project_management_api.dto.TaskResponse;
import com.josipraic.project_management_api.dto.TaskUpdateRequest;
import com.josipraic.project_management_api.entity.Project;
import com.josipraic.project_management_api.entity.Task;


public class TaskMapper {

    private TaskMapper() {}

    public static Task toEntity(TaskCreateRequest request, Project project) {

        return Task.builder()
                .title(request.title())
                .description(request.description())
                .status(request.status())
                .project(project)
                .build();
    }

    public static void updateEntity(Task task, TaskUpdateRequest request) {

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());
    }

    public static TaskResponse toResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getProject().getId(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
