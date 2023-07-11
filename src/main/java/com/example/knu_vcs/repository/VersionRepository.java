package com.example.knu_vcs.repository;

import com.example.knu_vcs.domain.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {
}
