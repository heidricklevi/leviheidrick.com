package com.ljheidrick.backend.repository;

import com.ljheidrick.backend.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
