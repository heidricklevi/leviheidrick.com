package com.ljheidrick.backend.repository;

import com.ljheidrick.backend.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
}
