package com.ljheidrick.backend.repository;

import com.ljheidrick.backend.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}
