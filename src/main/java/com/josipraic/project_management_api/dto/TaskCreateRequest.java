package com.josipraic.project_management_api.dto;

import com.josipraic.project_management_api.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;

public record TaskCreateRequest(
      @NotBlank
      String title,

      String description,

      TaskStatus status
) {}
