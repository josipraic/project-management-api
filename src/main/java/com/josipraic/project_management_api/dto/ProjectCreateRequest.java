package com.josipraic.project_management_api.dto;

import com.josipraic.project_management_api.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectCreateRequest (
        @NotBlank
        @Size(min = 3, max = 100)
        String name,

        @Size(min = 1000)
        String description,

        ProjectStatus status
) { }
