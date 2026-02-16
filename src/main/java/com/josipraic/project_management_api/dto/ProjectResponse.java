package com.josipraic.project_management_api.dto;

import com.josipraic.project_management_api.entity.ProjectStatus;

import java.time.Instant;

public record ProjectResponse (
        Long id,
        String name,
        String description,
        ProjectStatus status,
        Instant createdAt,
        Instant updatedAt
) { }
