package com.josipraic.project_management_api.dto;

import com.josipraic.project_management_api.entity.TaskStatus;

import java.time.OffsetDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Long projectId,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}
