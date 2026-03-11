package com.josipraic.project_management_api.controller;

import com.josipraic.project_management_api.dto.TaskCreateRequest;
import com.josipraic.project_management_api.dto.TaskResponse;
import com.josipraic.project_management_api.dto.TaskUpdateRequest;
import com.josipraic.project_management_api.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/api/projects/{projectId}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(
            @PathVariable Long projectId,
            @Valid @RequestBody TaskCreateRequest request
    ) {
        return taskService.create(projectId, request);
    }

    @GetMapping("/api/projects/{projectId}/tasks")
    public Page<TaskResponse> getAllByProject(
            @PathVariable Long projectId,
            Pageable pageable
    ) {
        return taskService.getAllByProject(projectId, pageable);
    }

    @PutMapping("/api/tasks/{id}")
    public TaskResponse update(
            @PathVariable Long id,
            @Valid @RequestBody TaskUpdateRequest request
    ) {
        return taskService.update(id, request);
    }

    @DeleteMapping("/api/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}