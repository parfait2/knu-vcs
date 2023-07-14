package com.example.knu_vcs.repository;

import com.example.knu_vcs.domain.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Long> {
    @Query("SELECT a from Version a where a.isDeleted = false")
    List<Version> selectAll();
}
