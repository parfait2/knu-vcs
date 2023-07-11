package com.example.knu_vcs.controller;

import com.example.knu_vcs.domain.Version;
import com.example.knu_vcs.dto.VersionResponseDto;
import com.example.knu_vcs.service.VersionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class VersionController {

    private final VersionService versionService;

    @GetMapping("/vercontrol/getConfigAll")
    public ResponseEntity<List<VersionResponseDto>> findAllArticles() {

        List<VersionResponseDto> versions = versionService.findAll()
                .stream()
                .map(VersionResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(versions);
    }

    @GetMapping("/vercontrol/getConfig")
    public ResponseEntity<VersionResponseDto> findVersion(@RequestBody Long id) {
        return ResponseEntity.ok()
                .body(new VersionResponseDto(versionService.findById(id)));
    }

}
