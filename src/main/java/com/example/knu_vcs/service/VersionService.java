package com.example.knu_vcs.service;

import com.example.knu_vcs.domain.Version;
import com.example.knu_vcs.dto.AddVersionRequestDto;
import com.example.knu_vcs.dto.UpdateVersionRequestDto;
import com.example.knu_vcs.dto.VersionResponseDto;
import com.example.knu_vcs.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Version save(AddVersionRequestDto requestDto) {
        return versionRepository.save(requestDto.toEntity()); // dto 형태로 저장할 수 없다.

    }

    // update - 수정하는 코드 넣기
    @Transactional
    public Version update(Long id, UpdateVersionRequestDto requestDto) {
        // step 1. 기존 등록된 글 가져오기
        Version version = versionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("article not exist! : " + id));
        // step 2. 원하는 내용으로 수정
        version.update(requestDto.getOs(), requestDto.getVer(), requestDto.getUpdatetype(), requestDto.getMessage());
        return version;
    }
}
