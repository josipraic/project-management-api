package com.josipraic.project_management_api.dto;

import com.josipraic.project_management_api.entity.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjectUpdateRequest (
        @NotBlank
        @Size(min = 3, max = 100)
        String name,

        @Size(max = 1000)
        String description,

        @NotNull
        ProjectStatus status
) { }
