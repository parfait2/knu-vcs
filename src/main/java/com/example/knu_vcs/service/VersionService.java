package com.example.knu_vcs.service;

import com.example.knu_vcs.domain.Version;
import com.example.knu_vcs.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VersionService {

    private final VersionRepository versionRepository;

    public List<Version> findAll() {
        return versionRepository.findAll();
    }

    public Version findById(Long id) {
        return versionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("version not exist! : " + id));
    }

}
