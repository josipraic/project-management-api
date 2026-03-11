package com.josipraic.project_management_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.josipraic.project_management_api.dto.TaskCreateRequest;
import com.josipraic.project_management_api.dto.TaskResponse;
import com.josipraic.project_management_api.dto.TaskUpdateRequest;
import com.josipraic.project_management_api.entity.Project;
import com.josipraic.project_management_api.entity.Task;
import com.josipraic.project_management_api.exception.ResourceNotFoundException;
import com.josipraic.project_management_api.mapper.TaskMapper;
import com.josipraic.project_management_api.repository.ProjectRepository;
import com.josipraic.project_management_api.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskResponse create(Long projectId, TaskCreateRequest request) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        Task task = TaskMapper.toEntity(request, project);
        Task saved = taskRepository.save(task);

        return TaskMapper.toResponse(saved);
    }

    public Page<TaskResponse> getAllByProject(Long projectId, Pageable pageable) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project not found");
        }

        return taskRepository.findByProjectId(projectId, pageable)
                .map(TaskMapper::toResponse);
    }

    public TaskResponse update(Long id, TaskUpdateRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        TaskMapper.updateEntity(task, request);

        return TaskMapper.toResponse(task);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found");
        }

        taskRepository.deleteById(id);
    }
}
