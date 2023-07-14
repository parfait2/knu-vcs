package com.example.knu_vcs.controller;

import com.example.knu_vcs.domain.Version;
import com.example.knu_vcs.dto.AddVersionRequestDto;
import com.example.knu_vcs.dto.UpdateVersionRequestDto;
import com.example.knu_vcs.dto.VersionResponseDto;
import com.example.knu_vcs.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VersionController {

    private final VersionService versionService;

    @PostMapping("/vercontrol/save")
    public ResponseEntity<Version> addArticle(@RequestBody AddVersionRequestDto addVersionRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(versionService.save(addVersionRequestDto));
    }

    @GetMapping("/vercontrol/getConfigAll")
    public ResponseEntity<List<Version>> findAllArticles() {

        List<Version> versions = versionService.selectAll();

        return ResponseEntity.ok().body(versions);
    }

    @GetMapping("/vercontrol/getConfig/{id}")
    public ResponseEntity<VersionResponseDto> findVersion(@PathVariable("id") Long id) {
        System.out.println(id);
        System.out.println(versionService.findById(id).getVer());
        System.out.println(new VersionResponseDto(versionService.findById(id)).getVer());
        return ResponseEntity.ok()
                .body(new VersionResponseDto(versionService.findById(id)));
    }

      /**
     * 삭제
     */
    @PutMapping("/vercontrol/deleteConfig/{id}")
    public ResponseEntity<Version> updateArticle(@PathVariable("id") Long id) {
        Version deletedVersion = versionService.delete(id);

        return ResponseEntity.ok().body(deletedVersion);
    }


    // update 기능
    @PutMapping("/vercontrol/getConfig/{id}")
    public ResponseEntity<Version> updateArticle(@PathVariable("id") Long id,
                                                 @RequestBody UpdateVersionRequestDto requestDto) {
        Version updatedVersion = versionService.update(id, requestDto);
        return ResponseEntity.ok().body(updatedVersion);

    }

}
