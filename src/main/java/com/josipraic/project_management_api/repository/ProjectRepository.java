package com.josipraic.project_management_api.repository;

import com.josipraic.project_management_api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByNameIgnoreCase(String name);
}
